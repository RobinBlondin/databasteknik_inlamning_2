package View;

import Controller.Reporter;
import Controller.Repository;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final Reporter reporter;
    private final Repository repo;
    private final ShopPanel shopPanel;
    private final CardLayout cardLayout;
    private final JPanel cards;
    private final LoginPanel loginPanel;

    public MainFrame() {
        StyleSettings style = StyleSettings.getInstance();

        reporter = new Reporter();
        repo = new Repository();
        shopPanel = new ShopPanel(repo, reporter, this);
        cards = new JPanel(new CardLayout());
        loginPanel = new LoginPanel(this);

        this.setTitle("Soles with soul");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        cards.setSize(new Dimension(1000, 1000));
        cards.add(shopPanel, "shop");
        cards.add(loginPanel, "login");

        cardLayout = (CardLayout) cards.getLayout();



        this.getContentPane().add(cards);
        cardLayout.show(cards, "login");
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

    public JPanel getCards() {
        return cards;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public Repository getRepo() {
        return repo;
    }
}
