package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApartmentFeeValue extends BaseEntity {

    private Long apartmentId;

    private Long feeValueId;

}
