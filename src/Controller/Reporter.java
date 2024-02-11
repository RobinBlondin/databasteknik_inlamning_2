package Controller;

import Model.*;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Reporter implements FilterInterface {

    private final Repository repo;

    public Reporter(Repository repo) {
        this.repo = repo;
    }

    public List<String> filterShoes(String brand, String model, String color, String size, String category) {

        List<String> list = new ArrayList<>();

        repo.getCategoryMaps().stream()
                .filter(a -> check(brand, "brand", a.getShoe(), null) &&
                             check(model, "model", a.getShoe(), null) &&
                             check(color, "color", a.getShoe(), null) &&
                             check(size, "size", a.getShoe(), null) &&
                             check(category, "category", null, a.getCategory()))
                .map(CategoryMap::getShoe)
                .collect(Collectors.toSet())
                .forEach(a -> list.add(a.printShoe()));
        return list;
    }

    public List<String> customerPurchases(String size, String color, String brand) {
        List<String> list = new ArrayList<>();

        repo.getShoppingCart().stream()
                .filter(a -> check(size, "size", a.getShoe(), null) &&
                             check(color, "color", a.getShoe(), null) &&
                             check(brand, "brand", a.getShoe(), null))
                .map(a -> a.getOrderEntry().getCustomer())
                .toList()
                .forEach(a -> list.add(a.printCustomer()));
        return list;
    }

    public List<String> ordersPerCustomer() {
        List<String> list = new ArrayList<>();
        repo.getOrders()
                .stream()
                .collect(Collectors.groupingBy(OrderEntry::getCustomer))
                .forEach((k, v) -> list.add(k.getFirst_name() + " " + k.getLast_name() + ", " + v.size()));
        return list;
    }

    public List<String> moneySpentByCustomer() {
        List<String> list = new ArrayList<>();
        repo.getShoppingCart().stream()
                .collect(Collectors.groupingBy(a -> a.getOrderEntry().getCustomer()))
                .forEach((k, v) -> list.add(k.getFirst_name() + " " + k.getLast_name() + ", " + v.stream()
                        .map(a -> a.getShoe().getPrice() * a.getQuantity())
                        .mapToInt(a -> a)
                        .sum()));
        return list;
    }

    public List<String> moneySpentPerCity() {
        List<String> list = new ArrayList<>();
        repo.getShoppingCart().stream()
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
        repo.getShoppingCart().stream()
                .collect(Collectors.groupingBy(a -> a.getShoe().getBrand().getName() + ", " + a.getShoe().getModel()))
                .forEach((k, v) -> map.put(k, v.stream().map(ShoppingCart::getQuantity).mapToInt(a -> a).sorted().sum()));

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(a -> list.add(a.toString()));

        return list.stream().map(a -> a.replace("=", ", ")).toList();
    }

    public <T> void populateComboBox(List<T> list, JComboBox<String> box, ComboBoxFiller<T> filler) {
        List<String> strList = new ArrayList<>(list.stream()
                .map(filler::fill)
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList());

        box.addItem("");
        strList.forEach(box::addItem);
    }

    public Repository getRepo() {
        return repo;
    }

    @Override
    public boolean check(String input, String type, Shoe shoe, Category category) {
        switch (type) {
            case "brand" -> {
                return input.isEmpty() || shoe.getBrand().getName().equals(input);
            }
            case "model" -> {
                return input.isEmpty() || shoe.getModel().equals(input);
            }
            case "color" -> {
                return input.isEmpty() || shoe.getColor().getName().equals(input);
            }
            case "size" -> {
                return input.isEmpty() || shoe.getSize().getEu() == Integer.parseInt(input);
            }
            case "category" -> {
                return input.isEmpty() || category.getName().equals(input);
            }
            default -> {
                return false;
            }
        }
    }
}

