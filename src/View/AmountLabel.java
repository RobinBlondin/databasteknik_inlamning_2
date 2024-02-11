package View;

import javax.swing.*;
import java.awt.*;

public class AmountLabel extends JLabel {
    public AmountLabel(String text) {
        StyleSettings style = StyleSettings.getInstance();
        setFont(style.getMicroFont());
        setMinimumSize(new Dimension(45, 50));
        setMaximumSize(new Dimension(45, 50));
        setPreferredSize(new Dimension(45, 50));
        setForeground(style.getTextColor_LIGHT());
        setBorder(BorderFactory.createEmptyBorder());
        setText(text);

    }
}
