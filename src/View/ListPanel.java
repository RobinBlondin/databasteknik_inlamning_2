package View;

import Controller.Reporter;
import Controller.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListPanel extends JPanel {
    private final JPanel gridPanel;
    private final JPanel emptyPanel;
    private final Repository repo;
    private final boolean withCartButton;

    public ListPanel(Reporter reporter, Repository repo, boolean withCartButton) {
        StyleSettings style = StyleSettings.getInstance();
        this.repo = repo;
        this.withCartButton = withCartButton;

        List<String> filteredList = reporter.filterShoes("", "", "", "", "");
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        gridPanel = new JPanel();
        gridPanel.setLayout(new BoxLayout(gridPanel, BoxLayout.PAGE_AXIS));
        gridPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, style.getButtonColor()));
        gridPanel.setBackground(style.getBackgroundColor_LIGHT());
        
        emptyPanel = new JPanel();
        emptyPanel.setBackground(style.getBackgroundColor_LIGHT());
        emptyPanel.setPreferredSize(new Dimension(600, 50));
        emptyPanel.setBorder(BorderFactory.createEmptyBorder());
        emptyPanel.setVisible(true);

        refresh(filteredList, 1);

        JScrollPane scrollPane = new JScrollPane(gridPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setBackground(style.getBackgroundColor_LIGHT());
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public void refresh(List<String> list, int report) {
        gridPanel.removeAll();
        for (String str : list) {
            String[] arr = str.split(", ");
            switch(report) {
                case 1 -> gridPanel.add(new ListLabel(Integer.parseInt(arr[0]), repo, withCartButton, arr[1], arr[2], arr[3], arr[4], arr[5]));
                case 2 -> gridPanel.add(new ListLabel(Integer.parseInt(arr[0]),repo, withCartButton, arr[1], arr[2], arr[3]));
                case 3 -> gridPanel.add(new ListLabel(0, repo, withCartButton, arr[0], arr[1]));
                case 4 -> gridPanel.add(new ListLabel(0, repo, withCartButton, arr[0], arr[1], arr[2]));
            }
        }
        int MIN_ENTRIES = 12;
        for (int i = list.size(); i < MIN_ENTRIES; i++) {
            gridPanel.add(emptyPanel);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    public void clearList() {
        gridPanel.removeAll();
    }
}

