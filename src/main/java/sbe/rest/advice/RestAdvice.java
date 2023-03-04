package sbe.rest.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import sbe.dto.ErrorDto;

@RestControllerAdvice
@Slf4j
public class RestAdvice {
    private ResponseEntity<ErrorDto> respond(HttpStatus status, ErrorDto errorDto) {
        return ResponseEntity.status(status).body(errorDto);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> handleException(Exception ex, WebRequest request) {
        if (ex instanceof AccessDeniedException) {
            return respond(HttpStatus.FORBIDDEN, new ErrorDto(ErrorDto.ErrorCode.ACCESS_DENIED, "Access has been denied to a resource"));
        }

        log.error("An unhandled exception occurred", ex);
        return respond(HttpStatus.INTERNAL_SERVER_ERROR, new ErrorDto(ErrorDto.ErrorCode.UNKNOWN, "An unknown issue has occurred"));
    }

    // @ExceptionHandler(NoHandlerFoundException.class)
    // ResponseEntity<?> handleNoHandlerFoundException(Exception ex, WebRequest request) {
    //     log.debug("No handler was found for requested path", ex);
    //     return respond(HttpStatus.NOT_FOUND, ErrorDto.ErrorCode.NOT_FOUND, "The endpoint requested was not found");
    // }
    //
    // @ExceptionHandler(HttpMessageNotReadableException.class)
    // ResponseEntity<?> handleHttpMessageNotReadableException(Exception ex, WebRequest request) {
    //     log.debug("The request body was not readable for some reason", ex);
    //     return respond(HttpStatus.BAD_REQUEST, ErrorDto.ErrorCode.INVALID_REQUEST_BODY, "Invalid request body was sent");
    // }
    //
    // @ExceptionHandler(RequestRejectedException.class)
    // ResponseEntity<?> handleRequestRejectedException(Exception ex, WebRequest request) {
    //     log.debug("The request was rejected", ex);
    //     return respond(HttpStatus.BAD_REQUEST, ErrorDto.ErrorCode.INVALID_REQUEST, "The request was rejected because the HTTP method was not a valid HTTP method");
    // }
    //
    // @ExceptionHandler(UnexpectedException.class)
    // ResponseEntity<?> handleUnexpectedException(UnexpectedException ex, WebRequest request) {
    //     log.error("An unexpected exception occurred", ex);
    //     return respond(HttpStatus.INTERNAL_SERVER_ERROR, ErrorDto.ErrorCode.UNKNOWN, "An unexpected server error has occurred");
    // }
    //
    // @ExceptionHandler(ExternalServiceException.class)
    // ResponseEntity<?> handleExternalServiceException(ExternalServiceException ex, WebRequest request) {
    //     log.error("An unexpected exception occurred in an external service", ex);
    //     return respond(HttpStatus.INTERNAL_SERVER_ERROR, ErrorDto.ErrorCode.UNKNOWN, "An unexpected server error has occurred with an external service");
    // }
    //
    // @ExceptionHandler(ExpectedException.class)
    // ResponseEntity<?> handleExpectedException(ExpectedException ex, WebRequest request) {
    //     log.debug("An expected exception occurred", ex);
    //     return respond(HttpStatus.BAD_REQUEST, ErrorDto.ErrorCode.UNKNOWN, "There was a problem with the request");
    // }
    //
    // @ExceptionHandler(AccessException.class)
    // ResponseEntity<?> handleAccessException(AccessException ex, WebRequest request) {
    //     log.debug("Access exception", ex);
    //     return respond(HttpStatus.FORBIDDEN, ErrorDto.ErrorCode.FORBIDDEN, ex.getMessage());
    // }
    //
    // @ExceptionHandler(InsufficientScopeException.class)
    // ResponseEntity<?> handleInsufficientScopeException(InsufficientScopeException ex, WebRequest request) {
    //     log.debug("Insufficient scope", ex);
    //     return respond(HttpStatus.FORBIDDEN, ErrorDto.ErrorCode.FORBIDDEN, "Access token does not have the correct scope(s) to complete the request");
    // }
    //
    // @ExceptionHandler(AccessDeniedException.class)
    // ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
    //     log.debug("Access denied", ex);
    //     return respond(HttpStatus.FORBIDDEN, ErrorCode.FORBIDDEN, "Access is denied to a resource");
    // }
    //
    // @ExceptionHandler(InsufficientAuthenticationException.class)
    // ResponseEntity<?> handleInsufficientAuthenticationException(InsufficientAuthenticationException ex, WebRequest request) {
    //     log.debug("Insufficient authentication", ex);
    //     return respond(HttpStatus.FORBIDDEN, ErrorCode.FORBIDDEN, "Insufficient authentication supplied");
    // }
    //
    // @ExceptionHandler(MissingDataException.class)
    // ResponseEntity<?> handleMissingDataException(MissingDataException ex, WebRequest request) {
    //     log.debug("Missing data", ex);
    //     return respond(HttpStatus.NOT_FOUND, ErrorDto.ErrorCode.NOT_FOUND, ex.getMessage());
    // }
    //
    // @ExceptionHandler(MissingQueryException.class)
    // ResponseEntity<?> handleMissingQueryException(MissingDataException ex, WebRequest request) {
    //     log.debug("Missing required query parameter", ex);
    //     return respond(HttpStatus.FORBIDDEN, ErrorCode.INVALID_REQUEST_QUERY, ex.getMessage());
    // }
    //
    // @ExceptionHandler(NotAuthenticatedException.class)
    // ResponseEntity<?> handleNotAuthenticatedException(NotAuthenticatedException ex, WebRequest request) {
    //     log.debug("Not authenticated", ex);
    //     return respond(HttpStatus.FORBIDDEN, ErrorDto.ErrorCode.FORBIDDEN, "Must be authenticated to complete this request");
    // }
    //
    // @ExceptionHandler(InvalidBearerTokenException.class)
    // ResponseEntity<?> handleInvalidBearerTokenException(InvalidBearerTokenException ex, WebRequest request) {
    //     log.debug("Invalid bearer token", ex);
    //     return respond(HttpStatus.UNAUTHORIZED, ErrorCode.UNAUTHORIZED, "The authorization token is not valid");
    // }
    //
    // @ExceptionHandler(ValidationException.class)
    // ResponseEntity<?> handleValidationException(ValidationException ex, WebRequest request) {
    //     // todo: include the prop from the exception instead of just sending back the message
    //     log.debug("Validation exception", ex);
    //     HashMap<String, Object> details = new HashMap<>();
    //     details.put("path", ex.getProp());
    //     return respond(HttpStatus.BAD_REQUEST, ErrorDto.ErrorCode.VALIDATION, ex.getMessage(), details);
    // }
    //
    // @ExceptionHandler(BudgetGoalOverlapException.class)
    // ResponseEntity<?> handleBudgetGoalOverlapException(BudgetGoalOverlapException ex, WebRequest request) {
    //     log.debug("Budget goal overlap exception", ex);
    //     return respond(HttpStatus.BAD_REQUEST, ErrorCode.BUDGET_GOAL_OVERLAP, ex.getMessage());
    // }
}
