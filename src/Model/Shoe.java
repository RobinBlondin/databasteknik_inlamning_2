package Model;

public class Shoe {
    private int id;
    private String model;
    private int price;
    private Brand brand;
    private Color color;
    private Size size;

    public Shoe() {
    }

    public Shoe(int id, String model, int price, Brand brand, Color color, Size size) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.brand = brand;
        this.color = color;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String printShoe() {
        return String.format("%d, %s, %s, %s, %d, %d\n", id, brand.getName(), model, color.getName(), size.getEu(), price);
    }
}
