package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.LabelInfo;
import online.northal.mapper.LabelInfoMapper;
import online.northal.service.LabelInfoService;
import org.springframework.stereotype.Service;

@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo> implements LabelInfoService {
}
