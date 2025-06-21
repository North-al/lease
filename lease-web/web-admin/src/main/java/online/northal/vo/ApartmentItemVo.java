package online.northal.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.entity.ApartmentInfo;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApartmentItemVo extends ApartmentInfo {

    @Schema(description = "公寓房间数量")
    private Long totalRoomCount;

    @Schema(description = "空闲房间数量")
    private Long freeRoomCount;
}
