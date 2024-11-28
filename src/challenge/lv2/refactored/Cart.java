package challenge.lv2.refactored;

import java.util.ArrayList;

public class Cart {
    private ArrayList<MenuItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        this.addItem(item, 0.0);
    }

    public void addItem(MenuItem item, double discount) {
        int index = items.indexOf(item); // 동일한 아이템의 인덱스 찾기
        if (index >= 0) {
            // 이미 존재하는 경우 수량 증가
            items.get(index).increaseAmount();
            items.get(index).sellMore((1 - discount) * item.getPrice());
        } else {
            item.increaseAmount();
            item.sellMore((1 - discount) * item.getPrice());
            // 새로운 아이템이라면 리스트에 추가
            items.add(item);
        }
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void clear(){
        items.clear();
    }

    public ArrayList<MenuItem> getItems(){
        return items;
    }

    public double getTotalRevenue() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getTotalSale();
        }
        return total;
    }


}
