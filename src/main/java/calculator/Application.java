package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String firstLine = Console.readLine();

        String input = firstLine;
        if (firstLine.startsWith("//")) {
            String secondLine = Console.readLine();
            input = firstLine + "\n" + secondLine;
        }

        try {
            int result = StringCalculator.calculate(input);
            System.out.println("result : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
