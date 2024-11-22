package challenge.lv2;

public class MenuItem implements Cloneable {
    private final String name;
    private double price;
    private final String explanation;

    public MenuItem(String name) {
        this(name, "(설명 입력되지 않음)");
    }

    public MenuItem(String name, double price) {
        this(name, price, "(설명 입력되지 않음)");
    }

    public MenuItem(String name, String explanation) {
        this(name, 5.0, explanation);
    }

    public MenuItem(String name, double price, String explanation) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getExplanation() {
        return explanation;
    }

    public void applyDiscount(double discount) {
        price *= 1 - discount ;
    }

    public void printItem() {
        System.out.println(name + " | " + price + " | " + explanation);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
