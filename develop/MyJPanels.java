package com.kvv.quiz.develop;

/**
 *
 * @author Kukushkin V.
 */
import com.kvv.quiz.tasks.CommonFields;
import javax.swing.*;

import static java.awt.Color.YELLOW;

class MyJPanels extends JPanel {
    private static final int HEIGHT_PANEL = 150;

    static int getHEIGHT_PANEL() {
        return HEIGHT_PANEL;
    }

    MyJPanels(int formI) {
        setBounds(0, formI*HEIGHT_PANEL, 700, HEIGHT_PANEL);
        setBackground(YELLOW);
        setLayout(null);
        add(CommonFields.labels.get(3*formI));
        add(CommonFields.labels.get(3*formI + 1));
        add(CommonFields.labels.get(3*formI + 2));
        add(CommonFields.buttons.get(formI));
        revalidate();
        repaint();
    }    
}
