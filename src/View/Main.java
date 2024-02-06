package View;

import Controller.Reporter;
import Controller.Repository;

public class Main {
    public static void main(String[] args) {
       Reporter r = new Reporter();
       r.customerPurchases("38", "black", "vagabond");
    }
}
