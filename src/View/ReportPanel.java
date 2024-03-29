package View;

import Controller.Reporter;
import Model.MainFrameCallback;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
    private final ListPanel listPanel;
    private final ComboBoxPanel comboBoxPanel;
    public ReportPanel(Reporter reporter, MainFrameCallback callback) {
        this.listPanel = new ListPanel(reporter, false, callback);
        comboBoxPanel = new ComboBoxPanel(reporter);

        StyleSettings style = StyleSettings.getInstance();

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1000, 1000));

        LogoPanel logoPanel = new LogoPanel();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(style.getBackgroundColor_SELECTED());
        northPanel.setPreferredSize(new Dimension(1000, 75));
        northPanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0, style.getButtonColor()));

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.setBackground(style.getBackgroundColor_DARK());
        westPanel.setPreferredSize(new Dimension(200, 1000));

        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(style.getBackgroundColor_DARK());
        eastPanel.setPreferredSize(new Dimension(200, 1000));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(style.getBackgroundColor_LIGHT());
        centerPanel.setPreferredSize(new Dimension(600, 925));

        JPanel southPanel = new JPanel();
        southPanel.setBackground(style.getBackgroundColor_SELECTED());
        southPanel.setPreferredSize(new Dimension(1000, 100));
        southPanel.setBorder(BorderFactory.createMatteBorder(1,0,0,0, style.getButtonColor()));

        northPanel.add(logoPanel);

        centerPanel.add(listPanel, BorderLayout.CENTER);

        westPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        westPanel.add(comboBoxPanel);
        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(new ButtonPanel(4, "Who bought what", true, callback));
        westPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        westPanel.add(new ButtonPanel(5, "Orders per buyer", true, callback));
        westPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        westPanel.add(new ButtonPanel(6, "Customer total", true, callback));
        westPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        westPanel.add(new ButtonPanel(7, "City total", true, callback));
        westPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        westPanel.add(new ButtonPanel(8, "Most sold", true, callback));
        westPanel.add(Box.createRigidArea(new Dimension(0, 220)));
        westPanel.add(new ButtonPanel(9, "Back", true, callback));
        westPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public ListPanel getListPanel() {
        return listPanel;
    }
    public ComboBoxPanel getComboBoxPanel() {
        return comboBoxPanel;
    }
}

