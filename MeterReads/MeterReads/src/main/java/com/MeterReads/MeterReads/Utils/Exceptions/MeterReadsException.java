package com.MeterReads.MeterReads.Utils.Exceptions;

import java.util.Optional;

public class MeterReadsException extends Throwable {

    private Optional<Exception> causingException;

    public MeterReadsException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public MeterReadsException(String exceptionMessage, Exception causingException) {
        super(exceptionMessage);
        this.causingException = Optional.of(causingException);
    }

}
