package View;

import Controller.Repository;
import Model.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListLabel extends JPanel {
    private StyleSettings style = StyleSettings.getInstance();
    private final JLabel brandLabel;
    private final JLabel modelLabel;

    public ListLabel(int id, Repository repo, boolean withCartButton, String... strings) {
        this.setLayout(new BorderLayout());
        this.setBackground(style.getBackgroundColor_LIGHT());
        this.setPreferredSize(new Dimension(595, 50));
        this.setMaximumSize(new Dimension(595, 50));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, style.getButtonColor()));

        String brand = strings.length > 0 ? strings[0] : "";
        String model = strings.length > 1 ? strings[1] : "";
        String color = strings.length > 2 ? strings[2] : "";
        String size = strings.length > 3 ? strings[3] : "";
        String price = strings.length > 4 ? strings[4] : "";

        JButton cartButton = new JButton();
        cartButton.setFocusPainted(false);
        cartButton.setBackground(style.getBackgroundColor_LIGHT());
        ImageIcon cartIcon = new ImageIcon("images/cartIcon.png");
        cartButton.setIcon(cartIcon);
        cartButton.setPreferredSize(new Dimension(35, 35));
        cartButton.setBorder(BorderFactory.createEmptyBorder());
        cartButton.addActionListener(a -> {
            repo.addToCart(repo.getLoggedInUserId(), repo.getLoggedInUsersLastOrder().getId(), id);

            ShoppingCart order = repo.getShoppingCart().stream()
                    .filter(cart -> cart.getShoe().getId() == id)
                    .filter(cart -> cart.getOrderEntry().getId() == repo.getLoggedInUsersLastOrder().getId())
                    .filter(cart -> cart.getOrderEntry().getCustomer().getId() == repo.getLoggedInUserId()).toList().getFirst();
            System.out.println("Amount in stock: " + repo.getStockEntries().stream().filter(stockEntry -> stockEntry.getShoe().getId() == id).toList().getFirst().getQuantity());
            System.out.println("Shoe: " + order.getShoe().printShoe() +
                    "\nCustomer: " + order.getOrderEntry().getCustomer().printCustomer() + "\nQuantity in order: " + order.getQuantity());
            System.out.println("Amount of orders in list: " + repo.getOrders().size());
        });
        cartButton.setVisible(true);

        JLabel emptyLabel = new JLabel();

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(style.getBackgroundColor_LIGHT());
        centerPanel.setPreferredSize(new Dimension(600, 50));
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));


        brandLabel = new JLabel(brand);
        modelLabel = new JLabel(model);
        JLabel colorLabel = new JLabel(color);
        JLabel sizeLabel = new JLabel(size);
        JLabel priceLabel = new JLabel(price);

        brandLabel.setFont(style.getMicroFont());
        modelLabel.setFont(style.getMicroFont());
        colorLabel.setFont(style.getMicroFont());
        sizeLabel.setFont(style.getMicroFont());
        priceLabel.setFont(style.getMicroFont());

        brandLabel.setPreferredSize(new Dimension(150, 50));
        modelLabel.setPreferredSize(new Dimension(175, 50));
        colorLabel.setPreferredSize(new Dimension(100, 50));
        sizeLabel.setPreferredSize(new Dimension(50, 50));
        priceLabel.setPreferredSize(new Dimension(50, 50));

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

        List<JLabel> labels = List.of(brandLabel, modelLabel, colorLabel, sizeLabel, priceLabel);

        for (int i = 0; i < strings.length; i++) {
           centerPanel.add(labels.get(i));
        }

        if (withCartButton) {
            centerPanel.add(cartButton);
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
    private JPanel createFittedSizeLabelPanel(JLabel label) {
        JPanel panel = new JPanel();
        panel.setBackground(style.getBackgroundColor_LIGHT());
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(label);
        return panel;
    }

}
