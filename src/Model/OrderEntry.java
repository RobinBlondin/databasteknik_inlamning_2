package Model;

import java.time.LocalDate;

public class OrderEntry {
    private final int id;
    private final LocalDate orderDate;
    private final Customer customer;

    public OrderEntry(int id, String orderDate, Customer customer) {
        this.id = id;
        this.orderDate = LocalDate.parse(orderDate);
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }
}

