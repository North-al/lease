package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.AttrKey;
import online.northal.mapper.AttrKeyMapper;
import online.northal.service.AttrKeyService;
import online.northal.vo.AttrKeyWithValueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey> implements AttrKeyService {
    @Autowired
    private AttrKeyMapper attrKeyMapper;

    @Override
    public List<AttrKeyWithValueVo> getAllWithValues() {
        return attrKeyMapper.getAllWithValues();
    }
}
