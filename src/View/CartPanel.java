package View;

import Controller.Reporter;
import Model.Shoe;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class CartPanel extends JPanel {
    private final JPanel gridPanel;
    public CartPanel(Reporter reporter) {
        StyleSettings style = StyleSettings.getInstance();
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200, 800));
        this.setBackground(style.getBackgroundColor_DARK());

        gridPanel = new JPanel();
        gridPanel.setPreferredSize(new Dimension(200, 50));
        gridPanel.setBackground(style.getBackgroundColor_DARK());
        this.setBackground(style.getBackgroundColor_DARK());

        JScrollPane scrollPane = new JScrollPane(gridPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setAlignmentY(SwingUtilities.NORTH);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public void refresh(Map<Shoe, Integer> map) {
        gridPanel.removeAll();
        map.forEach((k, v) -> gridPanel.add(new CartLabel(k.getBrand().getName() + " " + k.getModel(), String.valueOf(v))));
        gridPanel.revalidate();
        gridPanel.repaint();
    }
}
