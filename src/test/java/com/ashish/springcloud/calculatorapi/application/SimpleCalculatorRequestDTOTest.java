package com.ashish.springcloud.calculatorapi.application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleCalculatorRequestDTOTest {
    private static final Double FIRST_VALUE = 4d;
    private static final Double SECOND_VALUE = 6d;
    private static final String OPERATOR = "plus";
    private SimpleCalculatorRequestDTO simpleCalculatorRequestDTO;

    @Before
    public void setUp() throws Exception {
        this.simpleCalculatorRequestDTO = new SimpleCalculatorRequestDTO();
        this.simpleCalculatorRequestDTO.setFirstValue(FIRST_VALUE);
        this.simpleCalculatorRequestDTO.setSecondValue(SECOND_VALUE);
        this.simpleCalculatorRequestDTO.setOperator(OPERATOR);
    }

    @Test
    public void testSimpleCalculatorDTO() throws Exception {
        assertNotNull(new SimpleCalculatorRequestDTO());
        assertEquals(4d, this.simpleCalculatorRequestDTO.getFirstValue(), 0);
        assertEquals(6d, this.simpleCalculatorRequestDTO.getSecondValue(), 0);
        assertEquals("plus", this.simpleCalculatorRequestDTO.getOperator());
    }
}
