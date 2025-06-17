package online.northal.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class PaymentType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "付款方式名称")
    private String name;

    @Schema(description = "每次支付租期数")
    private String payMonthCount;

    @Schema(description = "付费说明")
    private String additionalInfo;
}
