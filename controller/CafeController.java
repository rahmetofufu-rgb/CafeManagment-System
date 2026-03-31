package controller;
import model.*;
import model.MenuItem;
import view.CafeView;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CafeController {
   private List<MenuItem> menu = new ArrayList<>();
    private Order order = new Order();
    private CafeView view;

    public CafeController(CafeView view) {
        this.view = view;
        initializeMenu();
        loadMenuUI();
        setupActions();
    }

    private void initializeMenu() {
        menu.add(new MenuItem("Espresso Coffee", 60, "Drink"));
        menu.add(new MenuItem("Traditional Coffee (Bunna)", 70, "Drink"));
menu.add(new MenuItem("Black Tea", 40, "Drink"));
menu.add(new MenuItem("Milk Tea", 50, "Drink"));
menu.add(new MenuItem("Orange Juice", 80, "Drink"));
menu.add(new MenuItem("Mango Juice", 90, "Drink"));
menu.add(new MenuItem("Coca-Cola (330ml)", 40, "Drink"));
menu.add(new MenuItem("Fanta (330ml)", 40, "Drink"));
menu.add(new MenuItem("Sprite (330ml)", 40, "Drink"));

menu.add(new MenuItem("Chicken Burger", 150, "Food"));
menu.add(new MenuItem("Beef Burger", 180, "Food"));
menu.add(new MenuItem("Veg Burger", 120, "Food"));
menu.add(new MenuItem("Margherita Pizza", 250, "Food"));
menu.add(new MenuItem("Chicken Pizza", 300, "Food"));
menu.add(new MenuItem("Beef Pizza", 320, "Food"));
menu.add(new MenuItem("Mixed Veg Pizza", 280, "Food"));
menu.add(new MenuItem("Club Sandwich", 160, "Food"));
menu.add(new MenuItem("Chicken Sandwich", 150, "Food"));
menu.add(new MenuItem("Beef Sandwich", 170, "Food"));
menu.add(new MenuItem("Cheese Sandwich", 140, "Food"));
menu.add(new MenuItem("Fried Chicken (Full)", 400, "Food"));
menu.add(new MenuItem("Fried Chicken (Half)", 220, "Food"));
menu.add(new MenuItem("Traditional Ethiopian Plate (Injera + Stew)", 200, "Food"));
menu.add(new MenuItem("Shiro w/ Injera", 180, "Food"));
   menu.add(new MenuItem("Tibs (Beef) w/ Injera", 350, "Food"));
    }

    private void loadMenuUI() {
        for (MenuItem item : menu) {
            JPanel card = new JPanel();
            card.setLayout(new BorderLayout());
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            card.setBackground(Color.WHITE);

            JLabel name = new JLabel(item.getName(), SwingConstants.CENTER);
            JLabel price = new JLabel("$" + item.getPrice(), SwingConstants.CENTER);

            JButton addBtn = new JButton("Add");
            addBtn.setBackground(new Color(60,120,200));
            addBtn.setForeground(Color.WHITE);
            addBtn.addActionListener(e -> {
                order.addItem(item);
                refreshCart();
            });

            card.add(name, BorderLayout.NORTH);
            card.add(price, BorderLayout.CENTER);
            card.add(addBtn, BorderLayout.SOUTH);

            view.menuPanel.add(card);
        }
    }

    private void setupActions() {
        view.payBtn.addActionListener(e -> processPayment());
    }

    private void refreshCart() {
        view.cartPanel.removeAll();

        for (OrderItem oi : order.getItems()) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel name = new JLabel(oi.getItem().getName());
            JLabel qty = new JLabel(" x" + oi.getQuantity());
            JLabel price = new JLabel(" = " + oi.getTotal());

            JButton plus = new JButton("+");
            JButton minus = new JButton("-");

            plus.addActionListener(e -> { oi.increase(); refreshCart(); });
            minus.addActionListener(e -> { oi.decrease(); refreshCart(); });

             row.add(name);
            row.add(minus);
            row.add(qty);
            row.add(plus);
            row.add(price);

            view.cartPanel.add(row);
        }

        view.totalLabel.setText("Total: " + order.getTotal());
        view.cartPanel.revalidate();
        view.cartPanel.repaint();
    }

    private void processPayment() {
        if (view.tableField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Enter table number");
            return;
        }

        JOptionPane.showMessageDialog(view,
                "Payment Successful! Total: " + order.getTotal());

        order.clear();
        refreshCart();
        view.tableField.setText("");
    }

}
