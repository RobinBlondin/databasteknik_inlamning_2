package View;

import Controller.Reporter;
import Controller.Repository;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final Reporter reporter;
    private final Repository repo;
    private final CardLayout cardLayout;
    private final JPanel cards;
    private final LoginPanel loginPanel;
    private final ShopPanel shopPanel;
    private final ReportPanel reportPanel;

    public MainFrame() {
        StyleSettings style = StyleSettings.getInstance();

        reporter = new Reporter();
        repo = new Repository();
        cards = new JPanel(new CardLayout());
        loginPanel = new LoginPanel(this);
        shopPanel = new ShopPanel(repo, reporter, this);
        reportPanel = new ReportPanel(repo, reporter, this);

        this.setTitle("Soles with soul");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        cards.setSize(new Dimension(1000, 1000));
        cards.add(shopPanel, "shop");
        cards.add(loginPanel, "login");
        cards.add(reportPanel, "report");

        cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, "report");

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
