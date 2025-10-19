package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    @DisplayName("빈 문자열 입력시 0을 반환한다")
    void calculate() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    @DisplayName("null 입력시 0을 반환한다")
    void calculate_null_입력() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.calculate(null));
    }

    @Test
    @DisplayName("숫자 하나를 입력하면 해당 숫자를 반환한다")
    void calculate_숫자_하나() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.calculate("1"));
    }


    @Test
    @DisplayName("쉼표 구분자로 숫자의 합을 반환한다")
    void calculate_쉼표_구분자() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.calculate("1,2,3"));
    }

    @Test
    @DisplayName("콜론 구분자로 숫자의 합을 반환한다")
    void calculate_콜론_구분자() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.calculate("1:2:3"));
    }

    @Test
    @DisplayName("쉼표와 콜론 구분자를 혼합하여 사용할 수 있다")
    void calculate_쉼표와_콜론_혼합() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.calculate("1,2:3"));
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자의 합을 반환한다")
    void calculate_커스텀_구분자() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.calculate("//;\\n1;2;3"));
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자를 함께 사용할 수 있다")
    void calculate_커스텀_구분자와_기본_구분자_혼합() {
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.calculate("//;\\n1;2,3:4"));
    }

    @Test
    @DisplayName("음수를 입력하면 예외를 던진다")
    void calculate_음수_입력() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 형식의 입력시 예외를 던진다")
    void calculate_잘못된_형식() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculate("1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}