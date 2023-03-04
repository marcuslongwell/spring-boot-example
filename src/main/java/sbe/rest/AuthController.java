package sbe.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sbe.dto.UserDto;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/me")
    public UserDto me() {
        return new UserDto("marcus");
    }
}
