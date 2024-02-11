package View;

import Controller.Reporter;
import Model.MainFrameCallback;
import Model.Stock;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class ListPanel extends JPanel {
    private final Reporter reporter;
    private final JPanel gridPanel;
    private final JPanel emptyPanel;
    private boolean withCartButton;
    private final MainFrameCallback callback;

    public ListPanel(Reporter reporter, boolean withCartButton, MainFrameCallback callback) {
        StyleSettings style = StyleSettings.getInstance();
        this.reporter = reporter;
        this.withCartButton = withCartButton;
        this.callback = callback;

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
        SwingUtilities.invokeLater(() -> {
        gridPanel.removeAll();

        for (String str : list) {
            String[] arr = str.split(", ");

            switch(report) {
                case 1 -> gridPanel.add(new ListLabel(Integer.parseInt(arr[0]), arr[1], reporter.getRepo(), withCartButton, callback, arr[2], arr[3], arr[4], arr[5], arr[6]));
                case 2 -> gridPanel.add(new ListLabel(Integer.parseInt(arr[0]), "", reporter.getRepo(), withCartButton, callback, arr[1], arr[2], arr[3]));
                case 3 -> gridPanel.add(new ListLabel(0, "", reporter.getRepo(), withCartButton, callback, arr[0], arr[1]));
                case 4 -> gridPanel.add(new ListLabel(0, "", reporter.getRepo(), withCartButton, callback, arr[0], arr[1], arr[2]));
            }
        }
        int MIN_ENTRIES = 12;
        for (int i = list.size(); i < MIN_ENTRIES; i++) {
            gridPanel.add(emptyPanel);
        }
        gridPanel.revalidate();
        gridPanel.repaint();
        });
    }

    public void clearList() {
        gridPanel.removeAll();
        gridPanel.revalidate();
        gridPanel.repaint();
    }


}

