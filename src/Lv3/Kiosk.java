package Lv3;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
    private ArrayList<MenuItem> menuList = new ArrayList<>();


    public Kiosk(ArrayList<MenuItem> menuList) {
        this.menuList = menuList;
    }

    public void start() {
        int userInput = 1;

        user_loop:
        while (true) {
            System.out.println("[SHAKESHACK MENU]");
            System.out.printf("%d. %s | %s %n", 0, "종료", "종료합니다.");

            for (int i = 0; i < menuList.size(); i++) {
                MenuItem menuItem = menuList.get(i);
                System.out.printf("%d. %s | W %.1f | %n", i + 1, menuItem.name, menuItem.price);
            }

            String tmp = getVaildInputWithRegex("메뉴 번호를 입력해 주세요(0-4)", "[0-4]");
            userInput = Integer.parseInt(tmp);
            System.out.println("입력된 번호: " + userInput);

            System.out.println();

            switch (userInput) {
                case 0:
                    System.out.println("종료합니다");
                    break user_loop;
                case 1:
                    System.out.printf("입력된 메뉴: %d. %s %n", userInput, menuList.get(userInput - 1).name);
                    System.out.printf("가격: %.1f %n", menuList.get(userInput - 1).price);
                    System.out.println(menuList.get(userInput - 1).explanation);
                    break;
                case 2:
                    System.out.printf("입력된 메뉴: %d. %s %n", userInput, menuList.get(userInput - 1).name);
                    System.out.printf("가격: %.1f %n", menuList.get(userInput - 1).price);
                    System.out.println(menuList.get(userInput - 1).explanation);
                    break;
                case 3:
                    System.out.printf("입력된 메뉴: %d. %s %n", userInput, menuList.get(userInput - 1).name);
                    System.out.printf("가격: %.1f %n", menuList.get(userInput - 1).price);
                    System.out.println(menuList.get(userInput - 1).explanation);
                    break;
                case 4:
                    System.out.printf("입력된 메뉴: %d. %s %n", userInput, menuList.get(userInput - 1).name);
                    System.out.printf("가격: %.1f %n", menuList.get(userInput - 1).price);
                    System.out.println(menuList.get(userInput - 1).explanation);
                    break;
            }
        }
    }

    private static String getVaildInputWithRegex(String message, String regex) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNext(regex)) {
            System.out.println("입력 실패. 조건에 맞게 입력해 주세요");
            sc.next();
        }

        return sc.next();
    }

}
