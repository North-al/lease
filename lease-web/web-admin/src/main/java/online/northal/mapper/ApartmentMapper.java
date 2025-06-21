package online.northal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.northal.dto.ApartmentQueryDTO;
import online.northal.entity.ApartmentInfo;
import online.northal.vo.ApartmentItemVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApartmentMapper extends BaseMapper<ApartmentInfo> {

    IPage<ApartmentItemVo> selectByPage(Page<ApartmentItemVo> voPage, ApartmentQueryDTO dto);
}
