package Controller;

import Model.*;

import java.util.*;
import java.util.stream.Collectors;

public class Reporter {
    Repository rp;

    public Reporter() {
        rp = new Repository();
    }

    public List<String> filterShoes(String brand, String model, String color, String size, String category) {
        List<String> list = new ArrayList<>();

        rp.getCategoryMaps().stream()
                .filter(a -> brand.isEmpty() || a.getShoe().getBrand().getName().contains(brand))
                .filter(a -> model.isEmpty() || a.getShoe().getModel().contains(model))
                .filter(a -> color.isEmpty() || a.getShoe().getColor().getName().contains(color))
                .filter(a -> size.isEmpty() || a.getShoe().getSize().getEu() == Integer.parseInt(size))
                .filter(a -> category.isEmpty() || a.getCategory().getName().contains(category))
                .map(CategoryMap::getShoe)
                .collect(Collectors.toMap(Shoe::getId, a -> a, (existingShoe, newShoe) -> existingShoe))
                .values()
                .forEach(a -> list.add(a.printShoe()));

        return list;
    }

    public List<String> customerPurchases(String sizeStr, String color, String brand) {
        int size = sizeStr.isEmpty()? 0: Integer.parseInt(sizeStr);
        List<String> list = new ArrayList<>();

        rp.getShoppingCart().stream()
                .filter(a -> sizeStr.isEmpty()|| a.getShoe().getSize().getEu() == size)
                .filter(a -> color.isEmpty() || a.getShoe().getColor().getName().equals(color))
                .filter(a -> brand.isEmpty() || a.getShoe().getBrand().getName().equals(brand))
                .map(a -> a.getOrderEntry().getCustomer())
                .toList()
                .forEach(a -> list.add(a.printCustomer()));
        return list;
    }

    public List<String> ordersPerCustomer() {
        List<String> list = new ArrayList<>();
        rp.getOrders()
               .stream()
               .collect(Collectors.groupingBy(OrderEntry::getCustomer))
               .forEach((k, v) -> list.add(k.getFirst_name() + " " + k.getLast_name() + ", " + v.size()));
       return list;
    }

    public List<String> moneySpentByCustomer() {
        List<String> list = new ArrayList<>();
        rp.getShoppingCart().stream()
                .collect(Collectors.groupingBy(a -> a.getOrderEntry().getCustomer()))
                .forEach((k, v) -> list.add(k.getFirst_name() + " " + k.getLast_name() + ", " + v.stream()
                                        .map(a -> a.getShoe().getPrice() * a.getQuantity())
                                        .mapToInt(a -> a)
                                        .sum()));
        return list;
    }

    public List<String> moneySpentPerCity() {
        List<String> list = new ArrayList<>();
        rp.getShoppingCart().stream()
                .collect(Collectors.groupingBy(a -> a.getOrderEntry().getCustomer().getCity()))
                .forEach((k, v) -> list.add(k + ", " + v.stream()
                        .map(a -> a.getShoe().getPrice() * a.getQuantity())
                        .mapToInt(a -> a)
                        .sum()));
        return list;
    }

    public List<String> mostSoldProducts() {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>();
        rp.getShoppingCart().stream()
                .collect(Collectors.groupingBy(a -> a.getShoe().getBrand().getName() + ", " + a.getShoe().getModel()))
                .forEach((k, v) -> map.put(k, v.stream().map(ShoppingCart::getQuantity).mapToInt(a -> a).sorted().sum()));

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(a -> list.add(a.toString()));

        return list.stream().map(a->a.replace("=", ", ")).toList();

    }



    public Repository getRp() {
        return rp;
    }
}
