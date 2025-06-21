package online.northal.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BrowsingHistory extends BaseEntity {
    private Long userId;
    private Long roomId;

    private Date browseTime;
}
