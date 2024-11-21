package Lv3;

public class MenuItem {
    public String name;
    public double price;
    public String explanation;

    public MenuItem(String name){
        this (name, "(설명 입력되지 않음)");
    }

    public MenuItem(String name, double price){
        this (name, price, "(설명 입력되지 않음)");
    }

    public MenuItem(String name, String explanation){
        this (name, 5.0 , explanation);
    }

    public MenuItem(String name, double price, String explanation) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

}
