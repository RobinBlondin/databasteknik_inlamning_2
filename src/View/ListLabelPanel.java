package View;

import Controller.Repository;
import Model.MainFrameCallback;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListLabelPanel extends JPanel {

    public ListLabelPanel(int shoeId, String amount, Repository repo, boolean withCartButton, MainFrameCallback callback, String... strings) {
        StyleSettings style = StyleSettings.getInstance();
        this.setLayout(new BorderLayout());
        this.setBackground(style.getBackgroundColor_LIGHT());
        this.setPreferredSize(new Dimension(600, 50));
        this.setMaximumSize(new Dimension(600, 50));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, style.getButtonColor()));

        String brand = strings.length > 0 ? strings[0] : "";
        String model = strings.length > 1 ? strings[1] : "";
        String color = strings.length > 2 ? strings[2] : "";
        String size = strings.length > 3 ? strings[3] : "";
        String price = strings.length > 4 ? strings[4] : "";

        CartButton cartButton = new CartButton(shoeId, repo, callback);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(style.getBackgroundColor_LIGHT());
        centerPanel.setPreferredSize(new Dimension(600, 50));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));


        List<JLabel> labels = List.of(new ListLabel(brand, 140), new ListLabel(model, 140), new ListLabel(color, 100), new ListLabel(size, 50), new ListLabel(price, 75), new ListLabel(amount, 45));
        for (int i = 0; i < strings.length + 1; i++) {
           centerPanel.add(labels.get(i));
        }

        if (withCartButton) {
            centerPanel.add(cartButton);
        }

        add(centerPanel, BorderLayout.CENTER);

        centerPanel.revalidate();
        centerPanel.repaint();
        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }
}
