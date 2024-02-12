package Model;

public final class Stock {
    private final int id;
    private final Shoe shoe;
    private final int quantity;

    public Stock(int id, Shoe shoe, int quantity) {
        this.id = id;
        this.shoe = shoe;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public int getQuantity() {
        return quantity;
    }
}
