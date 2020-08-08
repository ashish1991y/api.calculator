package com.ashish.springcloud.calculatorapi.application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleCalculatorResponseDTOTest {
    private static final Double RESULT = 8d;
    private SimpleCalculatorResponseDTO simpleCalculatorResponseDTO;

    @Before
    public void setUp() throws Exception {
        this.simpleCalculatorResponseDTO = new SimpleCalculatorResponseDTO(RESULT);
    }

    @Test
    public void testSimpleCalculatorResponceDTO() throws Exception {
        assertNotNull(this.simpleCalculatorResponseDTO);
        assertEquals(8d, this.simpleCalculatorResponseDTO.getResult(), 0D);
    }
}
