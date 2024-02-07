package Model;

@FunctionalInterface
public interface Matcher<T> {
    boolean matches(T input, int comparison);
}
