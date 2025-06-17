package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.enums.LabelType;

@EqualsAndHashCode(callSuper = true)
@Data
public class LabelInfo extends  BaseEntity {
    private LabelType type;

    private  String name;
}
