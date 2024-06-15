package com.redventures.ramengo.config.errorhandler;

import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleCustomExceptions(RuntimeException e) {

        if (e instanceof CustomRuntimeException customRuntimeException) {
            return new ResponseEntity<>(new ApiError(customRuntimeException.getCustomMessage()), customRuntimeException.getHttpStatus());
        }
        else{
            return new ResponseEntity<>(new ApiError("UNKNOW ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        if (!fieldErrors.isEmpty()) {
            return new ResponseEntity<>(new ApiError(fieldErrors.getFirst().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(new ApiError(result.getAllErrors().getFirst().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
