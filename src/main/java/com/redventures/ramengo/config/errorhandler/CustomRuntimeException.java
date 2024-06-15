package com.redventures.ramengo.config.errorhandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class CustomRuntimeException extends RuntimeException {

    private final HttpStatus status;

    @Getter
    private final String customMessage;

    protected CustomRuntimeException(ErrorType errorType) {
        super(errorType.getDefaultMessage());
        this.status = errorType.getHttpStatus();
        this.customMessage = errorType.getDefaultMessage();
    }

    protected CustomRuntimeException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.status = errorType.getHttpStatus();
        this.customMessage = customMessage;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }
}

