package View;

import Controller.Repository;
import Model.MainFrameCallback;
import Model.Shoe;
import Model.Stock;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class CartButton extends JButton {
    public CartButton(int shoeId, Repository repo, MainFrameCallback callback) {
        StyleSettings style = StyleSettings.getInstance();
        this.setFocusPainted(false);
        this.setBackground(style.getBackgroundColor_LIGHT());
        ImageIcon cartIcon = new ImageIcon("images/cartIcon.png");
        this.setIcon(cartIcon);
        this.setPreferredSize(new Dimension(35, 35));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 5));
        this.addActionListener(a -> {
            repo.loadStockEntries();
            int qty = repo.getStockEntries().stream().filter(b -> b.getShoe().getId() == shoeId).map(Stock::getQuantity).reduce(Integer::sum).get();
            String inStock = qty > 0? "in": "";

            if (repo.getCurrentUserOrder().isEmpty()) {
                repo.addToCart(repo.getLoggedInUserId(), 0, shoeId);
                repo.loadOrders();
                repo.setLoggedInUsersLastOrder();
            } else {
                repo.addToCart(repo.getLoggedInUserId(), repo.getLoggedInUsersLastOrder().getId(), shoeId);
            }

            Shoe orderedShoe = repo.getShoes().stream().filter(shoe -> shoe.getId() == shoeId).toList().getFirst();
            if(qty > 0) {
                Map<Shoe, Integer> orders = repo.getCurrentUserOrder();
                if (orders.containsKey(orderedShoe)) {
                    orders.put(orderedShoe, orders.get(orderedShoe) + 1);
                } else {
                    orders.put(orderedShoe, 1);
                }
            }

            callback.onButtonClicked(11, inStock);
        });
        this.setVisible(true);
    }
}
