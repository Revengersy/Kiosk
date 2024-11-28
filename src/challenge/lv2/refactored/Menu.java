package challenge.lv2.refactored;

import java.util.ArrayList;
import java.util.Collections;

public class Menu implements Consolable {
    private final String name;
    private final String explanation;
    private ArrayList<MenuItem> menuItems;

    // 생성자 체이닝으로 이름만 있어도 생성 보장
    public Menu(String name) {
        this(name, "(이름 설정 안 됨)");
    }

    public Menu(String name, String explanation) {
        this.name = name;
        this.explanation = explanation;
        menuItems = new ArrayList<>();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem... menuItems) {
        Collections.addAll(this.menuItems, menuItems);
    }

    @Override
    public String getItemsInformation(int index) {
        return String.format("%d. %-10s | %10s", index, this.name, this.explanation);
    }

    @Override
    public Menu getBasicItem() {
        Menu copy = new Menu(this.name, this.explanation);
        copy.menuItems = new ArrayList<>(this.menuItems); // Shallow copy of the list
        return copy;
    }


}
