package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AttrValue extends BaseEntity {

    private String name;

    private Long attrKeyId;
}
