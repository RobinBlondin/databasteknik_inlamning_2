package Model;

import java.time.LocalDate;

public class OrderEntry {
    private int id;
    private LocalDate orderDate;
    private Customer customer;

    public OrderEntry() {
    }

    public OrderEntry(int id, String orderDate, Customer customer) {
        this.id = id;
        this.orderDate = LocalDate.parse(orderDate);
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer_id() {
        return customer;
    }

    public void setCustomer_id(Customer customer) {
        this.customer = customer;
    }
}

