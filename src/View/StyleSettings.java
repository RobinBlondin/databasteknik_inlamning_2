package View;

import java.awt.*;

public class StyleSettings {
    private static StyleSettings instance;
    private final Font bigFont;
    private final Font mediumFont;
    private final Font smallFont;
    private final Font microFont;
    private final Font bigFontBold;
    private final Font mediumFontBold;
    private final Font smallFontBold;
    private final Font microFontBold;
    private final Color backgroundColor_LIGHT;
    private final Color backgroundColor_DARK;
    private final Color backgroundColor_SELECTED;
    private final Color textColor_BLACK;
    private final Color textColor_WHITE;
    private final Color textColor_SELECTED;
    private final Color textColor_DARK;
    private final Color textColor_LIGHT;
    private final Color buttonColor;
    private final Color buttonColor2;
    private final Color buttonColor3;

    public StyleSettings() {
        bigFont = new Font("Sans Serif", Font.PLAIN, 35);
        mediumFont = new Font("Sans Serif", Font.PLAIN, 25);
        smallFont = new Font("Sans Serif", Font.PLAIN, 18);
        microFont = new Font("Sans Serif", Font.PLAIN, 14);
        bigFontBold = new Font("Sans Serif", Font.BOLD, 35);
        mediumFontBold = new Font("Sans Serif", Font.BOLD, 25);
        smallFontBold = new Font("Sans Serif", Font.BOLD, 18);
        microFontBold = new Font("Sans Serif", Font.BOLD, 14);
        backgroundColor_LIGHT = new Color(50, 49, 62);
        backgroundColor_DARK = new Color(39, 39, 48);
        backgroundColor_SELECTED = new Color(85, 84, 97);
        textColor_BLACK = new Color(0, 0, 0);
        textColor_WHITE = new Color(255, 255, 255);
        textColor_SELECTED = new Color(157, 157, 164);
        textColor_DARK = new Color(98, 98, 107);
        textColor_LIGHT = new Color(157, 172, 174);
        buttonColor = new Color(158, 119, 226);
        buttonColor2 = new Color(50, 10, 95);
        buttonColor3 = new Color(46, 48, 95);

    }
    public static StyleSettings getInstance() {
        if (instance == null) {
            instance = new StyleSettings();
        }
        return instance;
    }

    public Font getBigFont() {
        return bigFont;
    }

    public Font getMediumFont() {
        return mediumFont;
    }

    public Font getSmallFont() {
        return smallFont;
    }

    public Font getMicroFont() {
        return microFont;
    }

    public Font getBigFontBold() {
        return bigFontBold;
    }

    public Font getMediumFontBold() {
        return mediumFontBold;
    }

    public Font getSmallFontBold() {
        return smallFontBold;
    }

    public Font getMicroFontBold() {
        return microFontBold;
    }

    public Color getBackgroundColor_LIGHT() {
        return backgroundColor_LIGHT;
    }

    public Color getBackgroundColor_DARK() {
        return backgroundColor_DARK;
    }

    public Color getBackgroundColor_SELECTED() {
        return backgroundColor_SELECTED;
    }

    public Color getTextColor_BLACK() {
        return textColor_BLACK;
    }

    public Color getTextColor_WHITE() {
        return textColor_WHITE;
    }

    public Color getTextColor_SELECTED() {
        return textColor_SELECTED;
    }

    public Color getTextColor_DARK() {
        return textColor_DARK;
    }

    public Color getTextColor_LIGHT() {
        return textColor_LIGHT;
    }

    public Color getButtonColor() {return buttonColor;}

    public Color getButtonColor2() {
        return buttonColor2;
    }

    public Color getButtonColor3() {
        return buttonColor3;
    }
}
