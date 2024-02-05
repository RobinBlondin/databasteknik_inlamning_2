package Model;

public class CategoryMap {
    private Shoe shoe;
    private Category category;

    public CategoryMap(Shoe shoe, Category category) {
        this.shoe = shoe;
        this.category = category;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
