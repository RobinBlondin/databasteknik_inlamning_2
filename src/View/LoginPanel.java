package View;

import Model.Customer;
import Model.OrderEntry;
import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    public LoginPanel(MainFrame mainFrame) {
        StyleSettings style = StyleSettings.getInstance();
        this.setBackground(style.getBackgroundColor_LIGHT());
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1000, 1000));

        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(300, 1000));
        westPanel.setBackground(style.getBackgroundColor_LIGHT());

        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(300, 1000));
        eastPanel.setBackground(style.getBackgroundColor_LIGHT());

        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(1000, 400));
        southPanel.setBackground(style.getBackgroundColor_LIGHT());

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(1000, 400));
        northPanel.setBackground(style.getBackgroundColor_LIGHT());

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(style.getBackgroundColor_LIGHT());
        centerPanel.setPreferredSize(new Dimension(400, 400));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setPreferredSize(new Dimension(400, 100));
        buttonPanel.setBackground(style.getBackgroundColor_LIGHT());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));

        JLabel emptyLabel = new JLabel();
        emptyLabel.setPreferredSize(new Dimension(50, 50));

        JLabel errorLabel = new JLabel();
        errorLabel.setPreferredSize(new Dimension(400, 40));
        errorLabel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 50));
        errorLabel.setFont(style.getMicroFont());
        errorLabel.setForeground(Color.red);

        JTextField userField = new JTextField();
        JTextField passField = new JPasswordField();

        userField.setPreferredSize(new Dimension(200, 60));
        userField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5,10));
        userField.setFont(style.getMicroFont());

        passField.setPreferredSize(new Dimension(200, 60));
        passField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5,10));
        passField.setFont(style.getMicroFont());

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 50));
        loginButton.setBackground(style.getBackgroundColor_LIGHT());
        loginButton.setForeground(style.getTextColor_LIGHT());
        loginButton.setFont(style.getSmallFont());
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(a -> {
            boolean isValidUser = mainFrame.getRepo()
                    .getCustomers()
                    .stream()
                    .filter(user -> user.getEmail().equals(userField.getText()))
                    .anyMatch(pass -> pass.getPassword().equals(passField.getText()));

            if(isValidUser) {
                mainFrame.getCardLayout().show(mainFrame.getCards(), "shop");

                int currentId = mainFrame.getRepo()
                        .getCustomers()
                        .stream()
                        .filter(user -> user.getEmail().equals(userField.getText()))
                        .map(Customer::getId)
                        .toList()
                        .getFirst();

                OrderEntry lastOrder = mainFrame.getRepo()
                        .getOrders()
                        .stream()
                        .filter(order -> order.getCustomer().getId() == currentId)
                        .toList()
                        .getLast();

                System.out.println(currentId);
                mainFrame.getRepo().setLoggedInUserId(currentId);
                mainFrame.getRepo().setLoggedInUsersLastOrder(lastOrder);
            } else {
                errorLabel.setText("Username or password is incorrect");
            }
        });

        JButton exitButton = new JButton("Quit");
        exitButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setBackground(style.getBackgroundColor_LIGHT());
        exitButton.setForeground(style.getTextColor_LIGHT());
        exitButton.setFont(style.getSmallFont());
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(a -> System.exit(0));

        buttonPanel.add(loginButton);
        buttonPanel.add(emptyLabel);
        buttonPanel.add(exitButton);

        centerPanel.add(userField);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerPanel.add(passField);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(errorLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
