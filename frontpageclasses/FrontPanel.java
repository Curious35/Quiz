package com.kvv.quiz.frontpageclasses;

import com.kvv.quiz.tasks.CommonFields;
import javax.swing.JPanel;

/**
 * Панель, накладываемая на фрейм главного окна
 * @author Kukushkin V.
 */
public class FrontPanel extends JPanel {
    private static FrontPanel panel = new FrontPanel();
    
    public static FrontPanel getPanel(){
        return panel;
    }
    
    public static void setPanel(FrontPanel p){
        FrontPanel.panel = p;
    }
    
    void initFrontPanel(FrontPanel p){
        p.setBackground(CommonFields.color);        
        p.add(FrontPageLabel.getHead());
        p.add(FrontPageLabel.getChapter());
        p.add(Comboboxes.CHAPTER);
        p.add(FrontPageLabel.getTheme());
        p.add(Comboboxes.THEME);
        p.add(FrontPageLabel.getGround());
        p.add(Comboboxes.GROUND);
        p.add(ReadyButton.getReady());
        p.revalidate();
        p.repaint();
    }
}