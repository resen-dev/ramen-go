package com.redventures.ramengo.config.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    RECORD_NOT_FOUND_ERROR("RECORD NOT FOUND", HttpStatus.NOT_FOUND),
    API_KEY_INVALID_ERROR("API KEY INVALID", HttpStatus.UNAUTHORIZED),
    API_KEY_MISSING_ERROR("x-api-key header missing", HttpStatus.FORBIDDEN),
    CREATE_ORDER_ERROR("could not place order", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String defaultMessage;
    private final HttpStatus httpStatus;

}

