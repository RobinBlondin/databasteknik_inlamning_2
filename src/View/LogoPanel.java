package View;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {
    public LogoPanel() {
        StyleSettings style = StyleSettings.getInstance();
        ImageIcon logo = new ImageIcon("images/logo.png");
        ImageIcon logo2 = new ImageIcon("images/logo2.png");
        ImageIcon text = new ImageIcon("images/logoText2.png");

        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 0));
        JLabel logoLabel2 = new JLabel(logo2);
        logoLabel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        JLabel logoTextLabel = new JLabel(text);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        this.setBackground(style.getBackgroundColor_SELECTED());
        this.add(logoLabel);
        this.add(Box.createRigidArea(new Dimension(50, 0)));
        this.add(logoTextLabel);
        this.add(Box.createRigidArea(new Dimension(50, 0)));
        this.add(logoLabel2);
        this.setVisible(true);
    }
}
