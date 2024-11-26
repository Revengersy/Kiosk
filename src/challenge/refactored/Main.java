package challenge.refactored;

public class Main {

    public static void main(String[] args) {

        Menu drinkMenu = new Menu("drink", "시원한 음료를 즐겨보세요");
        drinkMenu.addMenuItem(new MenuItem("Coca Cola", 2.5, "시원한 코카콜라"));
        drinkMenu.addMenuItem(new MenuItem("Pepsi", 2.5, "상쾌한 펩시"));
        drinkMenu.addMenuItem(new MenuItem("Lemonade", 3.0, "상큼한 레모네이드"));
        drinkMenu.addMenuItem(new MenuItem("Iced Tea", 3.0, "차가운 아이스티"));

        Menu hamburgerMenu = new Menu("hamburger");
        hamburgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        hamburgerMenu.addMenuItem(new MenuItem("SmokeShack ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        hamburgerMenu.addMenuItem(new MenuItem("CheeseBurger ", 6.9));
        hamburgerMenu.addMenuItem(new MenuItem("Hamburger ", "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu tempMenu = new Menu("임시 메뉴");

        Kiosk kiosk = new Kiosk();

        kiosk.addMenu(drinkMenu, hamburgerMenu, tempMenu);

        kiosk.start();
    }


}
