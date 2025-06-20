package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.entity.FeeKey;
import online.northal.vo.FeeKeyWithValueVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeeKeyMapper extends BaseMapper<FeeKey> {

    List<FeeKeyWithValueVo> getAllWithValues();
}
