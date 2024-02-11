package View;

import Controller.Repository;
import Model.MainFrameCallback;
import Model.Shoe;
import Model.ShoppingCart;
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
            repo.loadShoes();
            repo.loadStockAmount();
            repo.loadOrders();

            if (repo.getCurrentUserOrder().isEmpty()) {
                repo.addToCart(repo.getLoggedInUserId(), 0, shoeId);
            } else {
                repo.addToCart(repo.getLoggedInUserId(), repo.getLoggedInUsersLastOrder().getId(), shoeId);
            }
            Shoe orderedShoe = repo.getShoes().stream().filter(shoe -> shoe.getId() == shoeId).toList().getFirst();
            Map<Shoe, Integer> orders = repo.getCurrentUserOrder();
            if (orders.containsKey(orderedShoe)) {
                orders.put(orderedShoe, orders.get(orderedShoe) + 1);
            } else {
                orders.put(orderedShoe, 1);
            }
            int qty = repo.getStockEntries().stream().filter(stock -> stock.getShoe().getId() == shoeId).map(Stock::getQuantity).mapToInt(b -> b).sum();
            callback.onButtonClicked(11, "");
            //System.out.println("Amount in stock: " + repo.getStockEntries().stream().filter(stockEntry -> stockEntry.getShoe().getId() == shoeId).toList().getFirst().getQuantity());

           /* ShoppingCart order = repo.getShoppingCart().stream()
                    .filter(cart -> cart.getShoe().getId() == shoeId)
                    .filter(cart -> cart.getOrderEntry().getId() == repo.getLoggedInUsersLastOrder().getId())
                    .filter(cart -> cart.getOrderEntry().getCustomer().getId() == repo.getLoggedInUserId()).toList().getFirst();*/
           /* System.out.println("Amount in stock: " + repo.getStockEntries().stream().filter(stockEntry -> stockEntry.getShoe().id() == shoeId).toList().getFirst().getQuantity());
            System.out.println("Shoe: " + order.getShoe().printShoe() +
                    "\nCustomer: " + order.getOrderEntry().getCustomer().printCustomer() + "\nQuantity in order: " + order.getQuantity());
            System.out.println("Amount of orders in list: " + repo.getOrders().size());*/

        });
        this.setVisible(true);
    }
}
