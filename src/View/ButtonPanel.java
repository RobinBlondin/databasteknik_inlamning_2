package View;

import Model.Customer;
import Model.OrderEntry;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ButtonPanel extends JPanel implements java.awt.event.ActionListener {
    private final int id;
    private final MainFrame mainFrame;

    public ButtonPanel(int id, String text, MainFrame mainFrame, boolean leftAlign) {
        StyleSettings style = StyleSettings.getInstance();
        this.id = id;
        this.mainFrame = mainFrame;
        this.setBackground(style.getBackgroundColor_DARK());

        JButton button = new JButton();
        button.setText(text);
        button.setPreferredSize(new Dimension(150, 50));
        button.setFont(style.getMicroFontBold());
        button.setBackground(style.getBackgroundColor_DARK());
        button.setForeground(style.getButtonColor());
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,0));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.addActionListener(this);
        button.setFocusPainted(false);

        if(leftAlign) {
            button.setHorizontalAlignment(SwingConstants.LEFT);
        } else {
            button.setHorizontalAlignment(SwingConstants.CENTER);
        }

        this.add(button);
        this.setVisible(true);
    }

    public int getId() {
        return id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        ButtonPanel button = (ButtonPanel)source.getParent();
        int id = button.getId();

       switch(id) {
           case 1 -> mainFrame.getCardLayout().show(mainFrame.getCards(), "report");
           case 2 -> mainFrame.getCardLayout().show(mainFrame.getCards(), "login");
           case 3 -> System.exit(0);
           case 4 -> {
               String brand = mainFrame.getReportPanel().getComboBoxPanel().getBrands().getSelectedItem().toString();
               String color = mainFrame.getReportPanel().getComboBoxPanel().getColor().getSelectedItem().toString();
               String size = mainFrame.getReportPanel().getComboBoxPanel().getSizes().getSelectedItem().toString();

               List<String> list = mainFrame.getReporter().customerPurchases(size, color, brand);
               mainFrame.getReportPanel().getListPanel().refresh(list, 2);
           }
           case 5 -> {
               List<String> list = mainFrame.getReporter().ordersPerCustomer();
               mainFrame.getReportPanel().getListPanel().refresh(list, 3);
           }
           case 6 -> {
               List<String> list = mainFrame.getReporter().moneySpentByCustomer();
               mainFrame.getReportPanel().getListPanel().refresh(list, 3);
           }
           case 7 -> {
               List<String> list = mainFrame.getReporter().moneySpentPerCity();
               mainFrame.getReportPanel().getListPanel().refresh(list, 3);
           }
           case 8 -> {
               List<String> list = mainFrame.getReporter().mostSoldProducts();
               mainFrame.getReportPanel().getListPanel().refresh(list, 4);
           }
           case 9 -> mainFrame.getCardLayout().show(mainFrame.getCards(), "shop");
           case 10 -> {
               System.out.println("login pressed");
               JTextField userField = mainFrame.getLoginPanel().getUserField();
               JTextField passField = mainFrame.getLoginPanel().getPassField();
               JLabel errorLabel = mainFrame.getLoginPanel().getErrorLabel();

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
