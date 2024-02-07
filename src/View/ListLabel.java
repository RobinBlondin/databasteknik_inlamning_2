package View;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ListLabel extends JPanel {
    private StyleSettings style = StyleSettings.getInstance();
    private final JLabel brandLabel;
    private final JLabel modelLabel;
    private final JLabel colorLabel;
    private final JLabel sizeLabel;
    private final JLabel priceLabel;
    private final JComboBox dropButton;

    public ListLabel(String brand, String model, String color, String size, String price, boolean needDropMenu) {
        this.setLayout(new BorderLayout());
        this.setBackground(style.getBackgroundColor_LIGHT());
        this.setPreferredSize(new Dimension(800, 50));
        this.setMaximumSize(new Dimension(800, 50));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));

        String [] options = {"NEW: Add to cart", "EXISTING: Add to cart"};
        brandLabel = new JLabel(brand);
        modelLabel = new JLabel(model);
        colorLabel = new JLabel(color);
        sizeLabel = new JLabel(size);
        priceLabel = new JLabel(price + ":-");
        JPanel centerPanel = new JPanel();
        JLabel emptyLabel = new JLabel();
        dropButton = new JComboBox(options);

        centerPanel.setBackground(Color.WHITE);

        brandLabel.setFont(style.getSmallFont());
        modelLabel.setFont(style.getSmallFont());
        colorLabel.setFont(style.getSmallFont());
        sizeLabel.setFont(style.getSmallFont());
        priceLabel.setFont(style.getSmallFont());

        brandLabel.setPreferredSize(new Dimension(150, 50));
        modelLabel.setPreferredSize(new Dimension(175, 50));
        colorLabel.setPreferredSize(new Dimension(100, 50));
        sizeLabel.setPreferredSize(new Dimension(50, 50));
        priceLabel.setPreferredSize(new Dimension(100, 50));
        dropButton.setPreferredSize(new Dimension(175, 50));

        brandLabel.setBackground(style.getBackgroundColor_LIGHT());
        modelLabel.setBackground(style.getBackgroundColor_LIGHT());
        colorLabel.setBackground(style.getBackgroundColor_LIGHT());
        sizeLabel.setBackground(style.getBackgroundColor_LIGHT());
        priceLabel.setBackground(style.getBackgroundColor_LIGHT());

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
        if (needDropMenu) {
            centerPanel.add(dropButton);
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
