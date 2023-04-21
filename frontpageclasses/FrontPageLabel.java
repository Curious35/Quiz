package com.kvv.quiz.frontpageclasses;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Компоненты начальной страницы приложения
 * @author Kukushkin V.
 */
class FrontPageLabel extends JLabel {
    private static final String ONE_CB   = "1. Выберите раздел: ";
    private static final String TWO_CB   = "2. Выберите тему: ";
    private static final String THREE_CB = "3. Выберите степень сложности: ";
    private static final Font HEADLINE_TEXT = new Font("Arial", Font.BOLD, 18);
    private static final Font OTHER_TEXT    = new Font("Arial", Font.ITALIC, 14);
    
    private static FrontPageLabel head    = new FrontPageLabel("ВИКТОРИНА");
    private static FrontPageLabel chapter = new FrontPageLabel(ONE_CB);//r
    private static FrontPageLabel theme   = new FrontPageLabel(TWO_CB);
    private static FrontPageLabel ground  = new FrontPageLabel(THREE_CB);
    
    static FrontPageLabel getChapter(){
        return chapter;
    }
    
    static void setChapter(FrontPageLabel label){
        FrontPageLabel.chapter = label;
    }
    
    static FrontPageLabel getTheme(){
        return theme;
    }
    
    static void setTheme(FrontPageLabel label){
        FrontPageLabel.theme = label;
    }
    
    static FrontPageLabel getGround(){
        return ground;
    }
    
    static void setGround(FrontPageLabel label){
        FrontPageLabel.ground = label;
    }
    
    static FrontPageLabel getHead(){
        return head;
    }
    
    static void setHead(FrontPageLabel label){
        FrontPageLabel.head = label;
    }
    
    void initFrontPageLabel(FrontPageLabel la, int x, int y, int w, int h, boolean flag){
        la.setBounds(x, y, w, h);
        la.setBackground(Color.YELLOW);
        la.setOpaque(flag);
        if (la.equals(head)){
            la.setFont(HEADLINE_TEXT);
            la.setHorizontalAlignment(SwingConstants.CENTER);
        } else
            la.setFont(OTHER_TEXT);
        
    }
    
    FrontPageLabel(String s){
        setText(s);
    }
}
