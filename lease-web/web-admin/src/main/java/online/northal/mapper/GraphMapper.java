package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.entity.GraphInfo;
import online.northal.enums.GraphItemType;
import online.northal.vo.GraphVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GraphMapper extends BaseMapper<GraphInfo> {
    List<GraphVo> selectListByItemIdAndType(Long id, GraphItemType graphItemType);
}
