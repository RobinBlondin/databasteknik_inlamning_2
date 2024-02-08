package View;

import Controller.Reporter;
import Controller.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListPanel extends JPanel {

    private final int MIN_ENTRIES = 12;
    private final JPanel gridPanel;
    private final JPanel emptyPanel;
    private final Repository repo;
    private List<String> filteredList;

    public ListPanel(MainFrame mainFrame, Reporter reporter, Repository repo) {
        StyleSettings style = StyleSettings.getInstance();
        this.repo = repo;

        filteredList = reporter.filterShoes("", "", "", "", "");
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        gridPanel = new JPanel();
        gridPanel.setLayout(new BoxLayout(gridPanel, BoxLayout.PAGE_AXIS));
        gridPanel.setBorder(BorderFactory.createEmptyBorder());
        gridPanel.setBackground(style.getBackgroundColor_LIGHT());
        
        emptyPanel = new JPanel();
        emptyPanel.setBackground(style.getBackgroundColor_LIGHT());
        emptyPanel.setPreferredSize(new Dimension(600, 50));
        emptyPanel.setBorder(BorderFactory.createEmptyBorder());
        emptyPanel.setVisible(true);

        refresh(filteredList, 1);

        JScrollPane scrollPane = new JScrollPane(gridPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scrollPane.setBackground(style.getBackgroundColor_LIGHT());
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public void refresh(List<String> list, int report) {
        gridPanel.removeAll();
        for (String str : list) {
            String[] arr = str.split(", ");
            switch(report) {
                case 1 -> gridPanel.add(new ListLabel(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], String.valueOf(arr[4]), String.valueOf(arr[5]), repo, true));
                case 2 -> gridPanel.add(new ListLabel(Integer.parseInt(arr[0]), arr[1], arr[3], arr[4], arr[5], "", repo, false));

            }
        }
        for (int i = list.size(); i < MIN_ENTRIES; i++) {
            gridPanel.add(emptyPanel);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void addToUI(Component component) {
        gridPanel.add(component);
        this.add(component);
        this.revalidate();
        this.repaint();
    }

    public void removeFromUI(String platform, String userName) {
        for (Component component : gridPanel.getComponents()) {
            if (component instanceof ListLabel listLabel) {
                if (listLabel.getBrandText().equalsIgnoreCase(platform) && listLabel.getModelText().equalsIgnoreCase(userName)) {
                    System.out.println("Removing: " + platform + " " + userName);
                    gridPanel.remove(component);
                    this.remove(component);
                    this.revalidate();
                    this.repaint();
                    return;
                }
            }
        }
    }

    /*public void filter(String brand, String model, String ) {
        gridPanel.removeAll();

        for (Password entry : passwordManager.getPasswordEntries()) {
            if (entry.getPlatform().toLowerCase().contains(filter) || entry.getUserName().toLowerCase().contains(filter)) {
                gridPanel.add(new ListPanel(entry.getPlatform(), entry.getUserName(), entry.getPassword(), homePage));
            }
        }
        for (int i = passwordManager.getPasswordEntries().size(); i < MIN_ENTRIES; i++) {
            gridPanel.add(new JPanel());
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }*/
}

