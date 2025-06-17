package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.FeeKey;
import online.northal.entity.FeeValue;
import online.northal.mapper.FeeKeyMapper;
import online.northal.mapper.FeeValueMapper;
import online.northal.service.FeeKeyService;
import online.northal.service.FeeValueService;
import org.springframework.stereotype.Service;

@Service
public class FeeValueServiceImpl extends ServiceImpl<FeeValueMapper, FeeValue> implements FeeValueService {
}
