package online.northal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ApartmentQueryDTO {
    @Schema(description = "省份ID")
    private String provinceId;

    @Schema(description = "城市ID")
    private String cityId;

    @Schema(description = "区域ID")
    private String districtId;
}
