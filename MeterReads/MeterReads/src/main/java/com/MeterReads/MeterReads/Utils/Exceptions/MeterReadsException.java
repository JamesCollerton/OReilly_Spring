package com.MeterReads.MeterReads.Utils.Exceptions;

public class MeterReadsException extends Throwable {

    private String exceptionMessage;
    private Exception causingException;

    public MeterReadsException(String exceptionMessage, Exception causingException) {
        this.exceptionMessage = exceptionMessage;
        this.causingException = causingException;
    }

}
