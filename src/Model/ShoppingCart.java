package Model;

public class ShoppingCart {
    private final Shoe shoe;
    private final OrderEntry orderEntry;
    private final int quantity;

    public ShoppingCart(Shoe shoe, OrderEntry orderEntry, int quantity) {
        this.shoe = shoe;
        this.orderEntry = orderEntry;
        this.quantity = quantity;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public OrderEntry getOrderEntry() {
        return orderEntry;
    }

    public int getQuantity() {
        return quantity;
    }
}
