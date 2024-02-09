package Model;

public class CategoryMap {
    private final Shoe shoe;
    private final Category category;

    public CategoryMap(Shoe shoe, Category category) {
        this.shoe = shoe;
        this.category = category;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public Category getCategory() {
        return category;
    }

}
