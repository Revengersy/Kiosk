package challenge.lv2.refactored;

import java.util.ArrayList;
import java.util.Arrays;

public class Kiosk {
    private ArrayList<Menu> basicMenus;
    private ArrayList<Menu> cartMenus;
    private Cart cart;
    private final ArrayList<UserType> userTypes;

    public Kiosk() {
        basicMenus = new ArrayList<>();
        cartMenus = new ArrayList<>();
        cart = new Cart();
        userTypes = new ArrayList<>(Arrays.asList(UserType.values()));

        setCartMenus();
    }

    public void start() {
        while (true) {
            boolean isCartEmpty = cart.isEmpty();

            Console.printConsoleItems(basicMenus, 1);
            if (!isCartEmpty) {
                Console.printConsoleItems(cartMenus, 1 + basicMenus.size());
            }
            System.out.println("0. 종료하기");

            int userInput = InputHandler.getUserInput("메뉴를 골라 주세요", "[0-9]+");

            if (userInput == 0) {
                System.out.println("종료됩니다");
                break;
            }
            if (Console.isValidInput(basicMenus, userInput, 1)) {
                handleItemSelection(userInput);
            } else if (!isCartEmpty && userInput == basicMenus.size() + 1) {
                handleCartOrder();
            } else if (!isCartEmpty && userInput == basicMenus.size() + 2) {
                handleCartDelete();
            } else {
                System.out.println("범위 밖 입력 테스트 완료");
                continue;
            }
        }
    }


    public void addBasicMenus(Menu... menus) {
        basicMenus.addAll(Arrays.asList(menus));
    }

    private void setCartMenus() {
        Menu menu1 = new Menu("장바구니 확인하기");
        Menu menu2 = new Menu("장바구니 아이템 삭제하기");

        this.cartMenus.add(menu1);
        this.cartMenus.add(menu2);
    }

    private void handleItemSelection(int userInput) {
        while (true) {
            Menu tmpMenu = Console.selectItem(basicMenus, userInput);
            ArrayList<MenuItem> tmpItems = tmpMenu.getMenuItems();

            System.out.println("0. 이전으로");
            Console.printConsoleItems(tmpItems, 1);

            int selectItemInput = InputHandler.getUserInput("장바구니에 담을 아이템을 골라 주세요", "[0-9]+");

            if (selectItemInput == 0) {
                break;
            }
            if (Console.isValidInput(tmpItems, selectItemInput, 1)) {
                if (InputHandler.isOkay("확정하시겠습니까?(확정이면 1 입력)")) {
                    System.out.println(Console.selectItem(tmpItems, selectItemInput).getItemsInformation(1));
                    cart.addItem(Console.selectItem(tmpItems, selectItemInput));
                    System.out.println("장바구니에 물건이 담겼습니다.");
                }
            } else {
                System.out.println("범위에서 벗어난 값을 골랐습니다.");
            }
        }
    }

    private void handleCartOrder() {
        order_loop:
        while (true) {
            Console.printConsoleItems(cart.getItems(), 1);

            System.out.printf("총 금액: %.2f%n", cart.getTotalRevenue());

            if (InputHandler.isOkay("구매하시겠습니까? (1을 누르면 구매)")) {
                while (true) {
                    System.out.println("0. 구매취소");
                    Console.printConsoleItems(userTypes, 1);

                    int discountInput = InputHandler.getUserInput("할인 항목을 골라 주세요", "[0-9]+");

                    if (discountInput == 0) {
                        break;
                    }
                    if (Console.isValidInput(userTypes, discountInput, 1)) {
                        UserType tmp = Console.selectItem(userTypes, discountInput);
                        System.out.printf("할인 적용 후 지불 금액: %.2f%n", cart.getTotalRevenue() * (1 - tmp.getDiscountRate()));
                        if (InputHandler.isOkay("확정하시겠습니까? (1을 누르면 지불 확정)")) {
                            System.out.println("구매되었습니다.");
                            cart.clear();
                            break order_loop;
                        }
                    }
                }
            } else {
                System.out.println("이전 메뉴로 돌아갑니다");
                break;
            }
        }
    }

    private void handleCartDelete() {
        while (true) {
            Console.printConsoleItems(cart.getItems(), 1);
            System.out.println("0. 이전으로");

            int deleteInput = InputHandler.getUserInput("삭제할 항목을 골라 주세요", "[0-9]+");
            ArrayList<MenuItem> tmpItems = cart.getItems();

            if (deleteInput == 0) {
                break;
            }
            if (Console.isValidInput(tmpItems, deleteInput, 1)) {
                String itemNameToRemove = tmpItems.get(deleteInput - 1).getName().trim();
                ArrayList<MenuItem> cartItems = new ArrayList<>(tmpItems.stream()
                        .filter(item -> !item.getName().trim().equals(itemNameToRemove))
                        .toList());
                cart.setItems(cartItems);
                System.out.println("장바구니에서 항목이 제거되었습니다");
            }

        }
    }
}
