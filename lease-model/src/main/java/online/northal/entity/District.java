package online.northal.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("district_info")
public class District extends BaseEntity {

    private String name;

    private Long cityId;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;
}
