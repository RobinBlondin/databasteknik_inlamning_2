package View;

import Controller.Reporter;
import Model.*;
import Model.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class FilterPanel extends JPanel {
    private final JComboBox<String> brandBox;
    private final JComboBox<String> modelBox;
    private final JComboBox<String> colorBox;
    private final JComboBox<String> sizeBox;
    private final JComboBox<String> categoryBox;
    private final Reporter reporter;

    public FilterPanel(Reporter reporter, ListPanel listPanel, MainFrameCallback callback) {
        StyleSettings style = StyleSettings.getInstance();

        brandBox = new JComboBox<>();
        colorBox = new JComboBox<>();
        sizeBox = new JComboBox<>();
        modelBox = new JComboBox<>();
        categoryBox = new JComboBox<>();
        this.reporter = reporter;

        brandBox.setBackground(style.getButtonColor());
        colorBox.setBackground(style.getButtonColor());
        sizeBox.setBackground(style.getButtonColor());
        modelBox.setBackground(style.getButtonColor());
        categoryBox.setBackground(style.getButtonColor());

       populateComboBoxes(reporter, brandBox, modelBox, colorBox, sizeBox, categoryBox);

        ActionListener comboListener = e -> {
            callback.onButtonClicked(11, "");
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
        JLabel amountLabel = new JLabel("Qty");
        JLabel emptyLabel = new JLabel("");

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(600, 75));
        brandLabel.setFont(style.getMicroFontBold());
        modelLabel.setFont(style.getMicroFontBold());
        colorLabel.setFont(style.getMicroFontBold());
        sizeLabel.setFont(style.getMicroFontBold());
        priceLabel.setFont(style.getMicroFontBold());
        amountLabel.setFont(style.getMicroFontBold());

        brandLabel.setBackground(style.getBackgroundColor_LIGHT());
        modelLabel.setBackground(style.getBackgroundColor_LIGHT());
        colorLabel.setBackground(style.getBackgroundColor_LIGHT());
        sizeLabel.setBackground(style.getBackgroundColor_LIGHT());
        priceLabel.setBackground(style.getBackgroundColor_LIGHT());
        amountLabel.setBackground(style.getBackgroundColor_LIGHT());
        emptyLabel.setBackground(style.getBackgroundColor_LIGHT());

        brandLabel.setForeground(style.getTextColor_SELECTED());
        modelLabel.setForeground(style.getTextColor_SELECTED());
        colorLabel.setForeground(style.getTextColor_SELECTED());
        sizeLabel.setForeground(style.getTextColor_SELECTED());
        amountLabel.setForeground(style.getTextColor_SELECTED());
        priceLabel.setForeground(style.getTextColor_SELECTED());

        brandLabel.setPreferredSize(new Dimension(140, 25));
        modelLabel.setPreferredSize(new Dimension(140, 25));
        colorLabel.setPreferredSize(new Dimension(100, 25));
        sizeLabel.setPreferredSize(new Dimension(50, 25));
        priceLabel.setPreferredSize(new Dimension(75, 25));
        amountLabel.setPreferredSize(new Dimension(30, 25));

        brandLabel.setMaximumSize(new Dimension(140, 25));
        modelLabel.setMaximumSize(new Dimension(140, 25));
        colorLabel.setMaximumSize(new Dimension(100, 25));
        sizeLabel.setMaximumSize(new Dimension(50, 25));
        priceLabel.setMaximumSize(new Dimension(75, 25));
        amountLabel.setMaximumSize(new Dimension(30, 25));

        brandLabel.setMinimumSize(new Dimension(140, 25));
        modelLabel.setMinimumSize(new Dimension(140, 25));
        colorLabel.setMinimumSize(new Dimension(100, 25));
        sizeLabel.setMinimumSize(new Dimension(50, 25));
        priceLabel.setMinimumSize(new Dimension(75, 25));
        amountLabel.setMinimumSize(new Dimension(30, 25));

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
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.setBackground(style.getBackgroundColor_LIGHT());
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        southPanel.add(brandLabel);
        southPanel.add(modelLabel);
        southPanel.add(colorLabel);
        southPanel.add(sizeLabel);
        southPanel.add(priceLabel);
        southPanel.add(amountLabel);

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

    public List<String> getSelectedItems() {
        return reporter.filterShoes(
                (String)brandBox.getSelectedItem(),
                (String)modelBox.getSelectedItem(),
                (String)colorBox.getSelectedItem(),
                (String)sizeBox.getSelectedItem(),
                (String)categoryBox.getSelectedItem());
    }
}
