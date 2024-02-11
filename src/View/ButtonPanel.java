package View;

import Model.MainFrameCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ButtonPanel extends JPanel implements java.awt.event.ActionListener {
    private final int id;
    private final MainFrameCallback callback;

    public ButtonPanel(int id, String text, boolean leftAlign, MainFrameCallback callback) {
        StyleSettings style = StyleSettings.getInstance();
        this.id = id;
        //this.mainFrame = mainFrame;
        this.setBackground(style.getBackgroundColor_DARK());
        this.callback = callback;

        JButton button = new JButton();
        button.setText(text);
        button.setPreferredSize(new Dimension(175, 50));
        button.setFont(style.getMicroFontBold());
        button.setBackground(style.getBackgroundColor_DARK());
        button.setForeground(style.getButtonColor());
        button.setBorder(BorderFactory.createEmptyBorder(0, 15, 0,0));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.addActionListener(this);
        button.setFocusPainted(false);

        if(leftAlign) {
            button.setHorizontalAlignment(SwingConstants.LEFT);
        } else {
            button.setHorizontalAlignment(SwingConstants.CENTER);
        }

        this.add(button);
        this.setVisible(true);
    }

    public int getId() {
        return id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        ButtonPanel button = (ButtonPanel)source.getParent();
        callback.onButtonClicked(button.getId(), "");
    }
}
