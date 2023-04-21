package com.kvv.quiz.tasks;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Счётчик верных и ошибочных ответов на вопросы
 * @author Kukushkin V.
 */
public class Counter {
    private static JLabel counter = new JLabel(
    "<html>" + "<font color = \"00ff00\">" + CommonFields.getYesObj().toString() + "</font>" +
            " : " +
        "<font color = \"ff0000\">" + CommonFields.getNotObj().toString() + "</font>" + "</html>");
    
    public static JLabel getCounter(){
        return counter;
    }
    
    public static void setCounter(JLabel c){
        Counter.counter = c;
    }
    
    void InitCounter(JLabel c){
        c.setBounds(300, 550, 100, 70);
        c.setOpaque(true);//Делаем компонент JLabel непрозрачным
        c.setBackground(Color.YELLOW);
        c.setHorizontalAlignment(SwingConstants.CENTER);//Размещение текста по центру
        c.setVerticalAlignment(SwingConstants.CENTER);
        c.setFont(new Font("Arial", Font.ITALIC, 17));
    }
}
