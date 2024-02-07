package Controller;

import View.LoginPanel;
import View.MainFrame;
import View.ShopPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    private final MainFrame mainFrame;
    private final ShopPanel shopPanel;
    private final LoginPanel loginPanel;

    public ActionListener(MainFrame mainFrame, ShopPanel shopPanel, LoginPanel loginPanel) {
        this.mainFrame = mainFrame;
        this.shopPanel = shopPanel;
        this.loginPanel = loginPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton pressed = (JButton)e.getSource();

        if (pressed.getText().contains("1")) {
            System.out.println("button 1 pressed");
            mainFrame.getCardLayout().show(mainFrame.getCards(), "login");
        }

    }
}
