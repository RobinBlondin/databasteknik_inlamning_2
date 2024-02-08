package View;

import javax.swing.*;

public class CustomLabel extends JLabel {
    public CustomLabel(String text) {
        StyleSettings style = StyleSettings.getInstance();
        this.setFont(style.getMicroFont());
        this.setText(text);
        this.setBackground(style.getBackgroundColor_LIGHT());
        this.setForeground(style.getTextColor_LIGHT());
    }
}
