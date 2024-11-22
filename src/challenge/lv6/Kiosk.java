package challenge.lv6;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {

    private ArrayList<Menu> menus;
    private Scanner scanner;  // Single instance of Scanner
    private ArrayList<MenuItem> cartedItems;

    public Kiosk() {
        menus = new ArrayList<>();
        scanner = new Scanner(System.in);  // Initialize Scanner here
        cartedItems = new ArrayList<>();
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
            } else if (userInput == menus.size() + 1) {
                handleCartView();
            } else if (userInput == menus.size() + 2) {
                handleCartedItemDelete();
                continue;
            } else {
                System.out.println("입력 범위를 벗어났습니다");
                break;
            }

        }
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
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
                int cartInput = getUserInput("주문을 확정 하시겠습니까? (1: 확정, 2:취소)", "[1-2]");
                if (cartInput == 1) {
                    MenuItem menuItem = menuItems.get(userInput - 1);
                    printMenuItemDetails(menuItem);
                    cartedItems.add(menuItem);
                    System.out.println("장바구니에 추가되었습니다");
                } else {
                    System.out.println("아이템 선택이 취소되었습니다");
                    continue;
                }
            } else {
                System.out.println("메뉴 범위를 벗어났습니다");
            }
        }
    }

    private void handleCartView() {
        while (true) {
            printCart();
            int displayInput = getUserInput("명령을 입력해주세요. (0: 메뉴 선택 화면으로, 1: 주문하기)", "[0-1]");
            if (displayInput == 0) {
                break;
            } else {
                int deleteInput = getUserInput("주문을 확정 하시겠습니까? (1: 확정, 2:취소)", "[1-2]");
                if (deleteInput == 1) {
                    cartedItems.clear();
                    System.out.println("장바구니에서 항목이 제거되었습니다");
                    continue;
                } else {
                    System.out.println("명령이 취소되었습니다");
                    continue;
                }
            }
        }
    }

    private void handleCartedItemDelete(){
        while (true) {
            System.out.println("주문취소 실행");
            printCart();
            int displayInput = getUserInput("명령을 입력해주세요(0: 메뉴 선택 화면으로, 1~: 해당 메뉴 제거)", "[0-9]+");
            if (displayInput == 0) {
                break;
            } else if (displayInput > 0 && displayInput < cartedItems.size() + 1) {
                cartedItems.get(displayInput - 1).printItem();
                int deleteInput = getUserInput("아이템을 장바구니에서 제거 하시겠습니까? (1: 확정, 2:취소)", "[1-2]");
                if (deleteInput == 1) {
                    cartedItems.remove(deleteInput - 1);
                    System.out.println("장바구니에서 항목이 제거되었습니다");
                    continue;
                } else {
                    System.out.println("명령이 취소되었습니다");
                    continue;
                }
            } else {
                System.out.println("카트 범위 밖 숫자를 입력했습니다.");
                continue;
            }
        }
    }



    private int getUserInput(String message, String regex) {
        System.out.println(message);
        while (!scanner.hasNext(regex)) {
            System.out.println("잘못된 값을 입력하였습니다.");
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }

    private void printMainMenu() {
        System.out.println("==============================");
        System.out.println("""
                [[SHACK MENU]]
                
                [MAIN MENU]""");
        System.out.printf("%d. %-11s:%s %n", 0, "종료", "종료합니다.");


        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            System.out.print((i + 1) + ". ");
            menu.printMenu();
        }

        if (cartedItems.size() > 0) {
            System.out.println("""
                    
                    [ORDER MENU]""");
            System.out.printf("%d. %-11s:%s %n", menus.size() + 1, "장바구니", "장바구니 목록을 조회합니다.");
            System.out.printf("%d. %-11s:%s %n", menus.size() + 2, "취소", "진행중인 주문을 취소합니다.");
        }
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
        menuItem.printItem();
        System.out.println("!!!!!!!!!!!!!\n");
    }

    private void printCart() {
        if (cartedItems.size() == 0) {
            System.out.println("장바구니가 비어 있습니다");
            return;
        }

        System.out.println("[ Orders ]");
        double sumPrice = 0;
        for (int i = 0; i < cartedItems.size(); i++) {
            MenuItem menuitem = cartedItems.get(i);
            System.out.printf("%d. %-11s| %-11.1f | %-11s %n", i + 1, menuitem.getName(), menuitem.getPrice(), menuitem.getExplanation());
            sumPrice += menuitem.getPrice();
        }

        System.out.println("""
                
                [ Total ]""");
        System.out.printf("W %.1f %n", sumPrice);


    }
}