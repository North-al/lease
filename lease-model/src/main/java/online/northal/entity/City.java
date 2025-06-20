package online.northal.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("city_info")
public class City extends BaseEntity {

    private String name;

    private Long provinceId;
}
