package online.northal.service.impl;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.SetBucketPolicyArgs;
import io.minio.errors.*;
import online.northal.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class FileServiceImpl implements FileService {
    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Autowired
    private MinioClient minioClient;


    private Boolean bucketExists(BucketExistsArgs bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return minioClient.bucketExists(bucketName);
    }

    private String createBucketPolicyConfig(String bucketName) {
        return String.format(
                "{\n" +
                        "\"Statement\" : [ {\n" +
                        "\"Action\" : \"s3:GetObject\",\n" +
                        "\"Effect\" : \"Allow\",\n" +
                        "\"Principal\" : \"*\",\n" +
                        "\"Resource\" : \"arn:aws:s3:::%s/*\"\n" +
                        "} ],\n" +
                        "\"Version\" : \"2012-10-17\"\n" +
                        "}", bucketName);
    }

    @Override
    public String upload(MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        BucketExistsArgs bucketExistsArgs = BucketExistsArgs.builder().bucket(bucketName).build();
            Boolean bucketedExists = this.bucketExists(bucketExistsArgs);
            if (!bucketedExists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config(this.createBucketPolicyConfig(this.bucketName)).build());
            }

            String fileType = Objects.requireNonNull(file.getContentType()).split("/")[0]; // 获取文件类型
            String dateFolder = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); // 获取当前日期
            String filename = String.format("%s/%s/%s", fileType, dateFolder, System.currentTimeMillis() + "_" + file.getOriginalFilename());


            minioClient.putObject(
                    io.minio.PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(filename)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );

            return String.format("%s/%s/%s", endpoint, bucketName, filename);

    }
}
