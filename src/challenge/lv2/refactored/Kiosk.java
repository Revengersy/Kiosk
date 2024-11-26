package challenge.lv2.refactored;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Kiosk {

    private ArrayList<Menu> basicMenus = new ArrayList<Menu>();
    private Cart cart;
    private ArrayList<Menu> cartMenus = new ArrayList<Menu>();
    private final List<UserType> userTypes = Arrays.asList(UserType.values());


    Kiosk() {
        cart = new Cart();

        Menu cartView = new Menu("장바구니 조회", "");
        Menu cartDelete = new Menu("장바구니 항목 지우기", "");
        cartMenus.add(cartView);
        cartMenus.add(cartDelete);

    }

    public void start() {
        while (true) {
            boolean flagItemsInCart = !cart.isEmpty();

            Console.printLine("0. 종료하기");
            Console.printItems(basicMenus, 1);
            if (flagItemsInCart) {
                Console.printItems(cartMenus, 1 + basicMenus.size());
            }

            int userInput = Console.getUserInput("메뉴를 골라 주세요.", "[0-9]+");

            if (Console.canEscape(userInput)) {
                Console.printLine("종료합니다");
                return;
            }
            if (Console.isPossibleIndex(basicMenus, 0, userInput)) {
                handleSelect(userInput);
            } else if (flagItemsInCart && userInput == basicMenus.size() + 1) {
                handleCartView();
            } else if (flagItemsInCart && userInput == basicMenus.size() + 2) {
                handleCartDelete();
            }
        }
    }

    public void addMenu(Menu... menus) {
        for (Menu menu : menus) {
            this.basicMenus.add(menu);
        }
    }

    private void handleSelect(int userInput) {
        while (true) {
            Menu selectedMenu = Console.getSelection(basicMenus, userInput);

            System.out.println(("0. 이전으로"));
            Console.printItems(selectedMenu.getItems(), 1);

            int itemInput = Console.getUserInput("아이템을 골라 주세요", "[0-9]+");

            if (Console.canEscape(itemInput)) {
                return;
            }
            if (Console.isPossibleIndex(selectedMenu.getItems(), 0, itemInput)) {
                if (Console.isOkay("주문을 확정하시겠습니까? (1: 확정, 나머지: 취소)")) {

                    discount_loop:
                    while (true) {
                        Console.printItems(userTypes, 1);

                        int discountInput = Console.getUserInput("할인 범위를 정해 주세요", "[0-9]+");

                        if (Console.isPossibleIndex(userTypes, 0, discountInput)) {
                            MenuItem selectedItem = Console.getSelection(selectedMenu.getItems(), itemInput);
                            try {
                                cart.addItem((MenuItem) selectedItem.clone(), UserType.getDiscountByIndex(discountInput));
                            } catch (CloneNotSupportedException e) {
                                throw new RuntimeException(e);
                            }
                            break discount_loop;
                        } else {
                            System.out.println("올바른 범위를 입력해 주세요");
                        }
                    }
                }
            }
        }
    }

    private void handleCartView(){
        Console.printItems(cart.getItems(), 1);
        System.out.printf("총 구매금액: %.2f", cart.getTotalRevenue());
        if (Console.isOkay("구매를 확정 하시겠습니까?(1: 구매완료, 나머지: 조회 종료)")) {
            System.out.println("구매완료");
            cart = new Cart();
        }
    }

    private void handleCartDelete(){
        while (!cart.isEmpty()) {
            Console.printLine("0. 이전으로");
            Console.printItems(cart.getItems(), 1);

            int deleteInput = Console.getUserInput("삭제할 항목이 있다면 골라주세요", "[0-9]+");

            if (Console.canEscape(deleteInput)) {
                break;
            }
            if (Console.isPossibleIndex(cart.getItems(), 0, deleteInput)) {
                if (Console.isOkay("정말로 삭제하시겠습니까?? (1: 확정, 나머지: 취소)")) {
                    Console.deleteSelection(cart.getItems(), deleteInput);
                }
            }
        }
    }

}