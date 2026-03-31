package model;

public class OrderItem {
   private MenuItem item;
    private int quantity = 1;

    public OrderItem(MenuItem item) {
        this.item = item;
    }

    public void increase() { quantity++; }
    public void decrease() { if (quantity > 1) quantity--; }

    public int getQuantity() { return quantity; }
    public MenuItem getItem() { return item; }

    public double getTotal() {
        return item.getPrice() * quantity;
    }

}
