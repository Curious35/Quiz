package com.kvv.quiz.tasks;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Компонент с вопросом для каждого уровня сложности
 * @author Kukushkin V.
 */
class Ask {
    private static JLabel ask = new JLabel();
    
    static JLabel getAsk(){
        return ask;
    }
    
    static void setAsk(JLabel a){
        Ask.ask = a;
    }
    
    void initAsk(Font f, boolean b){
        ask.setFont(f);
        ask.setText(MyBox.manyAsksResult[CommonFields.getI()]);
        ask.setBounds(50, 20, 600, 50);
        ask.setOpaque(b);
        ask.setBackground(Color.YELLOW);
        ask.setHorizontalAlignment(SwingConstants.CENTER);
        ask.setVerticalAlignment(SwingConstants.CENTER);
    }
}
