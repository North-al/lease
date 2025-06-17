package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AttrKey extends BaseEntity{
    private String name;
}
