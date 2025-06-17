package online.northal.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LabelType implements BaseEnum {
    APARTMENT(1, "公寓"),
    ROOM(2, "房间");

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String name;
}
