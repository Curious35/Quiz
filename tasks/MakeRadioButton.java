package com.kvv.quiz.tasks;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 * Кнопки выбора варианта ответа для заданий уровня "Попроще"
 * @author Kukushkin V.
 */
class MakeRadioButton extends JRadioButton {
    private static ButtonGroup bg = new ButtonGroup();
    
    private static MakeRadioButton one   = new MakeRadioButton();
    private static MakeRadioButton two   = new MakeRadioButton();
    private static MakeRadioButton three = new MakeRadioButton();
    private static MakeRadioButton four  = new MakeRadioButton();
    
    static ButtonGroup getBg(){
        return bg;
    }
    
    static void setBg(ButtonGroup bg){
        MakeRadioButton.bg = bg;
    }
    
    static MakeRadioButton getOne(){
        return one;
    }
    
    static void setOne(MakeRadioButton rb){
        MakeRadioButton.one = rb;
    }
    
    static MakeRadioButton getTwo(){
        return two;
    }
    
    static void setTwo(MakeRadioButton rb){
        MakeRadioButton.two = rb;
    }
    
    static MakeRadioButton getThree(){
        return three;
    }
    
    static void setThree(MakeRadioButton rb){
        MakeRadioButton.three = rb;
    }
    
    static MakeRadioButton getFour(){
        return four;
    }
    
    static void setFour(MakeRadioButton rb){
        MakeRadioButton.four = rb;
    }
    
    void initRadioButton(JRadioButton jrb, String s, int x, int y, int w, int h, boolean flag){
        jrb.setSelected(flag);
        jrb.setText(s);
        jrb.setFont(SwitchButtons.getTEXT_BUTTON());
        jrb.setBounds(x, y, w, h);
        bg.add(jrb);
    }
    
    static void buttonSetEnabled(boolean flag){
        one.setEnabled(flag);
        two.setEnabled(flag);
        three.setEnabled(flag);
        four.setEnabled(flag);
    }
    
    static void buttonSetText(int k, int m){
        one.setText(MyBox.bufResult[k][m]);
        two.setText(MyBox.bufResult[k][++m]);
        three.setText(MyBox.bufResult[k][++m]);
        four.setText(MyBox.bufResult[k][++m]);
    }
    
    static void setSelectJRB() {
        int buf = 0;
        while (MyBox.rememberColor[CommonFields.getI()][buf] == CommonFields.getBaseColor())
            buf++;
        switch (buf) {
            case 0:
                one.setSelected(true);
                break;
            case 1:
                two.setSelected(true);
                break;
            case 2:
                three.setSelected(true);
                break;
            case 3:
                four.setSelected(true);
                break;
            default:
                break;
        }
    }
    
    static void setBaseColor(){
        if (one.getBackground() != CommonFields.getBaseColor())//Рассмотреть вариант с if (...) else ...
            one.setBackground(CommonFields.getBaseColor());
        if (two.getBackground() != CommonFields.getBaseColor())
            two.setBackground(CommonFields.getBaseColor());
        if (three.getBackground() != CommonFields.getBaseColor())
            three.setBackground(CommonFields.getBaseColor());
        if (four.getBackground() != CommonFields.getBaseColor())
            four.setBackground(CommonFields.getBaseColor());
    }
    
    static void useRememberColor(int k, int m){
        one.setBackground(MyBox.rememberColor[k][m]);
        two.setBackground(MyBox.rememberColor[k][++m]);
        three.setBackground(MyBox.rememberColor[k][++m]);
        four.setBackground(MyBox.rememberColor[k][++m]);
    }
    
    static void paintRadioButton(JRadioButton jrb, int k, int m){
        if (jrb == MakeRadioButton.getOne()) {
            MyBox.rememberColor[k][m]   = one.getBackground();
            MyBox.rememberColor[k][++m] = CommonFields.getBaseColor();
            MyBox.rememberColor[k][++m] = CommonFields.getBaseColor();
            MyBox.rememberColor[k][++m] = CommonFields.getBaseColor();
        } else if (jrb == MakeRadioButton.getTwo()){
            MyBox.rememberColor[k][m]   = CommonFields.getBaseColor();
            MyBox.rememberColor[k][++m] = two.getBackground();
            MyBox.rememberColor[k][++m] = CommonFields.getBaseColor();
            MyBox.rememberColor[k][++m] = CommonFields.getBaseColor();
        } else if (jrb == MakeRadioButton.getThree()){
            MyBox.rememberColor[k][m]   = CommonFields.getBaseColor();
            MyBox.rememberColor[k][++m] = CommonFields.getBaseColor();
            MyBox.rememberColor[k][++m] = three.getBackground();
            MyBox.rememberColor[k][++m] = CommonFields.getBaseColor();
        } else if (jrb == MakeRadioButton.getFour()){
            MyBox.rememberColor[k][m]   = CommonFields.getBaseColor();
            MyBox.rememberColor[k][++m] = CommonFields.getBaseColor();
            MyBox.rememberColor[k][++m] = CommonFields.getBaseColor();
            MyBox.rememberColor[k][++m] = four.getBackground();
        }
    }
}