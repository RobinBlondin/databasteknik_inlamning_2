package View;

import Controller.Repository;

public class Main {
    public static void main(String[] args) {
        Repository dh = new Repository();

        System.out.println(dh.getOrders().size());
        dh.addToCart(1, 16, 3);
        System.out.println(dh.getOrders().size());
    }
}
