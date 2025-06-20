package online.northal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.northal.entity.FeeKey;
import online.northal.vo.FeeKeyWithValueVo;

import java.util.List;

public interface FeeKeyService extends IService<FeeKey> {
    List<FeeKeyWithValueVo> getAllFeeKeyWithValue();
}
