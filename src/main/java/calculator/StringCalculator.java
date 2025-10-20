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
            delimiter = parts[0].substring(2);
            numbers = parts[1];
        }

        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
