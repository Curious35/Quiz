package com.kvv.quiz.develop;

/**
 *
 * @author Kukushkin V.
 */
import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLUE;
import static java.awt.Color.YELLOW;

class MyJLabel extends JLabel {
    private static final int HEIGHT_LABEL = 40;
    private Font typeText = new Font("Arial", Font.ITALIC, 17);

    MyJLabel(int formI, int formK, String s) {
        setBackground(YELLOW);
        setBounds(20, formK*HEIGHT_LABEL + formI*MyJPanels.getHEIGHT_PANEL() + 15, 200, HEIGHT_LABEL);
        setFont(typeText);//Начиная со второй панели, исчезает текст
        setText(s);
        setBackground(BLUE);
        setOpaque(true);
        setVisible(true);
    }
}
