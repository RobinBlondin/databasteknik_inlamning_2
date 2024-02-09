package View;

import Controller.Reporter;
import Controller.Repository;

public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();
        Reporter r = new Reporter(repo);
        new MainFrame();
    }
}
