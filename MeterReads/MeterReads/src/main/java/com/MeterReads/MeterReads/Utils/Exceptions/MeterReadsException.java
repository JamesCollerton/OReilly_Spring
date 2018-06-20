package com.MeterReads.MeterReads.Utils.Exceptions;

public class MeterReadsException extends Throwable {

    private Exception causingException;

    public MeterReadsException(String exceptionMessage, Exception causingException) {
        super(exceptionMessage);
        this.causingException = causingException;
    }

}
