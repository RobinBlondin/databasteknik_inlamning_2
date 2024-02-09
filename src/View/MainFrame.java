package View;

import Controller.Reporter;
import Controller.Repository;
import Model.Customer;
import Model.MainFrameCallback;
import Model.OrderEntry;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class MainFrame extends JFrame implements MainFrameCallback {
    private final Repository repo;
    private final Reporter reporter;
    private final CardLayout cardLayout;
    private final JPanel cards;
    private final LoginPanel loginPanel;
    private final ShopPanel shopPanel;
    private final ReportPanel reportPanel;

    public MainFrame() {
        repo = new Repository();
        reporter = new Reporter(repo);
        cards = new JPanel(new CardLayout());
        loginPanel = new LoginPanel(this);
        shopPanel = new ShopPanel(reporter, this);
        reportPanel = new ReportPanel(reporter, this);

        this.setTitle("Soles with soul");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        cards.setSize(new Dimension(1000, 1000));
        cards.add(shopPanel, "shop");
        cards.add(loginPanel, "login");
        cards.add(reportPanel, "report");

        cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, "login");

        this.getContentPane().add(cards);
        this.setVisible(true);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public ShopPanel getShopPanel() {
        return shopPanel;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public ReportPanel getReportPanel() {
        return reportPanel;
    }

    public JPanel getCards() {
        return cards;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public Repository getRepo() {
        return repo;
    }

    @Override
    public void onButtonClicked(int id) {
        switch(id) {
            case 1 -> this.getCardLayout().show(getCards(), "report");
            case 2 -> getCardLayout().show(getCards(), "login");
            case 3 -> System.exit(0);
            case 4 -> {
                String brandFromBox = Objects.requireNonNull(reportPanel.getComboBoxPanel().getBrands().getSelectedItem()).toString();
                String colorFromBox = Objects.requireNonNull(reportPanel.getComboBoxPanel().getColor().getSelectedItem()).toString();
                String sizeFromBox = Objects.requireNonNull(getReportPanel().getComboBoxPanel().getSizes().getSelectedItem()).toString();

                java.util.List<String> list = getReporter().customerPurchases(sizeFromBox, colorFromBox, brandFromBox);
                getReportPanel().getListPanel().refresh(list, 2);
            }
            case 5 -> {
                java.util.List<String> list = getReporter().ordersPerCustomer();
                getReportPanel().getListPanel().refresh(list, 3);
            }
            case 6 -> {
                java.util.List<String> list = getReporter().moneySpentByCustomer();
                getReportPanel().getListPanel().refresh(list, 3);
            }
            case 7 -> {
                java.util.List<String> list = getReporter().moneySpentPerCity();
                getReportPanel().getListPanel().refresh(list, 3);
            }
            case 8 -> {
                List<String> list = getReporter().mostSoldProducts();
                getReportPanel().getListPanel().refresh(list, 4);
            }
            case 9 -> getCardLayout().show(getCards(), "shop");
            case 10 -> {
                System.out.println("login pressed");
                JTextField userField = getLoginPanel().getUserField();
                JTextField passField = getLoginPanel().getPassField();
                JLabel errorLabel = getLoginPanel().getErrorLabel();

                boolean isValidUser = getRepo()
                        .getCustomers()
                        .stream()
                        .filter(user -> user.getEmail().equals(userField.getText()))
                        .anyMatch(pass -> pass.getPassword().equals(passField.getText()));

                if(isValidUser) {
                    getCardLayout().show(getCards(), "shop");

                    int currentId = getRepo()
                            .getCustomers()
                            .stream()
                            .filter(user -> user.getEmail().equals(userField.getText()))
                            .map(Customer::getId)
                            .toList()
                            .getFirst();

                    OrderEntry lastOrder = getRepo()
                            .getOrders()
                            .stream()
                            .filter(order -> order.getCustomer().getId() == currentId)
                            .toList()
                            .getLast();

                    System.out.println(currentId);
                    getRepo().setLoggedInUserId(currentId);
                    getRepo().setLoggedInUsersLastOrder(lastOrder);
                    userField.setText("");
                    passField.setText("");
                    errorLabel.setText("");
                } else {
                    errorLabel.setText("Username or password is incorrect");
                }
            }
            default -> System.out.println("nothing was performed");

        }
    }

}
