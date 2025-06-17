package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.FeeKey;
import online.northal.mapper.FeeKeyMapper;
import online.northal.service.FeeKeyService;
import org.springframework.stereotype.Service;

@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey> implements FeeKeyService {
}
