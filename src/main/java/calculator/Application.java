package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구분자를 포함한 첫 줄을 입력하세요 (예: //;):");
        String firstLine = Console.readLine();

        String input = firstLine;
        if (firstLine.startsWith("//")) {
            System.out.println("계산할 숫자를 입력하세요 (예: 1;2;3):");
            String secondLine = Console.readLine();
            input = firstLine + "\n" + secondLine;
        }

        try {
            int result = StringCalculator.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
        }
    }
}
