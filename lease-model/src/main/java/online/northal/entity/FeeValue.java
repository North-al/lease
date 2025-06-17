package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FeeValue extends BaseEntity {
    private Long feeKeyId;

    private String name;

    private String unit;
}
