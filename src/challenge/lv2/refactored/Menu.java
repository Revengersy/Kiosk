package challenge.lv2.refactored;

import java.util.ArrayList;

public class Menu implements Cloneable, iConsolable {

    private ArrayList<MenuItem> menuItems;
    private final String category;
    private String explanation;

    public Menu(String categoryName) {
        this(categoryName, "(설명이 추가되지 않았습니다)");
    }

    public Menu(String category, String explanation) {
        this.category = category;
        this.explanation = explanation;
        this.menuItems = new ArrayList<>();
    }

    public ArrayList<MenuItem> getItems(){
        return this.menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public String getInformation(int index) {
        return String.format("%d.%-15s\t|%s", index, category, explanation);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
