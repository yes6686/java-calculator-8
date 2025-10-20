package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("Enter input string:");
        String input = Console.readLine();  // 전체 입력 한 줄로 받기

        try {
            int result = StringCalculator.calculate(input);
            System.out.println("Result : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
