package calculator;

public class StringCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // default delimiters: comma or colon
        String numbers = input;

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid custom delimiter format.");
            }

            // Escape the delimiter for use in regular expressions
            delimiter = java.util.regex.Pattern.quote(parts[0].substring(2));
            numbers = parts[1];
        }

        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Non-numeric value detected: " + token);
            }
        }
        return sum;
    }
}
