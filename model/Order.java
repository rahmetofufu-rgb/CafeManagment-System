package model;

import java.util.*;

public class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        for (OrderItem oi : items) {
            if (oi.getItem().getName().equals(item.getName())) {
                oi.increase();
                return;
            }
        }
        items.add(new OrderItem(item));
    }

    public List<OrderItem> getItems() { return items; }

    public double getTotal() {
        double total = 0;
        for (OrderItem oi : items) total += oi.getTotal();
        return total;
    }

    public void clear() {
        items.clear();
    }
}