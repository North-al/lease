package online.northal.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.entity.AttrKey;
import online.northal.entity.AttrValue;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AttrKeyWithValueVo extends AttrKey {
    @Schema(description = "属性值列表")
    private List<AttrValue> list;
}
