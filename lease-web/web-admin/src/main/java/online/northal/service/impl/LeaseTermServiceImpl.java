package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.LeaseTerm;
import online.northal.mapper.LeaseTermMapper;
import online.northal.service.LeaseTermService;
import org.springframework.stereotype.Service;

@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm> implements LeaseTermService {
}
