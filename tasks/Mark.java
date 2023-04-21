package com.kvv.quiz.tasks;

import javax.swing.JLabel;

/**
 * Отметка о правильном или неправильном ответе в заданиях уровня "Посложнее"
 * @author Kukushkin V.
 */
class Mark extends JLabel {   
    private static Mark mark = new Mark(true, 580, 490, 50, 50);
    
    static Mark getMark(){
        return mark;
    }
    
    static void setMark(Mark m){
        Mark.mark = m;
    }
    
    Mark(boolean flag, int x, int y, int w, int h){
        setBounds(x, y, w, h);
        setBackground(CommonFields.color);
        setOpaque(flag);
    }
    
    void initMark(/*Mark label, */boolean flag, int x, int y, int w, int h){
        mark/*label*/.setBounds(x, y, w, h);
        mark/*label*/.setBackground(CommonFields.color);
        mark/*label*/.setOpaque(flag);
    }
}