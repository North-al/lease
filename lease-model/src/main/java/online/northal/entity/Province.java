package online.northal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("province_info")
@Data
public class Province extends BaseEntity {

    @Schema(description = "省份名称")
    private String name;
}
