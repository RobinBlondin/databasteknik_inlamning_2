package View;

import Controller.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ListLabel extends JPanel {
    private StyleSettings style = StyleSettings.getInstance();
    private final JLabel brandLabel;
    private final JLabel modelLabel;
    private final JComboBox<String> dropButton;

    public ListLabel(int id, String brand, String model, String color, String size, String price, Repository repo, boolean needCart) {
        this.setLayout(new BorderLayout());
        this.setBackground(style.getBackgroundColor_LIGHT());
        this.setPreferredSize(new Dimension(600, 50));
        this.setMaximumSize(new Dimension(600, 50));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));

        JButton cartButton = new JButton();
        cartButton.setFocusPainted(false);
        cartButton.setBackground(style.getBackgroundColor_LIGHT());
        ImageIcon cartIcon = new ImageIcon("images/cartIcon.png");
        cartButton.setIcon(cartIcon);
        cartButton.setPreferredSize(new Dimension(35, 35));
        cartButton.setBorder(BorderFactory.createEmptyBorder());
        cartButton.addActionListener(a -> {
            repo.addToCart(1, 1, id);
            System.out.println(id);
        });
        cartButton.setVisible(true);

        String [] options = {"NEW: Add to cart", "EXISTING: Add to cart"};
        brandLabel = new JLabel(brand);
        modelLabel = new JLabel(model);
        JLabel colorLabel = new JLabel(color);
        JLabel sizeLabel = new JLabel(size);
        JLabel priceLabel = new JLabel(price + ":-");

        JLabel emptyLabel = new JLabel();
        dropButton = new JComboBox<>(options);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(style.getBackgroundColor_LIGHT());
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        brandLabel.setFont(style.getMicroFont());
        modelLabel.setFont(style.getMicroFont());
        colorLabel.setFont(style.getMicroFont());
        sizeLabel.setFont(style.getMicroFont());
        priceLabel.setFont(style.getMicroFont());

        brandLabel.setPreferredSize(new Dimension(150, 50));
        modelLabel.setPreferredSize(new Dimension(150, 50));
        colorLabel.setPreferredSize(new Dimension(100, 50));
        sizeLabel.setPreferredSize(new Dimension(50, 50));
        priceLabel.setPreferredSize(new Dimension(75, 50));
        dropButton.setPreferredSize(new Dimension(75, 50));

        brandLabel.setBackground(style.getBackgroundColor_LIGHT());
        modelLabel.setBackground(style.getBackgroundColor_LIGHT());
        colorLabel.setBackground(style.getBackgroundColor_LIGHT());
        sizeLabel.setBackground(style.getBackgroundColor_LIGHT());
        priceLabel.setBackground(style.getBackgroundColor_LIGHT());

        brandLabel.setForeground(style.getTextColor_LIGHT());
        modelLabel.setForeground(style.getTextColor_LIGHT());
        colorLabel.setForeground(style.getTextColor_LIGHT());
        sizeLabel.setForeground(style.getTextColor_LIGHT());
        priceLabel.setForeground(style.getTextColor_LIGHT());

        brandLabel.setBorder(BorderFactory.createEmptyBorder());
        modelLabel.setBorder(BorderFactory.createEmptyBorder());
        colorLabel.setBorder(BorderFactory.createEmptyBorder());
        sizeLabel.setBorder(BorderFactory.createEmptyBorder());
        priceLabel.setBorder(BorderFactory.createEmptyBorder());

        dropButton.setFocusable(true);
        dropButton.setEditable(false);
        dropButton.setBackground(style.getTextColor_WHITE());
        dropButton.setBorder(BorderFactory.createEmptyBorder());
        dropButton.addActionListener(e -> {
            if(Objects.equals(dropButton.getSelectedItem(), "NEW: Add to cart")) {
                //TODO
            } else if (Objects.equals(dropButton.getSelectedItem(), "EXISTING: Add to cart")) {
                //TODO
            }
        });
        dropButton.setVisible(true);

        centerPanel.add(brandLabel);
        centerPanel.add(modelLabel);
        centerPanel.add(colorLabel);
        centerPanel.add(sizeLabel);
        centerPanel.add(priceLabel);
        if (needCart) {
            centerPanel.add(cartButton);
        } else {
            centerPanel.add(emptyLabel);
        }

        add(emptyLabel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(emptyLabel, BorderLayout.EAST);
        this.setVisible(true);
    }

    public String getBrandText() {
        return brandLabel.getText();
    }
    public String getModelText() {
        return modelLabel.getText();
    }

    public String getColorText() {
        return modelLabel.getText();
    }
    public String getSizeText() {
        return modelLabel.getText();
    }
    public String getPriceText() {
        return modelLabel.getText();
    }
}
