package com.kvv.quiz.tasks;

import com.kvv.quiz.frontpageclasses.Comboboxes;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Изображения для обоих уровней сложности
 * @author Kukushkin V.
 */
class Pictures {
    private static final int MAX_HOR_VALUE = 450;
    private static final int MAX_VERT_VALUE = 400;
    private static JLabel picture = new JLabel(MyBox.picturesResult[CommonFields.getI()]);
    
    static JLabel getPicture(){
        return picture;
    }
    
    static void setPicture(JLabel p){
        Pictures.picture = p;
    }
    
    void initPicture(String gr){
        picture.setIcon(MyBox.picturesResult[CommonFields.getI()]);
        picture.setVerticalAlignment(SwingConstants.TOP);
        picture.setLocation(20, 100);
        if (gr.equals(Comboboxes.HARD_G))
            picture.setSize(MyBox.picturesResult[CommonFields.getI()].getIconWidth(), MyBox.picturesResult[CommonFields.getI()].getIconHeight());
        else {        
            picture.setSize(MAX_HOR_VALUE, MAX_VERT_VALUE);
            picture.setOpaque(true);
            picture.setBackground(Color.LIGHT_GRAY);
        }
    }
}
