package View;

import javax.swing.*;
import java.awt.*;

public class ListLabel extends JLabel {
    public ListLabel(String text, int width) {
        StyleSettings style = StyleSettings.getInstance();
        setText(text);
        setFont(style.getMicroFont());
        setMinimumSize(new Dimension(width, 50));
        setMaximumSize(new Dimension(width, 50));
        setPreferredSize(new Dimension(width, 50));
        setBackground(style.getBackgroundColor_LIGHT());
        setForeground(style.getTextColor_LIGHT());
    }
}
