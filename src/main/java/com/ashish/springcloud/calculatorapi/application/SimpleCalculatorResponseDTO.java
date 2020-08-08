package com.ashish.springcloud.calculatorapi.application;

public class SimpleCalculatorResponseDTO {
    private double result;

    public SimpleCalculatorResponseDTO() {
    }

    public SimpleCalculatorResponseDTO(final double result) {
        this.result = result;
    }

    public double getResult() {
        return this.result;
    }

    public void setResult(final double result) {
        this.result = result;
    }
}
