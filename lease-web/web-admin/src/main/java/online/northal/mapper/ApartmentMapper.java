package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.entity.ApartmentInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApartmentMapper extends BaseMapper<ApartmentInfo> {
}
