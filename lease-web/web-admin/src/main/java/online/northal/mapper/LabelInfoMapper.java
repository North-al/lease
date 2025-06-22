package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.entity.LabelInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {
    List<LabelInfo> selectListByApartmentId(Long id);
}
