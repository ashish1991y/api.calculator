package com.ashish.springcloud.calculatorapi.application;


import com.ashish.springcloud.calculatorapi.exception.SimpleCalculatorException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleCalculatorServiceImplTest {

    @Mock
    private SimpleCalculatorRequestDTO simpleCalculatorRequestDTO;
    @Mock
    private SimpleCalculatorValidator simpleCalculatorValidator;

    SimpleCalculatorResponseDTO simpleCalculatorResponseDTO;

    @Before
    public void setup() {

        when(simpleCalculatorRequestDTO.getFirstValue()).thenReturn(4d);
        when(simpleCalculatorRequestDTO.getSecondValue()).thenReturn(2d);
        when(simpleCalculatorValidator.isZero(anyDouble())).thenReturn(false);
    }

    @InjectMocks
    SimpleCalculatorServiceImpl simpleCalculatorServiceImpl;

    @Test
    public void testPerformOperation_add() {
        when(simpleCalculatorRequestDTO.getOperator()).thenReturn("add");
        simpleCalculatorResponseDTO=new SimpleCalculatorResponseDTO(6D);
        assertEquals(simpleCalculatorResponseDTO.getResult(), simpleCalculatorServiceImpl.performOperation(simpleCalculatorRequestDTO).getResult(), 0D);
    }

    @Test
    public void testPerformOperation_subtract() {
        when(simpleCalculatorRequestDTO.getOperator()).thenReturn("subtract");
        simpleCalculatorResponseDTO=new SimpleCalculatorResponseDTO(2d);
        assertEquals(simpleCalculatorResponseDTO.getResult(), simpleCalculatorServiceImpl.performOperation(simpleCalculatorRequestDTO).getResult(),0D);
    }

    @Test
    public void testPerformOperation_multiply() {
        when(simpleCalculatorRequestDTO.getOperator()).thenReturn("multiply");
        simpleCalculatorResponseDTO=new SimpleCalculatorResponseDTO(8D);
        assertEquals(simpleCalculatorResponseDTO.getResult(), simpleCalculatorServiceImpl.performOperation(simpleCalculatorRequestDTO).getResult(),0D);
    }

    @Test
    public void testPerformOperation_divide() {
        when(simpleCalculatorRequestDTO.getOperator()).thenReturn("divide");
        simpleCalculatorResponseDTO=new SimpleCalculatorResponseDTO(2D);
        assertEquals(simpleCalculatorResponseDTO.getResult(), simpleCalculatorServiceImpl.performOperation(simpleCalculatorRequestDTO).getResult(),0D);
    }

    @Test(expected = SimpleCalculatorException.class)
    public void testPerformOperation_divide_zero() {
        when(simpleCalculatorValidator.isZero(anyDouble())).thenReturn(true);
        when(simpleCalculatorRequestDTO.getOperator()).thenReturn("divide");
        simpleCalculatorServiceImpl.performOperation(simpleCalculatorRequestDTO);
    }

    @Test(expected = SimpleCalculatorException.class)
    public void testPerformOperation_incorrect() {
        when(simpleCalculatorRequestDTO.getOperator()).thenReturn("test");
        simpleCalculatorServiceImpl.performOperation(simpleCalculatorRequestDTO);
    }
}
