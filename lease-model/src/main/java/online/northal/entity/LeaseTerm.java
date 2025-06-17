package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LeaseTerm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Integer monthCount; // 月数
    private String unit; // 单位，如月、年等

}
