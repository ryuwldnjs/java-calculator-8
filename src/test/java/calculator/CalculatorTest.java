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

    @Test
    void 숫자_하나를_입력하면_해당_숫자를_반환한다() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.calculate("1"));
    }


    @Test
    void 쉼표_구분자로_숫자의_합을_반환한다() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.calculate("1,2,3"));
    }

    @Test
    void 콜론_구분자로_숫자의_합을_반환한다() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.calculate("1:2:3"));
    }

    @Test
    void 쉼표와_콜론_구분자를_혼합하여_사용할_수_있다() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.calculate("1,2:3"));
    }

    @Test
    void 커스텀_구분자로_숫자의_합을_반환한다() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.calculate("//;\\n1;2;3"));
    }

    @Test
    void 커스텀_구분자와_기본_구분자를_함께_사용할_수_있다() {
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.calculate("//;\\n1;2,3:4"));
    }
}