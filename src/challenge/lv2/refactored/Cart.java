package challenge.lv2.refactored;

import java.util.ArrayList;

public class Cart implements Cloneable, iConsolable {
    private ArrayList<MenuItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }


    public void addItem(MenuItem item) {
        this.addItem(item, 1.0);
    }

    public void addItem(MenuItem item, double discount) {
        int index = items.indexOf(item); // 동일한 아이템의 인덱스 찾기
        if (index >= 0) {
            // 이미 존재하는 경우 수량 증가
            items.get(index).increaseAmount();
            items.get(index).saleRevenue(discount);
        } else {
            item.increaseAmount();
            item.saleRevenue(discount);
            // 새로운 아이템이라면 리스트에 추가
            items.add(item);
        }
    }

    public double getTotalRevenue() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getSalePrice();
        }
        return total;
    }


    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    @Override
    public String getInformation(int index) {
        return String.format("%d", index);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}