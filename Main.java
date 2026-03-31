import view.CafeView;
import controller.CafeController;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CafeView view = new CafeView();
            new CafeController(view);
            view.setVisible(true);
        });
    }
}
