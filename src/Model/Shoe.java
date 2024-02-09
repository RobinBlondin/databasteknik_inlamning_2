package Model;

public class Shoe {
    private final int id;
    private final String model;
    private final int price;
    private final Brand brand;
    private final Color color;
    private final Size size;

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

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public String printShoe() {
        return String.format("%d, %s, %s, %s, %d, %d\n", id, brand.getName(), model, color.getName(), size.getEu(), price);
    }
}
