package calculator.util;

public class DelimiterParser {

    //"," 또는 ":" 정규식
    private static final String DEFAULT_DELIMITER = "[,:]";

    public static String[] parse(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}