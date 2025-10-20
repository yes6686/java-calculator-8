package calculator;

public class StringCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            if (parts.length != 2) {
                throw new IllegalArgumentException("커스텀 구분자 포맷이 잘못되었습니다.");
            }

            delimiter = java.util.regex.Pattern.quote(parts[0].substring(2)); // 정규식 안전 처리
            numbers = parts[1];
        }

        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }
        }
        return sum;
    }
}
