package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // \n을 문자열로 입력받은 경우 실제 개행문자로 변환
        input = input.replace("\\n", "\n");

        String delimiter = DEFAULT_DELIMITER;
        String numbersString = input;

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEndIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }

            String customDelimiter = input.substring(
                    CUSTOM_DELIMITER_PREFIX.length(),
                    delimiterEndIndex
            );

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
            }

            delimiter = Pattern.quote(customDelimiter);
            numbersString = input.substring(delimiterEndIndex + 1);
        }

        return sum(numbersString, delimiter);
    }

    private int sum(String numbersString, String delimiter) {
        if (numbersString.isEmpty()) {
            return 0;
        }

        String[] numbers = numbersString.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            sum += parseAndValidate(number.trim());
        }

        return sum;
    }

    private int parseAndValidate(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("빈 숫자는 허용되지 않습니다.");
        }

        try {
            int value = Integer.parseInt(number);

            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }

            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: " + number);
        }
    }
}