package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.FeeKey;
import online.northal.mapper.FeeKeyMapper;
import online.northal.service.FeeKeyService;
import online.northal.vo.FeeKeyWithValueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey> implements FeeKeyService {

    @Autowired
    private  FeeKeyMapper feeKeyMapper;

    @Override
    public List<FeeKeyWithValueVo> getAllFeeKeyWithValue() {
        return this.feeKeyMapper.getAllWithValues();
    }
}
