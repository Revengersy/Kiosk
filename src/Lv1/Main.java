package Lv1;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String tmp = getVaildInputWithRegex("정수를 입력해주세요", "[0-9]");
        int userInput = Integer.parseInt(tmp);
        System.out.println("입력된 숫자: " + userInput);
        System.out.println(sc.next());



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