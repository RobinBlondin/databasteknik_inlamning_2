package View;

import Controller.ActionListener;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    public ButtonPanel(String text, MainFrame mainFrame) {
        StyleSettings style = StyleSettings.getInstance();
        this.setLayout(new BorderLayout());

        JButton button = new JButton();
        button.setText(text);
        button.setPreferredSize(new Dimension(100, 50));
        button.setFont(style.getMicroFontBold());
        button.setBackground(style.getBackgroundColor_DARK());
        button.setForeground(style.getTextColor_DARK());
        button.setBorder(BorderFactory.createEmptyBorder(0, 25, 0,0));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusPainted(false);
        button.setVisible(true);
        button.addActionListener(new ActionListener(mainFrame, mainFrame.getShopPanel(), mainFrame.getLoginPanel()));

        this.add(button, BorderLayout.CENTER);
        this.setVisible(true);
    }

}
