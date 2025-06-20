package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.City;
import online.northal.entity.Province;
import online.northal.mapper.CityMapper;
import online.northal.mapper.ProvinceMapper;
import online.northal.service.CityService;
import online.northal.service.ProvinceService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
}
