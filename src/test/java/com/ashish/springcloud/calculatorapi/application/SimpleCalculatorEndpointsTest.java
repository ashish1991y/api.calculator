package com.ashish.springcloud.calculatorapi.application;


import com.ashish.springcloud.calculatorapi.exception.SimpleCalculatorException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleCalculatorEndpointsTest {

    @Mock
    SimpleCalculatorRequestDTO simpleCalculatorRequestDTO;
    @Mock
    SimpleCalculatorService simpleCalculatorService;

    SimpleCalculatorResponseDTO simpleCalculatorResponseDTO;

    @Before
    public void setup() {
        when(simpleCalculatorService.performOperation(simpleCalculatorRequestDTO)).thenReturn(new SimpleCalculatorResponseDTO(5D));
    }

    @InjectMocks
    private SimpleCalculatorEndpoints simpleCalculatorEndpoints;

    @Test
    public void testCalculateValue_success() {
        simpleCalculatorResponseDTO=new SimpleCalculatorResponseDTO(5d);
        assertEquals(simpleCalculatorResponseDTO.getResult(), simpleCalculatorEndpoints.calculateValue(simpleCalculatorRequestDTO).getResult(),0d);
    }

    @Test(expected = ResponseStatusException.class)
    public void testCalculateValue_error() {
        when(simpleCalculatorService.performOperation(simpleCalculatorRequestDTO)).thenThrow(SimpleCalculatorException.class);
        simpleCalculatorEndpoints.calculateValue(simpleCalculatorRequestDTO);
    }
}
