package online.northal.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import online.northal.dto.ApartmentQueryDTO;
import online.northal.entity.ApartmentInfo;
import online.northal.vo.ApartmentItemVo;
import online.northal.vo.ApartmentSubmitVo;

public interface ApartmentService extends IService<ApartmentInfo> {
    void add(ApartmentSubmitVo vo);

    void edit(ApartmentSubmitVo vo);

    IPage<ApartmentItemVo> selectPage(Page<ApartmentItemVo> voPage, ApartmentQueryDTO dto);
}
