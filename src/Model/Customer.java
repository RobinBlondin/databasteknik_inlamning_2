package Model;

public class Customer {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String email;
    private final String phone_number;
    private final String password;

    public Customer(int id, String firstName, String lastName, String address, String city, String email, String phone_number, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    public String printCustomer() {
        return String.format("%d, %s %s, %s, %s\n", id, firstName, lastName, address, city);
    }
}