package challenge.lv2.refactored;

public class MenuItem implements Cloneable, iConsolable {
    private final String name;
    private final double price;
    private final String explanation;
    private double salePrice = 0.0;
    private int amount = 0; // 담긴 수량

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

    public int getAmount() {
        return amount;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void increaseAmount() {
        this.amount++;
    }

    public void decreaseAmount() {
        this.amount--;
    }

    public void saleRevenue(double discount) {
        this.salePrice += this.price * (1 - discount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MenuItem)) return false;
        MenuItem other = (MenuItem) obj;
        return name.equals(other.name) && price == other.price; // 이름과 가격이 동일하면 같은 아이템으로 간주
    }


    @Override
    public String getInformation(int index) {
        if (this.amount > 0) {
            return String.format("%d. %s | 총 판매금액: %.2f | 총 판매 갯수: %d개 ", index, this.name, this.salePrice, this.amount);
        } else {
            return String.format("%d. %s | %.2f | %s", index, name, price, explanation);
        }
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}