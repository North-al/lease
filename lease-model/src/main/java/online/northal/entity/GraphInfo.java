package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import online.northal.enums.GraphItemType;

@EqualsAndHashCode(callSuper = true)
@Data
public class GraphInfo extends BaseEntity{

    private String name;

    private GraphItemType itemType; // 1: 公寓, 2: 房间

    private Long itemId; // 公寓或房间的ID

    private String url; // 公寓或房间的名称
}
