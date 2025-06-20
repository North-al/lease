package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.City;
import online.northal.entity.District;
import online.northal.mapper.CityMapper;
import online.northal.mapper.DistrictMapper;
import online.northal.service.CityService;
import online.northal.service.DistrictService;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, District> implements DistrictService {
}
