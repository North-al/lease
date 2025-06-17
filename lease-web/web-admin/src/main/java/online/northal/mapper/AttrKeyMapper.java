package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.northal.entity.AttrKey;
import online.northal.vo.AttrKeyWithValueVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttrKeyMapper extends BaseMapper<AttrKey> {
    List<AttrKeyWithValueVo> getAllWithValues();
}
