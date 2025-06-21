package online.northal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.northal.entity.BrowsingHistory;
import online.northal.entity.GraphInfo;
import online.northal.mapper.BrowsingHistoryMapper;
import online.northal.mapper.GraphMapper;
import online.northal.service.BrowsingHistoryService;
import online.northal.service.GraphService;
import org.springframework.stereotype.Service;

@Service
public class GraphServiceImpl extends ServiceImpl<GraphMapper, GraphInfo> implements GraphService {
}
