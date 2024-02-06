package Controller;

import Model.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reporter {
    Repository rp;

    public Reporter() {
        rp = new Repository();
    }

    public List<String> filterShoes(String brand, String color, String size, String category) {
        List<String> list = new ArrayList<>();

        rp.getCategoryMaps().stream()
                .filter(a -> brand.isEmpty() || a.getShoe().getBrand().getName().contains(brand))
                .filter(a -> color.isEmpty() || a.getShoe().getColor().getName().contains(color))
                .filter(a -> size.isEmpty() || a.getShoe().getSize().getEu() == Integer.parseInt(size))
                .filter(a -> category.isEmpty() || a.getCategory().getName().contains(category))
                .map(CategoryMap::getShoe)
                .collect(Collectors.toMap(Shoe::getId, a -> a, (existingShoe, newShoe) -> existingShoe))
                .values()
                .forEach(a -> list.add(a.printShoe()));

        return list;
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

    public void ordersPerCustomer() {
       rp.getOrders()
               .stream()
               .collect(Collectors.groupingBy(OrderEntry::getCustomer))
               .forEach((k, v) -> System.out.println(k.getFirst_name() + " " + k.getLast_name() + " : " + v.size()));
    }

    public void moneySpentByCustomer() {
        rp.getShoppingCart().stream()
                .collect(Collectors.groupingBy(a -> a.getOrderEntry().getCustomer()))
                .forEach((k, v) -> System.out.println(k.getFirst_name() + " " + v.stream()
                                        .map(a -> a.getShoe().getPrice() * a.getQuantity())
                                        .mapToInt(a -> a)
                                        .sum()));
    }

    public void moneySpentPerCity() {
        rp.getShoppingCart().stream()
                .collect(Collectors.groupingBy(a -> a.getOrderEntry().getCustomer().getCity()))
                .forEach((k, v) -> System.out.println(k + " " + v.stream()
                        .map(a -> a.getShoe().getPrice() * a.getQuantity())
                        .mapToInt(a -> a)
                        .sum()));
    }

    public void mostSoldProducts() {
        Map<String, Integer> map = new TreeMap<>();
        rp.getShoppingCart().stream().collect(Collectors.groupingBy(a -> a.getShoe().getBrand().getName() + "," + a.getShoe().getModel()))
                .forEach((k, v) -> map.put(k, v.stream().map(ShoppingCart::getQuantity).mapToInt(a -> a).sorted().sum()));

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }



    public Repository getRp() {
        return rp;
    }
}
