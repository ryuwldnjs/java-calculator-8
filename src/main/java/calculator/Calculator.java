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
        try {
            int number = Integer.parseInt(token.trim());
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다: " + token);
        }
    }
}