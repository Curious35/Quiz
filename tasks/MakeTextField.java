package com.kvv.quiz.tasks;

import javax.swing.JTextField;

/**
 * Поле ввода ответа для заданий уровня "Посложнее"
 * @author Kukushkin V.
 */
class MakeTextField extends JTextField {
    static final String FIELD_EDIT = "Ответив, нажмите ENTER";
    
    private static MakeTextField tf = new MakeTextField();//50
    
    static MakeTextField getMakeTextField(){
        return tf;
    }
    
    static void setMakeTextField(MakeTextField mtf){
        MakeTextField.tf = mtf;
    }
    
    void initTextField(int c, int x, int y, int w, int h){
        tf.setColumns(c);
        tf.setBounds(x, y, w, h);
        if (tf.isEditable())
            tf.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + FIELD_EDIT + "</font>" + "</html>");
    }
    
    static void setupPopupHint(MakeTextField obj, String s){
        if (obj.isEditable())
            obj.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + s + "</font>" + "</html>");
        else
            obj.setToolTipText(null);
    }
}
