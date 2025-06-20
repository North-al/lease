package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.Province;
import online.northal.mapper.ProvinceMapper;
import online.northal.service.ProvinceService;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper,Province> implements ProvinceService {
}
