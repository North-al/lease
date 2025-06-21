package online.northal.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ReleaseStatus implements BaseEnum {

    RELEASE(1, "发布"),
    UNRELEASE(0, "未发布");

    @EnumValue
    @JsonValue
    private final Integer code;
    private final String name;
}

