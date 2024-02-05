package Model;

public class ShoppingCart {
    private Shoe shoe;
    private OrderEntry orderEntry;
    private int quantity;

    public ShoppingCart() {}
    public ShoppingCart(Shoe shoe, OrderEntry orderEntry, int quantity) {
        this.shoe = shoe;
        this.orderEntry = orderEntry;
        this.quantity = quantity;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public OrderEntry getOrderEntry() {
        return orderEntry;
    }

    public void setOrderEntry(OrderEntry orderEntry) {
        this.orderEntry = orderEntry;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
