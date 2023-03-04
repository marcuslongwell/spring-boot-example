package sbe.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sbe.dto.PingDto;
import sbe.dto.PongDto;

import java.time.OffsetDateTime;

@RestController
@PreAuthorize("permitAll()")
public class PublicController {

    @PostMapping("/ping")
    public PongDto ping(@RequestBody PingDto pingDto) {
        return new PongDto(pingDto.getPing(), OffsetDateTime.now());
    }
}
