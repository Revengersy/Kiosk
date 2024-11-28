package challenge.lv2.refactored;

import java.util.List;

public class Console {

    private Console() {
    }

    public static <T extends Consolable> void printConsoleItems(List<T> items, int standardIndex) {
//        items를 순회하면서, standardIndex부터 시작해서 1씩 더해가며 아이템들을 콘솔에 출력
//        아이템들은 Consolable을 구현하고 있음(Menu, MenuItem 등)
        for (T item : items) {
            System.out.println(item.getItemsInformation(standardIndex));
            standardIndex++;
        }
    }

    public static <T extends Consolable> T selectItem(List<T> items, int userInput) {
        T selectedItem = items.get(userInput - 1);
        return selectedItem.getBasicItem();
    }

    public static <T extends Consolable> boolean isValidInput(List<T> items, int userInput, int standardIndex) {
        if (userInput < standardIndex + items.size()) {
            return true;
        }
        return false;
    }
}
