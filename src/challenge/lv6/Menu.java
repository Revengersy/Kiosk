package challenge.lv6;

import java.util.ArrayList;

public class Menu {
    private static ArrayList<String> categoryNames = new ArrayList<String>();

    private ArrayList<MenuItem> menuItems;
    private String categoryOfThisMenu;
    private String explanationOfThisMenu;

    public Menu(String categoryName) {
        this(categoryName, "(설명이 추가되지 않았습니다)");
    }

    public Menu(String categoryName, String explanationOfThisMenu) {
        categoryNames.add(categoryName);
        this.categoryOfThisMenu = categoryName;
        this.explanationOfThisMenu = explanationOfThisMenu;
        this.menuItems = new ArrayList<>();
    }

    public static ArrayList<String> getCategoryNames() {
        return categoryNames;
    }

    public String getCategoryOfThisMenu() {
        return categoryOfThisMenu;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuExplanation(String explanation) {
        this.explanationOfThisMenu = explanation;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void printMenu() {
        System.out.printf("%-11s:%s%n", categoryOfThisMenu, explanationOfThisMenu);
    }

    public void printMenuItems() {
        for (MenuItem menuItem : menuItems) {
            menuItem.printItem();
        }
    }
}
