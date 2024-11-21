package Lv4;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {

    private ArrayList<Menu> menus;


    public Kiosk() {
        menus = new ArrayList<>();
    }

    public void start() {
        user_loop:
        while (true) {
            System.out.println("""
                    ==============================""");
            System.out.println("[SHAKESHACK MENU]");
            System.out.printf("%d. %-11s:%s %n", 0, "종료", "종료합니다.");

            for (int i = 0; i < this.menus.size(); i++) {
                Menu menu = this.menus.get(i);
                System.out.print((i + 1) + ". ");
                menu.printMenu();
            }

            int userInput;
            Menu menu;
            while (true) {
                String tmp = getVaildInputWithRegex("메뉴 번호를 입력해 주세요", "[0-9]+");
                userInput = Integer.parseInt(tmp);
                System.out.println("입력된 번호: " + userInput);
                System.out.println();

                if (userInput > 0 && userInput <= this.menus.size()) {
                    menu = menus.get(userInput - 1);
                    break;
                }

                if (userInput == 0) {
                    System.out.println("종료합니다. ");
                    break user_loop;
                }

                System.out.println("메뉴 범위를 벗어났습니다");
            }

            item_loop:
            while (true) {
                System.out.println("""
                        > 세부 메뉴 항목을 입력해주세요""");
                ArrayList<MenuItem> menuItems = menu.getMenuItems();
                System.out.println("0. 이전으로");
                for (int i = 0; i < menuItems.size(); i++) {
                    MenuItem menuItem = menuItems.get(i);
                    System.out.printf("%d. %-11s| %-11.1f | %-11s %n", i + 1, menuItem.getName(), menuItem.getPrice(), menuItem.getExplanation());
                    ;
                }

                while (true) {
                    String tmp = getVaildInputWithRegex("메뉴 번호를 입력해 주세요", "[0-9]+");
                    userInput = Integer.parseInt(tmp);
                    System.out.println("입력된 번호: " + userInput);
                    System.out.println();

                    if (userInput > 0 && userInput <= menuItems.size()) {
                        MenuItem menuItem = menuItems.get(userInput - 1);
                        System.out.print(">>>>>> ");
                        menuItem.printItems();
                        System.out.println("""
                                !!!!!!!!!!!!!
                                
                                """);
                        break;
                    }

                    if (userInput == 0) {
                        System.out.println("이전으로 돌아갑니다. ");
                        break item_loop;
                    }

                    System.out.println("메뉴 범위를 벗어났습니다");
                }
            }
        }
    }


    public void addMenu(Menu menu) {
        menus.add(menu);
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
