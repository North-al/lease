package online.northal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.northal.entity.AttrKey;
import online.northal.vo.AttrKeyWithValueVo;

import java.util.List;

public interface AttrKeyService extends IService<AttrKey> {
    List<AttrKeyWithValueVo> getAllWithValues();
}
