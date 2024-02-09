package View;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private final JTextField userField;
    private final JTextField passField;
    private final JLabel errorLabel;
    public LoginPanel(MainFrame mainFrame) {
        StyleSettings style = StyleSettings.getInstance();
        this.setBackground(style.getBackgroundColor_DARK());
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1000, 1000));

        ImageIcon logo = new ImageIcon("images/loginLogo.png");
        JLabel logoLabel = new JLabel(logo);

        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(300, 1000));
        westPanel.setBackground(style.getBackgroundColor_DARK());

        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(300, 1000));
        eastPanel.setBackground(style.getBackgroundColor_DARK());

        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(1000, 400));
        southPanel.setBackground(style.getBackgroundColor_DARK());

        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(1000, 400));
        northPanel.setBackground(style.getBackgroundColor_DARK());

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(style.getBackgroundColor_DARK());
        centerPanel.setPreferredSize(new Dimension(450, 400));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setPreferredSize(new Dimension(450, 100));
        buttonPanel.setBackground(style.getBackgroundColor_DARK());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));

        JLabel emptyLabel = new JLabel();
        emptyLabel.setPreferredSize(new Dimension(50, 50));

        errorLabel = new JLabel();
        errorLabel.setPreferredSize(new Dimension(400, 40));
        errorLabel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 50));
        errorLabel.setFont(style.getMicroFont());
        errorLabel.setForeground(Color.red);

        userField = new JTextField();
        passField = new JPasswordField();

        userField.setPreferredSize(new Dimension(200, 60));
        userField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5,10));
        userField.setFont(style.getMicroFontBold());
        userField.setBackground(style.getButtonColor());

        passField.setPreferredSize(new Dimension(200, 60));
        passField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5,10));
        passField.setFont(style.getMicroFontBold());
        passField.setBackground(style.getButtonColor());

        ButtonPanel loginButton = new ButtonPanel(10, "Login", mainFrame, false);
        ButtonPanel exitButton = new ButtonPanel(3, "Quit", mainFrame, false);

        northPanel.add(logoLabel);

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
    public JTextField getUserField() {
        return userField;
    }

    public JTextField getPassField() {
        return passField;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }
}
