package com.kvv.quiz.tasks;

import java.awt.Font;
import javax.swing.JButton;

/**
 * Кнопки переключения "Назад" и "Вперёд"
 * @author Kukushkin V.
 */
class SwitchButtons extends JButton {
    private final static Font TEXT_BUTTON = new Font("Arial", Font.ITALIC, 14);
    
    static final String RIGHT_ENABLED = "Можете нажать на кнопку RIGHT";
    static final String LEFT_ENABLED  = "Можете нажать на кнопку LEFT";
    
    private static SwitchButtons next = new SwitchButtons();
    private static SwitchButtons back = new SwitchButtons();
    
    static SwitchButtons getNext(){
        return next;
    }
    
    static void setNext(SwitchButtons b){
        SwitchButtons.next = b;
    }
    
    static SwitchButtons getBack(){
        return back;
    }
    
    static void setBack(SwitchButtons b){
        SwitchButtons.back = b;
    }
    
    static Font getTEXT_BUTTON(){
        return TEXT_BUTTON;
    }
    
    void initSwitchButton(JButton b, String s, boolean en, int x, int y, int w, int h){
        b.setFont(TEXT_BUTTON);
        b.setText(s);
        b.setBounds(x, y, w, h);
        b.setEnabled(en);
        if (b.equals(next))
            next.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + RIGHT_ENABLED + "</font>" + "</html>");
    }
    
    static void setupPopupHint(SwitchButtons obj1, SwitchButtons obj2, String s1, String s2){
        if (obj1.isEnabled())
            obj1.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + s1 + "</font>" + "</html>");
        else
            obj1.setToolTipText(null);
        obj2.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + s2 + "</font>" + "</html>");
    }
}
