package View;

import Controller.Reporter;
import Controller.Repository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reporter r = new Reporter();

        List<String> filteredShoes = r.filterShoes("", "", "", "", "winter");
        System.out.println(filteredShoes);
        //new MainFrame();

    }
}
