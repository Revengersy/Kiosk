package Lv2;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[] menuIndexes = {0, 1, 2, 3, 4};
        String[] menuNames = {"종료", "Shack Burger","SmokeShack", "CheeseBurger", "Hamburger"};
        double[] menuPrices = {0.0, 6.9, 8.9, 6.9, 5.4};
        String[] menuTexts = {"종료", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", "비프패티를 기반으로 야채가 들어간 기본버거"};

        user_loop:
        while (true) {
            System.out.println("[SHAKESHACK MENU]");
            for (int i = 0; i < menuIndexes.length; i++) {
                System.out.printf("%d. %s | W %f | %n", menuIndexes[i], menuNames[i], menuPrices[i]);
            }

            String tmp = getVaildInputWithRegex("메뉴 번호를 입력해 주세요(0-4)", "[0-4]");
            int userInput = Integer.parseInt(tmp);
            System.out.printf("입력된 메뉴: %d. %s %n", userInput, menuNames[userInput]);

            switch (userInput) {
                case 0:
                    System.out.println("종료합니다");
                    break user_loop;
                case 1:
                    System.out.println(menuTexts[userInput]);
                    break;
                case 2:
                    System.out.println(menuTexts[userInput]);
                    break;
                case 3:
                    System.out.println(menuTexts[userInput]);
                    break;
                case 4:
                    System.out.println(menuTexts[userInput]);
                    break;
            }


            System.out.println();
        }


        sc.close();
    }

    public static String getVaildInputWithRegex(String message, String regex){
        System.out.println(message);
        while(!sc.hasNext(regex)){
            System.out.println("입력 실패. 조건에 맞게 입력해 주세요");
            sc.next();
        }
        return sc.next();
    }


}