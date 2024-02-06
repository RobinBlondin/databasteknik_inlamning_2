package Controller;

import Model.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reporter {
    Repository rp;

    public Reporter() {
        rp = new Repository();
    }

    public void customerPurchases(String sizeStr, String color, String brand) {
        int size = Integer.parseInt(sizeStr);

        rp.getShoppingCart().stream().filter(a ->
                a.getShoe().getSize().getEu() == size &&
                a.getShoe().getColor().getName().equals(color) &&
                a.getShoe().getBrand().getName().equals(brand))
                .toList().stream()
                .map(a -> a.getOrderEntry().getCustomer())
                .toList()
                .forEach(Customer::printCustomer);

    }



    public Repository getRp() {
        return rp;
    }
}
