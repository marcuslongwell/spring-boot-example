package sbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDto {
    public enum ErrorCode {
        UNKNOWN, // some unexpected issue occurred on the backend
        ACCESS_DENIED // access to a resource has been denied
    }

    private ErrorCode code;
    private String message;
}
