package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void 빈_문자열_입력시_0을_반환한다() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    void null_입력시_0을_반환한다() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.calculate(null));
    }
}