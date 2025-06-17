package online.northal.entity;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.enums.LabelType;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class FacilityInfo extends BaseEntity {
    private LabelType type;
    private String name;
    private String icon;
}
