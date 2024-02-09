package View;

import Controller.Reporter;
import Controller.Repository;
import Model.*;
import Model.Color;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FilterPanel extends JPanel {
    private final JComboBox<String> brandBox;
    private final JComboBox<String> colorBox;
    private final JComboBox<String> sizeBox;

    public FilterPanel(Reporter reporter, ListPanel listPanel) {
        StyleSettings style = StyleSettings.getInstance();

        brandBox = new JComboBox<>();
        colorBox = new JComboBox<>();
        sizeBox = new JComboBox<>();
        JComboBox<String> modelBox = new JComboBox<>();
        JComboBox<String> categoryBox = new JComboBox<>();

        brandBox.setBackground(style.getButtonColor());
        colorBox.setBackground(style.getButtonColor());
        sizeBox.setBackground(style.getButtonColor());
        modelBox.setBackground(style.getButtonColor());
        categoryBox.setBackground(style.getButtonColor());

       populateComboBoxes(reporter, brandBox, colorBox, sizeBox, modelBox, categoryBox);

        java.awt.event.ActionListener comboListener = e -> {
            List<String> list = reporter.filterShoes(
                    (String)brandBox.getSelectedItem(),
                    (String)modelBox.getSelectedItem(),
                    (String)colorBox.getSelectedItem(),
                    (String)sizeBox.getSelectedItem(),
                    (String)categoryBox.getSelectedItem());

            listPanel.refresh(list, 1);
        };

        brandBox.addActionListener(comboListener);
        modelBox.addActionListener(comboListener);
        colorBox.addActionListener(comboListener);
        sizeBox.addActionListener(comboListener);
        categoryBox.addActionListener(comboListener);

        JLabel brandLabel = new JLabel("Brand");
        JLabel modelLabel = new JLabel("Model");
        JLabel colorLabel = new JLabel("Color");
        JLabel sizeLabel = new JLabel("Size");
        JLabel priceLabel = new JLabel("Price");
        JLabel emptyLabel = new JLabel();

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

        brandLabel.setPreferredSize(new Dimension(125, 25));
        modelLabel.setPreferredSize(new Dimension(125, 25));
        colorLabel.setPreferredSize(new Dimension(100, 25));
        sizeLabel.setPreferredSize(new Dimension(75, 25));
        priceLabel.setPreferredSize(new Dimension(100, 25));
        emptyLabel.setPreferredSize(new Dimension(100, 25));

        brandBox.setPreferredSize(new Dimension(150, 25));
        modelBox.setPreferredSize(new Dimension(175, 25));
        colorBox.setPreferredSize(new Dimension(100, 25));
        sizeBox.setPreferredSize(new Dimension(50, 25));
        categoryBox.setPreferredSize(new Dimension(90, 25));


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
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setBackground(style.getBackgroundColor_LIGHT());
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        southPanel.add(brandLabel);
        southPanel.add(modelLabel);
        southPanel.add(colorLabel);
        southPanel.add(sizeLabel);
        southPanel.add(priceLabel);
        southPanel.add(emptyLabel);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.CENTER);
    }

    public void populateComboBoxes(Reporter reporter, JComboBox<String> brandBox, JComboBox<String> modelBox, JComboBox<String> colorBox, JComboBox<String> sizeBox, JComboBox<String> categoryBox) {
        ComboBoxFiller<Brand> brandsFill = Brand::getName;
        ComboBoxFiller<Size> sizeFill = a -> String.valueOf(a.getEu());
        ComboBoxFiller<Color> colorFill = Color::getName;
        ComboBoxFiller<Shoe> modelFill = Shoe::getModel;
        ComboBoxFiller<Category> categoryFill = Category::getName;

        reporter.populateComboBox(reporter.getRepo().getBrands(), brandBox, brandsFill);
        reporter.populateComboBox(reporter.getRepo().getSizes(), sizeBox, sizeFill);
        reporter.populateComboBox(reporter.getRepo().getColors(), colorBox, colorFill);
        reporter.populateComboBox(reporter.getRepo().getShoes(), modelBox, modelFill);
        reporter.populateComboBox(reporter.getRepo().getCategories(), categoryBox, categoryFill);
    }
}
