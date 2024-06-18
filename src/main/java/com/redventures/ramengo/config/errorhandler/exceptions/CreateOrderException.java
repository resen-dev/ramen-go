package com.redventures.ramengo.config.errorhandler.exceptions;

import com.redventures.ramengo.config.errorhandler.CustomRuntimeException;
import com.redventures.ramengo.config.errorhandler.ErrorType;

public class CreateOrderException extends CustomRuntimeException {

    public CreateOrderException() {
        super(ErrorType.CREATE_ORDER_ERROR);
    }

    public CreateOrderException(String customMessage) {
        super(ErrorType.CREATE_ORDER_ERROR, customMessage);
    }
}
