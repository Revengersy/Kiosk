package challenge.lv2.refactored;

import java.util.Scanner;

public class InputHandler {
    public static Scanner scanner = new Scanner(System.in);

    private InputHandler(){}

    public static int getUserInput(String message, String regex) {
        System.out.println(message);
        while (!scanner.hasNext(regex)) {
            System.out.println("잘못된 값을 입력하였습니다.");
            System.out.println("다시 입력해 주세요.");
            scanner.next();
        }
        return Integer.parseInt(scanner.nextLine());
    }

    public static boolean isOkay(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();
        return userInput.equals("1");
    }
}
