package pl.sdacademy.booking.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class EventDto {
    private String name;
    private BigDecimal price;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;
}
