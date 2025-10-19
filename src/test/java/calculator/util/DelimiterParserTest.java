package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterParserTest {

    @Test
    @DisplayName("쉼표 구분자로 문자열을 분리한다")
    void parse() {
        String[] result = DelimiterParser.parse("1,2,3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("콜론 구분자로 문자열을 분리한다")
    void parse_콜론_구분자() {
        String[] result = DelimiterParser.parse("1:2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("쉼표와 콜론을 혼합하여 사용할 수 있다")
    void parse_쉼표와_콜론_혼합() {
        String[] result = DelimiterParser.parse("1,2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("숫자 하나만 입력하면 배열에 하나의 요소를 반환한다")
    void parse_숫자_하나() {
        String[] result = DelimiterParser.parse("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열을 분리한다")
    void parse_커스텀_구분자() {
        String[] result = DelimiterParser.parse("//;\\n1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자를 함께 사용할 수 있다")
    void parse_커스텀_구분자와_기본_구분자_혼합() {
        String[] result = DelimiterParser.parse("//;\\n1;2,3:4");
        assertThat(result).containsExactly("1", "2", "3", "4");
    }
}