package Lv3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


//        생성자 체이닝을 표시하기 위해, Lv1 예시에서 CheeseBurger의 설명 제거 생성 / Hamburger의 Price 제거 생성
        MenuItem menuItem1 = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem2 = new MenuItem("SmokeShack ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem3 = new MenuItem("CheeseBurger ", 6.9);
        MenuItem menuItem4 = new MenuItem("Hamburger ", "비프패티를 기반으로 야채가 들어간 기본버거");

        ArrayList<MenuItem> menuList = new ArrayList<>();

        menuList.add(menuItem1);
        menuList.add(menuItem2);
        menuList.add(menuItem3);
        menuList.add(menuItem4);


        Kiosk hamburgerKiosk = new Kiosk(menuList);

        hamburgerKiosk.start();

    }




}