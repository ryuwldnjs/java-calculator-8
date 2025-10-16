package calculator.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterParserTest {

    @Test
    void 쉼표_구분자로_문자열을_분리한다() {
        String[] result = DelimiterParser.parse("1,2,3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 콜론_구분자로_문자열을_분리한다() {
        String[] result = DelimiterParser.parse("1:2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 쉼표와_콜론을_혼합하여_사용할_수_있다() {
        String[] result = DelimiterParser.parse("1,2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 숫자_하나만_입력하면_배열에_하나의_요소를_반환한다() {
        String[] result = DelimiterParser.parse("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void 커스텀_구분자로_문자열을_분리한다() {
        String[] result = DelimiterParser.parse("//;\n1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }
}