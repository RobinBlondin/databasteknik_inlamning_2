package View;

import Controller.Reporter;
import Controller.Repository;
import javax.swing.*;
import java.awt.*;

public class ShopPanel extends JPanel {
    public ShopPanel(Repository repo, Reporter reporter, MainFrame mainFrame) {
        ListPanel listPanel = new ListPanel(mainFrame, reporter, repo);
        StyleSettings style = StyleSettings.getInstance();

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1000, 1000));

        ImageIcon icon = new ImageIcon("images/logo.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(67, 67, Image.SCALE_SMOOTH));
        JLabel logoLabel = new JLabel(icon);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(style.getBackgroundColor_SELECTED());
        northPanel.setPreferredSize(new Dimension(1000, 75));

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

        northPanel.add(logoLabel);

        centerPanel.add(new FilterPanel<>(repo), BorderLayout.NORTH);
        centerPanel.add(listPanel, BorderLayout.CENTER);

        westPanel.add(Box.createRigidArea(new Dimension(0, 150)));
        westPanel.add(new ButtonPanel("Button1", mainFrame));
        westPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        westPanel.add(new ButtonPanel("Button2", mainFrame));
        westPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        westPanel.add(new ButtonPanel("Button3", mainFrame));
        westPanel.add(Box.createRigidArea(new Dimension(0, 300)));
        westPanel.add(new ButtonPanel("Button5", mainFrame));
        westPanel.add(Box.createRigidArea(new Dimension(0, 300)));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
