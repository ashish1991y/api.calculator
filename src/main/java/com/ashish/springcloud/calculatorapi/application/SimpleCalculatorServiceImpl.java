package com.ashish.springcloud.calculatorapi.application;

import com.ashish.springcloud.calculatorapi.exception.SimpleCalculatorException;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorServiceImpl implements SimpleCalculatorService {
    private final SimpleCalculatorValidator simpleCalculatorValidator;

    public SimpleCalculatorServiceImpl(final SimpleCalculatorValidator simpleCalculatorValidator) {
        this.simpleCalculatorValidator = simpleCalculatorValidator;
    }

    @Override
    public SimpleCalculatorResponseDTO performOperation(final SimpleCalculatorRequestDTO simpleCalculatorRequestDTO) {
        double result = 0;
        final String operator = simpleCalculatorRequestDTO.getOperator();
        final Double firstValue = simpleCalculatorRequestDTO.getFirstValue();
        final Double secondValue = simpleCalculatorRequestDTO.getSecondValue();

        switch (operator) {
            case "add":
                result = this.add(firstValue, secondValue);
                break;
            case "subtract":
                result = this.subtract(firstValue, secondValue);
                break;
            case "multiply":
                result = this.multiply(firstValue, secondValue);
                break;
            case "divide":
                result = this.divide(firstValue, secondValue);
                break;
            default:
                throw new SimpleCalculatorException("Incorrect operator selected");
        }
        final SimpleCalculatorResponseDTO simpleCalculatorResponseDTO = new SimpleCalculatorResponseDTO();
        simpleCalculatorResponseDTO.setResult(result);
        return simpleCalculatorResponseDTO;
    }

    private double add(final Double firstValue, final Double secondValue) {
        return firstValue + secondValue;
    }

    private double subtract(final Double firstValue, final Double secondValue) {
        return firstValue - secondValue;
    }

    private double multiply(final Double firstValue, final Double secondValue) {
        return firstValue * secondValue;
    }

    private double divide(final Double firstValue, final Double secondValue) {
        if (!this.simpleCalculatorValidator.isZero(secondValue)) {
            return firstValue / secondValue;
        } else {
            throw new SimpleCalculatorException("second value can not be zero for divide operation");
        }

    }
}
