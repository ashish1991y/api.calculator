package com.ashish.springcloud.calculatorapi.application;

import com.ashish.springcloud.calculatorapi.exception.SimpleCalculatorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(value = "/v1")
public class SimpleCalculatorEndpoints {
    private final SimpleCalculatorService simpleCalculatorService;
    @Value("${server.port}")
    private int portNumber;

    SimpleCalculatorEndpoints(final SimpleCalculatorService simpleCalculatorService) {
        this.simpleCalculatorService = simpleCalculatorService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "/calculate", consumes = {"application/json"})
    public SimpleCalculatorResponseDTO calculateValue(@RequestBody final SimpleCalculatorRequestDTO simpleCalculatorRequestDTO) {
        final SimpleCalculatorResponseDTO result;
        try {
            result = this.simpleCalculatorService.performOperation(simpleCalculatorRequestDTO);
        } catch (final SimpleCalculatorException exc) {
            exc.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Incorrect Value, Please check your provided values", exc);
        }
        return result;
    }

    @GetMapping(value = "/test")
    public String getTestData() throws UnknownHostException {
        return "test data with host details=" + InetAddress.getLocalHost() + " post number=" + this.portNumber;
    }
}

