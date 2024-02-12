package View;

import Controller.Reporter;
import Model.MainFrameCallback;

import javax.swing.*;
import java.awt.*;

public class ShopPanel extends JPanel {
    private final FilterPanel filterPanel;
    private final ListPanel listPanel;
    private final JLabel errorMessage;
    private final CartPanel cartPanel;
    private final JLabel cartSum;
    public ShopPanel(Reporter reporter, MainFrameCallback callBack) {
        listPanel = new ListPanel(reporter, true, callBack);
        filterPanel = new FilterPanel(reporter, listPanel, callBack);
        cartPanel = new CartPanel(reporter);
        StyleSettings style = StyleSettings.getInstance();

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(1000, 1000));

        JLabel eastTitleLabel = new JLabel("Ordered shoes");
        eastTitleLabel.setForeground(style.getTextColor_LIGHT());

        JPanel logoPanel = new LogoPanel();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(style.getBackgroundColor_SELECTED());
        northPanel.setPreferredSize(new Dimension(1000, 75));
        northPanel.setBorder(BorderFactory.createMatteBorder(0,0,2,0, style.getButtonColor()));

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.setBackground(style.getBackgroundColor_DARK());
        westPanel.setPreferredSize(new Dimension(200, 1000));
        westPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,2, style.getButtonColor()));

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BorderLayout());
        eastPanel.setBackground(style.getBackgroundColor_DARK());
        eastPanel.setPreferredSize(new Dimension(200, 1000));
        eastPanel.setBorder(BorderFactory.createMatteBorder(0,2,0,0, style.getButtonColor()));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(style.getBackgroundColor_LIGHT());
        centerPanel.setPreferredSize(new Dimension(600, 925));
        centerPanel.setBorder(BorderFactory.createMatteBorder(2,2,2,2, style.getButtonColor()));

        JPanel southPanel = new JPanel();
        southPanel.setBackground(style.getBackgroundColor_SELECTED());
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.setPreferredSize(new Dimension(1000, 100));
        southPanel.setBorder(BorderFactory.createMatteBorder(2,0,0,0, style.getButtonColor()));

        errorMessage = new JLabel();
        errorMessage.setBackground(style.getBackgroundColor_SELECTED());
        errorMessage.setPreferredSize(new Dimension(600, 100));
        errorMessage.setMinimumSize(new Dimension(600, 100));
        errorMessage.setMinimumSize(new Dimension(600, 100));
        errorMessage.setForeground(Color.red);
        errorMessage.setFont(style.getSmallFontBold());
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JLabel errorEmptyLabel2 = new JLabel();
        errorEmptyLabel2.setBackground(style.getBackgroundColor_SELECTED());
        errorEmptyLabel2.setPreferredSize(new Dimension(200, 100));
        errorEmptyLabel2.setMinimumSize(new Dimension(200, 100));
        errorEmptyLabel2.setMinimumSize(new Dimension(200, 100));

        northPanel.add(logoPanel);

        JLabel cartTitle = new JLabel("Ordered items");
        cartTitle.setForeground(style.getTextColor_LIGHT());
        cartTitle.setBackground(style.getBackgroundColor_DARK());
        cartTitle.setFont(style.getMicroFontBold());
        cartTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel cartTotalText = new JLabel("Total: ");
        cartTotalText.setForeground(style.getTextColor_LIGHT());
        cartTotalText.setBackground(style.getBackgroundColor_DARK());
        cartTotalText.setFont(style.getMicroFontBold());
        cartTotalText.setPreferredSize(new Dimension(100, 50));

        cartSum = new JLabel("0");
        cartSum.setForeground(style.getTextColor_LIGHT());
        cartSum.setBackground(style.getBackgroundColor_DARK());
        cartSum.setFont(style.getMicroFontBold());
        cartSum.setPreferredSize(new Dimension(100, 50));

        JPanel totalSumPanel = new JPanel();
        totalSumPanel.setLayout(new BoxLayout(totalSumPanel, BoxLayout.X_AXIS));
        totalSumPanel.setPreferredSize(new Dimension(200, 50));
        totalSumPanel.setForeground(style.getTextColor_LIGHT());
        totalSumPanel.setBackground(style.getBackgroundColor_DARK());
        totalSumPanel.setFont(style.getMicroFontBold());
        totalSumPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        totalSumPanel.add(cartTotalText);
        totalSumPanel.add(cartSum);

        centerPanel.add(filterPanel, BorderLayout.NORTH);
        centerPanel.add(listPanel, BorderLayout.CENTER);

        westPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        westPanel.add(new ButtonPanel(1, "Show reports", true, callBack));
        westPanel.add(Box.createRigidArea(new Dimension(0, 520)));
        westPanel.add(new ButtonPanel(2, "Logout", true, callBack));
        westPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        westPanel.add(new ButtonPanel(3, "Quit", true, callBack));
        westPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        eastPanel.add(cartTitle, BorderLayout.NORTH);
        eastPanel.add(cartPanel, BorderLayout.CENTER);
        eastPanel.add(totalSumPanel, BorderLayout.SOUTH);

        southPanel.add(Box.createRigidArea(new Dimension(320, 0)));
        southPanel.add(errorMessage);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public FilterPanel getFilterPanel() {
        return filterPanel;
    }

    public ListPanel getListPanel() {
        return listPanel;
    }

    public void setErrorMessageText(String text) {
        errorMessage.setText(text);
    }

    public CartPanel getCartPanel() {
        return cartPanel;
    }

    public void setCartSumText(String text) {
        cartSum.setText(text);
    }

}
