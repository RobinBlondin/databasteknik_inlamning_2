package Controller;

import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final DBHelper dh;
    private int loggedInUserId;
    private OrderEntry loggedInUsersLastOrder;
    private final List<Brand> brands;
    private final List<Color> colors;
    private final List<Size> sizes;
    private final List<Category> categories;
    private final List<Shoe> shoes;
    private final List<Customer> customers;
    private List<OrderEntry> orders;
    private List<Stock> stockEntries;
    private List<ShoppingCart> shoppingCart;
    private final List<CategoryMap> categoryMaps;

    public Repository() {
        dh = new DBHelper();
        loggedInUserId = 0;
        loggedInUsersLastOrder = null;
        brands = loadBrands();
        colors = loadColors();
        sizes = loadSizes();
        categories = loadCategories();
        customers = loadCustomers();
        shoes = loadShoes();
        orders = loadOrders();
        stockEntries = loadStockEntries();
        shoppingCart = loadShoppingCart();
        categoryMaps = loadCategoryMaps();
    }

    public List<Brand> loadBrands() {
        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM brand");
                ResultSet rs = pr.executeQuery()
        ) {
            List<Brand> list = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("brand_name");
                list.add(new Brand(id, name));
            }
            return list;

        } catch (SQLException e) {
            System.out.println("Problem loading brands");
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Category> loadCategories() {
        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM category");
                ResultSet rs = pr.executeQuery()
        ) {
            List<Category> list = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("category_name");
                list.add(new Category(id, name));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Problem loading categories");
            return null;
        }
    }

    public List<Color> loadColors() {
        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM color");
                ResultSet rs = pr.executeQuery()
        ) {
            List<Color> list = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("color_name");
                list.add(new Color(id, name));
            }
            return list;

        } catch (SQLException e) {
            System.out.println("Problem loading colors");
            return null;
        }
    }

    public List<Size> loadSizes() {
        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM size");
                ResultSet rs = pr.executeQuery()
        ) {
            List<Size> list = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("id");
                int eu = rs.getInt("eu");
                int us = rs.getInt("us");
                int uk = rs.getInt("uk");
                int cm = rs.getInt("cm");
                String inch = rs.getString("inch");

                list.add(new Size(id, eu, us, uk, cm, inch));
            }
            return list;

        } catch (SQLException e) {
            System.out.println("Problem loading sizes");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Customer> loadCustomers() {
        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM customer");
                ResultSet rs = pr.executeQuery()
        ) {
            List<Customer> list = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                String password = rs.getString("passwd");

                list.add(new Customer(id, firstName, lastName, address, city, email, phoneNumber, password));
            }
            return list;

        } catch (SQLException e) {
            System.out.println("Problem loading customers");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Shoe> loadShoes() {
        List<Shoe> list = new ArrayList<>();

        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM shoe");
                ResultSet rs = pr.executeQuery()
        ) {
            while(rs.next()) {
                int id = rs.getInt("id");
                String model = rs.getString("model");
                int price = rs.getInt("price");
                int brandId = rs.getInt("brand_id");
                int sizeId = rs.getInt("size_id");
                int colorId = rs.getInt("color_id");
                Brand brand = brands.stream().filter(a -> a.getId() == brandId).toList().getFirst();
                Color color = colors.stream().filter(a -> a.getId() == colorId).toList().getFirst();
                Size size = sizes.stream().filter(a -> a.getId() == sizeId).toList().getFirst();

                list.add(new Shoe(id, model, price, brand, color, size));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Problem loading shoes");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<OrderEntry> loadOrders() {
        List<OrderEntry> list = new ArrayList<>();

        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM order_entry");
                ResultSet rs = pr.executeQuery()
        ) {
            while(rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("order_date");
                int customerId = rs.getInt("customer_id");
                Customer customer = customers.stream().filter(a -> a.getId() == customerId).toList().getFirst();

                list.add(new OrderEntry(id, date, customer));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Problem loading orders");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Stock> loadStockEntries() {
        List<Stock> list = new ArrayList<>();

        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM stock");
                ResultSet rs = pr.executeQuery()
        ) {
            while(rs.next()) {
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                int shoeId = rs.getInt("shoe_id");
                Shoe shoe = shoes.stream().filter(a -> a.getId() == shoeId).toList().getFirst();

                list.add(new Stock(id, shoe, quantity));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Problem loading stock entries");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<ShoppingCart> loadShoppingCart() {
        List<ShoppingCart> list = new ArrayList<>();

        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM shopping_cart");
                ResultSet rs = pr.executeQuery()
        ) {
            while(rs.next()) {
                int shoeId = rs.getInt("shoe_id");
                int orderId = rs.getInt("order_entry_id");
                int quantity = rs.getInt("quantity");
                Shoe shoe = shoes.stream().filter(a -> a.getId() == shoeId).toList().getFirst();
                OrderEntry orderEntry = orders.stream().filter(a -> a.getId() == orderId).toList().getFirst();

                list.add(new ShoppingCart(shoe, orderEntry, quantity));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Problem loading shopping cart");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<CategoryMap> loadCategoryMaps() {
        List<CategoryMap> list = new ArrayList<>();

        try(
                Connection con = dh.getConnection();
                PreparedStatement pr = con.prepareStatement("SELECT * FROM category_map");
                ResultSet rs = pr.executeQuery()
        ) {
            while(rs.next()) {
                int shoeId = rs.getInt("shoe_id");
                int categoryId = rs.getInt("category_id");
                Shoe shoe = shoes.stream().filter(a -> a.getId() == shoeId).toList().getFirst();
                Category category = categories.stream().filter(a -> a.getId() == categoryId).toList().getFirst();

                list.add(new CategoryMap(shoe, category));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Problem loading category maps");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addToCart(int customerId, int orderId, int shoeId) {
        try(
                Connection con = dh.getConnection();
                CallableStatement stmt = con.prepareCall("CALL addToCart(?, ?, ?)")
        ) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, orderId);
            stmt.setInt(3, shoeId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
        }
        orders = loadOrders();
        stockEntries = loadStockEntries();
        shoppingCart = loadShoppingCart();

    }

    public int getLoggedInUserId() {
        return loggedInUserId;
    }

    public void setLoggedInUserId(int loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }

    public OrderEntry getLoggedInUsersLastOrder() {
        return loggedInUsersLastOrder;
    }

    public void setLoggedInUsersLastOrder(OrderEntry loggedInUsersLastOrder) {
        this.loggedInUsersLastOrder = loggedInUsersLastOrder;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public List<Color> getColors() {
        return colors;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<OrderEntry> getOrders() {
        return orders;
    }

    public List<Stock> getStockEntries() {
        return stockEntries;
    }

    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public List<CategoryMap> getCategoryMaps() {
        return categoryMaps;
    }
}
