package online.northal.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.enums.ReleaseStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApartmentInfo extends BaseEntity {

    private String name; // 公寓名称

    @Schema(description = "公寓描述")
    private String introduction;

    private Long districtId;
    private String districtName;
    private Long cityId;
    private String cityName;
    private Long provinceId;
    private String provinceName;
    private String addressDetail;
    private String latitude;
    private String longitude;
    private String phone;

    @Schema(description = "（1:发布，0:未发布）")
    private ReleaseStatus isRelease;
}
