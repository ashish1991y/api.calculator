package com.ashish.springcloud.calculatorapi.application;

import org.springframework.stereotype.Service;

@Service
public interface SimpleCalculatorService {
    public SimpleCalculatorResponseDTO performOperation(SimpleCalculatorRequestDTO simpleCalculatorRequestDTO);
}
