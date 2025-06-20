package online.northal.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.entity.AttrKey;
import online.northal.entity.AttrValue;
import online.northal.entity.FeeKey;
import online.northal.entity.FeeValue;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class FeeKeyWithValueVo extends FeeKey {
    @Schema(description = "属性值列表")
    private List<FeeValue> list;
}
