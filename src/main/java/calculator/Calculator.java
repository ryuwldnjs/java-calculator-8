package calculator;

import calculator.util.DelimiterParser;

public class Calculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = DelimiterParser.parse(input);
        return sum(tokens);
    }

    private int sum(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            result += parseNumber(token);
        }
        return result;
    }

    private int parseNumber(String token) {
        return Integer.parseInt(token.trim());
    }
}