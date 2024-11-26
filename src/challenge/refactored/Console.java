package challenge.refactored;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Console {

    private static final Scanner scanner = new Scanner(System.in);

    private Console() { }

    public static <T extends iConsolable> void printItems(List<T> items, int standardIndex) {
        for (T item : items) {
            System.out.println(item.getInformation(standardIndex));
            standardIndex++;
        }
    }

    public static void printLine(String message){
        System.out.println(message);
    }

    public static <T extends iConsolable> T getSelection(List<T> items, int userIndex) {
        return items.get(userIndex - 1);
    }

    public static <T extends iConsolable> List<T> mergeArrayLists(List<T>... lists) {
        List<T> mergedList = new ArrayList<>();

        // 각 ArrayList를 순회하면서 원소를 mergedList에 추가
        for (List<? extends T> list : lists) {
            mergedList.addAll(list);
        }

        return mergedList;
    }

    public static boolean canEscape(int userIndex){
        if( userIndex == 0 ){
            return true;
        }
        return false;
    }

    public static <T extends iConsolable> boolean isPossibleIndex(List<T> items, int standardIndex, int userIndex){
        return (userIndex > 0 && userIndex <= items.size() + standardIndex);
    }

    public static int getUserInput(String message, String regex) {
        System.out.println(message);
        while (!scanner.hasNext(regex)) {
            System.out.println("잘못된 값을 입력하였습니다.");
            scanner.next();
        }
        return Integer.parseInt(scanner.next());
    }

    public static <T extends iConsolable> void deleteSelection(List<T> items, int userInput){
        items.remove(userInput - 1);
    }

    public static boolean isOkay(String message) {
        System.out.println(message);
        if (scanner.next().equals("1")) {
            System.out.println("확인되었습니다.");
            return true;
        } else {
            return false;
        }
    }
}