package com.ashish.springcloud.calculatorapi.exception;

public class SimpleCalculatorException extends RuntimeException {
    public SimpleCalculatorException(String value)
    {
        super(value);
    }
}
