package Model;

@FunctionalInterface
public interface FilterInterface {
    boolean check(String input, String type, Shoe shoe, Category cat);
}
