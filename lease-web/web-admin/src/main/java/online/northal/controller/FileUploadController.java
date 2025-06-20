package online.northal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.result.ActionResult;
import online.northal.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@Tag(name = "文件上传", description = "文件上传相关接口")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    @Operation(summary = "文件上传")
    public ActionResult<String> upload(@RequestParam MultipartFile file) {
        try {
            String url = fileService.upload(file);
            return ActionResult.success(url);
        } catch (Exception e) {
            return ActionResult.fail(e.getMessage(), "文件上传失败");
        }
    }
}
