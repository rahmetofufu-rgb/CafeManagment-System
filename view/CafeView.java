package view;
import javax.swing.*;
import java.awt.*;

public class CafeView extends JFrame {
  public JPanel menuPanel;
    public JPanel cartPanel;
    public JLabel totalLabel;
    public JTextField tableField;
    public JButton payBtn;

    public CafeView() {
        setTitle("Cafe Dashboard");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(20, 20, 20));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(150, getHeight()));

        JLabel logo = new JLabel("☕ Cafe");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Arial", Font.BOLD, 18));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(logo);

        add(sidebar, BorderLayout.WEST);

        // Top bar
        JPanel top = new JPanel();
        top.setBackground(new Color(45, 45, 45));
        JLabel title = new JLabel("Self Ordering System");
        title.setForeground(Color.WHITE);
        top.add(title);
        add(top, BorderLayout.NORTH);
         menuPanel = new JPanel(new GridLayout(0, 3, 15, 15));
        menuPanel.setBackground(new Color(240, 240, 240));
        add(new JScrollPane(menuPanel), BorderLayout.CENTER);

        // Cart Panel
        cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
        cartPanel.setBackground(Color.WHITE);

        totalLabel = new JLabel("Total: 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel right = new JPanel(new BorderLayout());
        right.setPreferredSize(new Dimension(300, getHeight()));
        right.add(new JScrollPane(cartPanel), BorderLayout.CENTER);
        right.add(totalLabel, BorderLayout.SOUTH);

        add(right, BorderLayout.EAST);

        // Bottom panel
        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Table:"));
        tableField = new JTextField(5);
        bottom.add(tableField);

        payBtn = new JButton("Pay Now");
        payBtn.setBackground(new Color(0, 150, 0));
        payBtn.setForeground(Color.WHITE);
        bottom.add(payBtn);

        add(bottom, BorderLayout.SOUTH);
    }
}
