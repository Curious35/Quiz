package com.kvv.quiz.frontpageclasses;

import java.awt.Font;
import javax.swing.JButton;

/**
 * Кнопка "Готово" начальной страницы приложения
 * @author Kukushkin V.
 */
class ReadyButton extends JButton {
    static final String READY_ENABLED = "Выберите раздел";
    static final Font TEXT_BUTTON = new Font("Arial", Font.ITALIC, 14);
    
    private static ReadyButton ready = new ReadyButton("Готово");
    
    static ReadyButton getReady(){
        return ready;
    }
    
    void initReadyButton(ReadyButton b, int x, int y, int w, int h, boolean flag){
        b.setFont(TEXT_BUTTON);
        b.setBounds(x, y, w, h);        
        b.setEnabled(flag);
        if (!b.isEnabled())
            b.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + READY_ENABLED + "</font>" + "</html>");
    }
    
    ReadyButton(String s){
        setText(s);
    }
}
