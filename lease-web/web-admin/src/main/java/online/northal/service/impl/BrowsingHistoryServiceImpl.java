package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.ApartmentFacility;
import online.northal.entity.BrowsingHistory;
import online.northal.mapper.ApartmentFacilityMapper;
import online.northal.mapper.BrowsingHistoryMapper;
import online.northal.service.ApartmentFacilityService;
import online.northal.service.BrowsingHistoryService;
import org.springframework.stereotype.Service;

@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory> implements BrowsingHistoryService {
}
