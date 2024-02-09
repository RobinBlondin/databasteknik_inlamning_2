package View;

import Model.Brand;
import Model.Color;
import Model.Size;

import javax.swing.*;
import java.util.List;

public class ComboBoxPanel extends JPanel {
    private final JComboBox<String> brands;
    private final JComboBox<String> sizes;
    private final JComboBox<String> color;
    public ComboBoxPanel(MainFrame mainFrame) {
        StyleSettings style = StyleSettings.getInstance();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(style.getBackgroundColor_DARK());
        this.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        brands = new JComboBox<>();
        sizes = new JComboBox<>();
        color = new JComboBox<>();

        brands.setBackground(style.getButtonColor());
        sizes.setBackground(style.getButtonColor());
        color.setBackground(style.getButtonColor());

        List<String> brandNames = mainFrame.getRepo().getBrands().stream().map(Brand::getName).toList();
        brands.addItem("");
        brandNames.forEach(brands::addItem);

        List<String> sizeNames = mainFrame.getRepo().getSizes().stream().map(Size::getEu).map(String::valueOf).toList();
        sizes.addItem("");
        sizeNames.forEach(sizes::addItem);

        List<String> colorNames = mainFrame.getRepo().getColors().stream().map(Color::getName).toList();
        color.addItem("");
        colorNames.forEach(color::addItem);

        this.add(brands);
        this.add(Box.createVerticalStrut(5));
        this.add(color);
        this.add(Box.createVerticalStrut(5));
        this.add(sizes);
        this.setVisible(true);
    }

    public JComboBox<String> getBrands() {
        return brands;
    }

    public JComboBox<String> getSizes() {
        return sizes;
    }

    public JComboBox<String> getColor() {
        return color;
    }
}
