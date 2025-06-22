package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.entity.FacilityInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {
    List<FacilityInfo> selectListByApartmentId(Long id);
}
