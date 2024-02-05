package Model;

public class Stock {
    private int id;
    private Shoe shoe;
    private int quantity;

    public Stock() {
    }

    public Stock(int id, Shoe shoe, int quantity) {
        this.id = id;
        this.shoe = shoe;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
