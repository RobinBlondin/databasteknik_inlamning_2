package View;

import Controller.Repository;
import javax.swing.*;
import java.awt.*;

public class FilterPanel<T> extends JPanel {
    private Repository repo;
    private JComboBox<String> brandBox;
    private JComboBox<String> modelBox;
    private JComboBox<String> colorBox;
    private JComboBox<String> sizeBox;
    private JComboBox<String> categoryBox;
    private JLabel brandLabel;
    private JLabel modelLabel;
    private JLabel colorLabel;
    private JLabel sizeLabel;
    private JLabel priceLabel;
    private JLabel emptyLabel;

    public FilterPanel(Repository repo) {
        this.repo = repo;
        StyleSettings style = StyleSettings.getInstance();


        brandBox = new JComboBox<>();
        modelBox = new JComboBox<>();
        colorBox = new JComboBox<>();
        sizeBox = new JComboBox<>();
        categoryBox = new JComboBox<>();
        brandLabel = new JLabel("Brand");
        modelLabel = new JLabel("Model");
        colorLabel = new JLabel("Color");
        sizeLabel = new JLabel("Size");
        priceLabel = new JLabel("Price");
        emptyLabel = new JLabel();

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(800, 75));
        brandLabel.setFont(style.getSmallFontBold());
        modelLabel.setFont(style.getSmallFontBold());
        colorLabel.setFont(style.getSmallFontBold());
        sizeLabel.setFont(style.getSmallFontBold());
        priceLabel.setFont(style.getSmallFontBold());

        brandLabel.setBackground(style.getBackgroundColor_LIGHT());
        modelLabel.setBackground(style.getBackgroundColor_LIGHT());
        colorLabel.setBackground(style.getBackgroundColor_LIGHT());
        sizeLabel.setBackground(style.getBackgroundColor_LIGHT());
        priceLabel.setBackground(style.getBackgroundColor_LIGHT());
        emptyLabel.setBackground(style.getBackgroundColor_LIGHT());

        brandLabel.setForeground(style.getTextColor_SELECTED());
        modelLabel.setForeground(style.getTextColor_SELECTED());
        colorLabel.setForeground(style.getTextColor_SELECTED());
        sizeLabel.setForeground(style.getTextColor_SELECTED());
        priceLabel.setForeground(style.getTextColor_SELECTED());

        brandLabel.setPreferredSize(new Dimension(150, 25));
        modelLabel.setPreferredSize(new Dimension(175, 25));
        colorLabel.setPreferredSize(new Dimension(100, 25));
        sizeLabel.setPreferredSize(new Dimension(50, 25));
        priceLabel.setPreferredSize(new Dimension(100, 25));
        emptyLabel.setPreferredSize(new Dimension(175, 25));

        brandBox.setPreferredSize(new Dimension(150, 25));
        modelBox.setPreferredSize(new Dimension(175, 25));
        colorBox.setPreferredSize(new Dimension(100, 25));
        sizeBox.setPreferredSize(new Dimension(50, 25));
        categoryBox.setPreferredSize(new Dimension(100, 25));


        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        northPanel.setBackground(style.getBackgroundColor_LIGHT());
        northPanel.setAlignmentX(SwingConstants.LEFT);
        northPanel.add(brandBox);
        northPanel.add(modelBox);
        northPanel.add(colorBox);
        northPanel.add(sizeBox);
        northPanel.add(categoryBox);
        northPanel.add(emptyLabel);


        JPanel southPanel = new JPanel();
        southPanel.setBackground(style.getBackgroundColor_LIGHT());
        southPanel.add(brandLabel);
        southPanel.add(modelLabel);
        southPanel.add(colorLabel);
        southPanel.add(sizeLabel);
        southPanel.add(priceLabel);
        southPanel.add(emptyLabel);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.CENTER);
    }
}
