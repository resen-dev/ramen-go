package com.redventures.ramengo.config.errorhandler.exceptions;

import com.redventures.ramengo.config.errorhandler.CustomRuntimeException;
import com.redventures.ramengo.config.errorhandler.ErrorType;

public class RecordNotFoundException extends CustomRuntimeException {

    public RecordNotFoundException(String record, Long idRecord) {
        super(ErrorType.RECORD_NOT_FOUND_ERROR, String.format("ENTITY: %s WITH ID: %d NOT FOUND", record, idRecord));
    }
}
