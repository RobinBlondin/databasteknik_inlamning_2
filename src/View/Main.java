package View;

import Controller.DataHandler;

public class Main {
    public static void main(String[] args) {
        DataHandler dh = new DataHandler();
        System.out.println(dh.getColors().getFirst().getName());

    }
}
