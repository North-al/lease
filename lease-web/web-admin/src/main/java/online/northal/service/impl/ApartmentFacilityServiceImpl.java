package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.ApartmentFacility;
import online.northal.mapper.ApartmentFacilityMapper;
import online.northal.service.ApartmentFacilityService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentFacilityServiceImpl extends ServiceImpl<ApartmentFacilityMapper, ApartmentFacility> implements ApartmentFacilityService {
}
