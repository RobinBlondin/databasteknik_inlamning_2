package View;

import javax.swing.*;
import java.awt.*;

public class CartLabel extends JPanel {
    public CartLabel(String shoeName, String quantity) {
        StyleSettings style = StyleSettings.getInstance();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(style.getBackgroundColor_DARK());
        setPreferredSize(new Dimension(180, 25));
        setMinimumSize(new Dimension(180, 25));
        setMaximumSize(new Dimension(180, 25));

        JLabel nameLabel = new JLabel(shoeName);
        JLabel quantityLabel = new JLabel(quantity);

        nameLabel.setPreferredSize(new Dimension(140, 25));
        quantityLabel.setPreferredSize(new Dimension(40, 25));
        nameLabel.setMinimumSize(new Dimension(140, 25));
        quantityLabel.setMinimumSize(new Dimension(40, 25));
        nameLabel.setMaximumSize(new Dimension(140, 25));
        quantityLabel.setMaximumSize(new Dimension(40, 25));

        nameLabel.setBackground(style.getBackgroundColor_DARK());
        quantityLabel.setBackground(style.getBackgroundColor_DARK());

        nameLabel.setForeground(style.getTextColor_LIGHT());
        quantityLabel.setForeground(style.getTextColor_LIGHT());

        add(Box.createHorizontalStrut(10));
        add(nameLabel);
        add(quantityLabel);
        add(Box.createHorizontalStrut(10));
    }
}
