package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.entity.ApartmentInfo;
import online.northal.entity.ApartmentLabel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApartmentLabelMapper extends BaseMapper<ApartmentLabel> {
}
