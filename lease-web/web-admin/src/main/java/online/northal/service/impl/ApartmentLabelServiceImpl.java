package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.ApartmentLabel;
import online.northal.mapper.ApartmentLabelMapper;
import online.northal.service.ApartmentLabelService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentLabelServiceImpl extends ServiceImpl<ApartmentLabelMapper, ApartmentLabel> implements ApartmentLabelService {
}
