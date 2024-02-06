package View;

import Controller.Reporter;
import Controller.Repository;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final Reporter reporter;
    private final Repository repo;

    private final ScrollableGridLayout scrollableGridLayout;

    public MainFrame() {
        reporter = new Reporter();
        repo = new Repository();
        scrollableGridLayout = new ScrollableGridLayout(this, reporter, repo);

        StyleSettings style = StyleSettings.getInstance();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000, 1000));
        this.setTitle("Soles with soul");

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("images/logo.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(67, 67, Image.SCALE_SMOOTH));
        JLabel logoLabel = new JLabel(icon);
        topPanel.setBackground(style.getBackgroundColor_SELECTED());
        topPanel.setPreferredSize(new Dimension(1000, 75));

        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(style.getBackgroundColor_DARK());
        emptyPanel.setPreferredSize(new Dimension(200, 100));
        emptyPanel.setVisible(true);

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(8, 1));
        sidePanel.setBackground(style.getBackgroundColor_DARK());
        sidePanel.setPreferredSize(new Dimension(200, 1000));
        sidePanel.add(emptyPanel);
        sidePanel.add(new ButtonPanel("Button1", this));
        sidePanel.add(new ButtonPanel("Button2", this));
        sidePanel.add(new ButtonPanel("Button3", this));
        sidePanel.add(new ButtonPanel("Button4", this));
        sidePanel.add(new ButtonPanel("Button5", this));
        sidePanel.add(new ButtonPanel("Button6", this));

        this.add(topPanel, BorderLayout.NORTH);
        this.add(sidePanel, BorderLayout.WEST);
        this.add(scrollableGridLayout, BorderLayout.CENTER);
        this.setVisible(true);


    }
}
