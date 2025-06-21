package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApartmentFacility extends BaseEntity {
    private Long apartmentId; // 公寓ID
    private Long facilityId;

}
