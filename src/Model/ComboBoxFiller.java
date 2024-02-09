package Model;

@FunctionalInterface
public interface ComboBoxFiller<T> {
    String fill(T item);
}
