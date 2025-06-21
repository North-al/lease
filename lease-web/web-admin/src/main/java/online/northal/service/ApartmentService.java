package online.northal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.northal.entity.ApartmentInfo;
import online.northal.vo.ApartmentSubmitVo;

public interface ApartmentService extends IService<ApartmentInfo> {
    void create(ApartmentSubmitVo vo);
}
