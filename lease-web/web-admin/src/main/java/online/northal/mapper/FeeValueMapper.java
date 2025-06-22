package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.entity.FeeValue;
import online.northal.vo.FeeValueVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    List<FeeValueVo> selectListByApartmentId(Long id);
}
