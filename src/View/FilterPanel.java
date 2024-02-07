package View;

import Controller.Repository;
import Model.FilterInterface;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FilterPanel<T> extends JPanel {
    private Repository repo;
    private JComboBox<String> brandBox;
    private JComboBox<String> modelBox;
    private JComboBox<String> colorBox;
    private JComboBox<String> sizeBox;
    private JComboBox<String> categoryBox;
    private JLabel brandLabel;
    private JLabel modelLabel;
    private JLabel colorLabel;
    private JLabel sizeLabel;
    private JLabel emptyLabel;

    public FilterPanel(Repository repo) {
        this.repo = repo;
        StyleSettings style = StyleSettings.getInstance();


        brandBox = new JComboBox<>();
        modelBox = new JComboBox<>();
        colorBox = new JComboBox<>();
        sizeBox = new JComboBox<>();
        categoryBox = new JComboBox<>();
        brandLabel = new JLabel("Brand");
        modelLabel = new JLabel("Model");
        colorLabel = new JLabel("Color");
        sizeLabel = new JLabel("Size");
        emptyLabel = new JLabel();

        this.setLayout(new GridLayout(5, 5));
        this.setPreferredSize(new Dimension(800, 50));
        brandLabel.setFont(style.getSmallFontBold());
        modelLabel.setFont(style.getSmallFontBold());
        colorLabel.setFont(style.getSmallFontBold());
        sizeLabel.setFont(style.getSmallFontBold());

        brandLabel.setBackground(style.getBackgroundColor_LIGHT());
        modelLabel.setBackground(style.getBackgroundColor_LIGHT());
        colorLabel.setBackground(style.getBackgroundColor_LIGHT());
        sizeLabel.setBackground(style.getBackgroundColor_LIGHT());
        emptyLabel.setBackground(style.getBackgroundColor_LIGHT());

        brandLabel.setForeground(style.getTextColor_DARK());
        modelLabel.setForeground(style.getTextColor_DARK());
        colorLabel.setForeground(style.getTextColor_DARK());
        sizeLabel.setForeground(style.getTextColor_DARK());
    }

    public List<String> getListForDropDownMenu<T>(List<T> list, Fi) {
        list.stream()
    }
}
