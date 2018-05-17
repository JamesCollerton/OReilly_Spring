package com.MeterReads.MeterReads.DataObjects.FunctionalInterfaces;

@FunctionalInterface
public interface ThrowableFunction<T, R> {
    public R apply(T arg) throws Throwable;
}
