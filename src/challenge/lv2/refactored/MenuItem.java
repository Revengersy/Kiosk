package challenge.lv2.refactored;

public class MenuItem implements Consolable {
    private final String name;
    private final double price;
    private final String explanation;

    private int amount = 0;
    private double totalSale = 0;

//    생성자 체이닝으로 이름, 가격이 있으면 생성 보장
    public MenuItem(String name, double price) {
        this(name, price, "(설명 입력되지 않음)");
    }

    public MenuItem(String name, double price, String explanation) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }


    public double getTotalSale() {
        return totalSale;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public void increaseAmount() {
        amount++;
    }

    public void sellMore(double saleAmount) {
        totalSale += saleAmount;
    }


    @Override
    public String getItemsInformation(int index) {
        return String.format("%d. %-10s | %.2f | %10s", index, this.name, this.price, this.explanation);
    }

    @Override
    public MenuItem getBasicItem() {
        return  new MenuItem(this.name, this.price, this.explanation);
    }
}
