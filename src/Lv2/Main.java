package Lv2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

//        생성자 체이닝을 표시하기 위해, Lv1 예시에서 CheeseBurger의 설명 제거 생성 / Hamburger의 Price 제거 생성
        MenuItem menuItem1 = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem2 = new MenuItem("SmokeShack ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem3 = new MenuItem("CheeseBurger ", 6.9);
        MenuItem menuItem4 = new MenuItem("Hamburger ", "비프패티를 기반으로 야채가 들어간 기본버거");

        ArrayList<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        menuItems.add(menuItem3);
        menuItems.add(menuItem4);

        user_loop:
        while (true) {
            System.out.println("[SHAKESHACK MENU]");
            System.out.printf("%d. %s | %s %n", 0, "종료", "종료합니다.");

            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem menuItem = menuItems.get(i);
                System.out.printf("%d. %s | W %.1f | %n", i + 1, menuItem.name, menuItem.price);
            }

            String tmp = getVaildInputWithRegex("메뉴 번호를 입력해 주세요(0-4)", "[0-4]");
            int userInput = Integer.parseInt(tmp);
            switch (userInput) {
                case 0:
                    System.out.println("종료합니다");
                    break user_loop;
                case 1:
                    System.out.printf("입력된 메뉴: %d. %s %n", userInput, menuItems.get(userInput - 1).name);
                    System.out.printf("가격: %.1f %n", menuItems.get(userInput - 1).price);
                    System.out.println(menuItems.get(userInput - 1).explanation);
                    break;
                case 2:
                    System.out.printf("입력된 메뉴: %d. %s %n", userInput, menuItems.get(userInput - 1).name);
                    System.out.printf("가격: %.1f %n", menuItems.get(userInput - 1).price);
                    System.out.println(menuItems.get(userInput - 1).explanation);
                    break;
                case 3:
                    System.out.printf("입력된 메뉴: %d. %s %n", userInput, menuItems.get(userInput - 1).name);
                    System.out.printf("가격: %.1f %n", menuItems.get(userInput - 1).price);
                    System.out.println(menuItems.get(userInput - 1).explanation);
                    break;
                case 4:
                    System.out.printf("입력된 메뉴: %d. %s %n", userInput, menuItems.get(userInput - 1).name);
                    System.out.printf("가격: %.1f %n", menuItems.get(userInput - 1).price);
                    System.out.println(menuItems.get(userInput - 1).explanation);
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