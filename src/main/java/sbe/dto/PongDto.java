package sbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class PongDto {
    private String pong;
    private OffsetDateTime time;
}
