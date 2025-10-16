package calculator.util;

public class DelimiterParser {

    //"," 또는 ":" 정규식
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public static String[] parse(String input) {
        //커스텀 구분자 존재할경우
        if (hasCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            String numbers = extractNumbers(input);
            String delimiter = buildCustomDelimiter(customDelimiter);
            return numbers.split(delimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private static String extractCustomDelimiter(String input) {
        int delimiterEndIdx = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        return input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterEndIdx);
    }

    //커스텀구분자 이후(없으면, 0부터) 문자열 추출
    private static String extractNumbers(String input) {
        int numberStartIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length();
        return input.substring(numberStartIndex);
    }

    private static String buildCustomDelimiter(String customDelimiter) {
        // 커스텀 구분자와 기본 구분자를 모두 포함
        return "[" + customDelimiter + ",:]";
    }
}