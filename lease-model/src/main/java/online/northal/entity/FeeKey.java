package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FeeKey extends BaseEntity {
    private String name;
}
