package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.ApartmentInfo;
import online.northal.mapper.ApartmentMapper;
import online.northal.service.ApartmentService;
import online.northal.vo.ApartmentSubmitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApartmentServiceImpl extends ServiceImpl<ApartmentMapper, ApartmentInfo> implements ApartmentService {

    @Autowired
    private ApartmentMapper apartmentMapper;

    @Override
    @Transactional
    public void create(ApartmentSubmitVo vo) {

    }
}
