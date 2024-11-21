package Lv5;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {

    private ArrayList<Menu> menus;
    private Scanner scanner;  // Single instance of Scanner

    public Kiosk() {
        menus = new ArrayList<>();
        scanner = new Scanner(System.in);  // Initialize Scanner here
    }

    public void start() {
        while (true) {
            printMainMenu();
            int userInput = getUserInput("메뉴 번호를 입력해 주세요", "[0-9]+");

            if (userInput == 0) {
                System.out.println("종료합니다.");
                break;
            }

            if (userInput > 0 && userInput <= menus.size()) {
                Menu selectedMenu = menus.get(userInput - 1);
                handleMenuSelection(selectedMenu);
            } else {
                System.out.println("메뉴 범위를 벗어났습니다");
            }
        }
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }


    private void printMainMenu() {
        System.out.println("==============================");
        System.out.println("[SHAKESHACK MENU]");
        System.out.printf("%d. %-11s:%s %n", 0, "종료", "종료합니다.");

        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            System.out.print((i + 1) + ". ");
            menu.printMenu();
        }
    }

    private void handleMenuSelection(Menu menu) {
        while (true) {
            ArrayList<MenuItem> menuItems = menu.getMenuItems();
            printMenuItems(menuItems);

            int userInput = getUserInput("메뉴 번호를 입력해 주세요", "[0-9]+");

            if (userInput == 0) {
                System.out.println("이전으로 돌아갑니다.");
                break;
            }

            if (userInput > 0 && userInput <= menuItems.size()) {
                MenuItem menuItem = menuItems.get(userInput - 1);
                printMenuItemDetails(menuItem);
            } else {
                System.out.println("메뉴 범위를 벗어났습니다");
            }
        }
    }

    private int getUserInput(String message, String regex) {
        System.out.println(message);
        while (!scanner.hasNext(regex)) {
            System.out.println("입력 실패. 조건에 맞게 입력해 주세요");
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }

    private void printMenuItems(ArrayList<MenuItem> menuItems) {
        System.out.println("> 세부 메뉴 항목을 입력해주세요");
        System.out.println("0. 이전으로");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i);
            System.out.printf("%d. %-11s| %-11.1f | %-11s %n", i + 1, menuItem.getName(), menuItem.getPrice(), menuItem.getExplanation());
        }
    }

    private void printMenuItemDetails(MenuItem menuItem) {
        System.out.print(">>>>>> ");
        menuItem.printItems();
        System.out.println("!!!!!!!!!!!!!\n");
    }
}