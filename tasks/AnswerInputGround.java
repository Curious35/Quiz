package com.kvv.quiz.tasks;

import com.kvv.quiz.endwindow.Final;
import com.kvv.quiz.frontpageclasses.Comboboxes;
import com.kvv.quiz.frontpageclasses.FrontPanel;
import static com.kvv.quiz.tasks.SwitchButtons.RIGHT_ENABLED;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

/**
 * Уровень посложнее
 * @author Kukushkin V.
 */
public class AnswerInputGround implements KeyListener, Grounds {
    public static AnswerInputGround msg = new AnswerInputGround();

    private static ImageIcon RED_CROSS  = new ImageIcon(CommonFields.PATH_PHOTO + "Redcross_B.png");
    private static ImageIcon GREEN_MARK = new ImageIcon(CommonFields.PATH_PHOTO + "GreenMark_B.png");
    private boolean flag = false;
    
    @Override
    public void goBack() {
        if (CommonFields.getI() == MyBox.manyAsksResult.length - 1)//i - текущий на момент нажатия на кнопку
            SwitchButtons.getNext().setEnabled(true);//next
        if (CommonFields.getI() > 0) {
            CommonFields.setI(CommonFields.getI() - 1);//Устанавливаем текущий номер вопроса после нажания на кнопку
            if (!MyBox.isWasPressed[CommonFields.getI()]){
                MakeTextField.getMakeTextField().setEditable(true);
                Mark.getMark().setVisible(false);
            }
            if (MyBox.isWasPressed[CommonFields.getI()] && CommonFields.answerUser[CommonFields.getI()].equalsIgnoreCase(MyBox.answerResult[CommonFields.getI()])){
                Mark.getMark().setIcon(GREEN_MARK);
                Mark.getMark().setVisible(true);
                MakeTextField.getMakeTextField().setEditable(false);
            }
            else if (MyBox.isWasPressed[CommonFields.getI()] && !CommonFields.answerUser[CommonFields.getI()].equalsIgnoreCase(MyBox.answerResult[CommonFields.getI()])) {
                Mark.getMark().setIcon(RED_CROSS);
                Mark.getMark().setVisible(true);
                MakeTextField.getMakeTextField().setEditable(false);
            }
            Pictures.getPicture().setIcon(MyBox.picturesResult[CommonFields.getI()]);//pictureB
            Ask.getAsk().setText(MyBox.manyAsksResult[CommonFields.getI()]);//вопрос
            MakeTextField.getMakeTextField().setText(CommonFields.answerUser[CommonFields.getI()]);//ответ игрока в строке ввода
        }
        if (CommonFields.getI() == 0)
            SwitchButtons.getBack().setEnabled(false);//previous
        SwitchButtons.setupPopupHint(SwitchButtons.getBack(), SwitchButtons.getNext(), SwitchButtons.LEFT_ENABLED, SwitchButtons.RIGHT_ENABLED);
        MakeTextField.setupPopupHint(MakeTextField.getMakeTextField(), MakeTextField.FIELD_EDIT);
    }
    
    @Override
    public void goOn() {
        if (CommonFields.getI() == 0)
            SwitchButtons.getBack().setEnabled(true);//previous
        if (CommonFields.getI() < MyBox.manyAsksResult.length - 1) {
            CommonFields.setI(CommonFields.getI() + 1);
            if (!MyBox.isWasPressed[CommonFields.getI()]){
                MakeTextField.getMakeTextField().setEditable(true);
                MakeTextField.getMakeTextField().requestFocus();
                Mark.getMark().setVisible(false);
            }
            if (MyBox.isWasPressed[CommonFields.getI()] && CommonFields.answerUser[CommonFields.getI()].equalsIgnoreCase(MyBox.answerResult[CommonFields.getI()])){
                Mark.getMark().setIcon(GREEN_MARK);
                Mark.getMark().setVisible(true);
                MakeTextField.getMakeTextField().setEditable(false);
            }
            else if (MyBox.isWasPressed[CommonFields.getI()] && !CommonFields.answerUser[CommonFields.getI()].equalsIgnoreCase(MyBox.answerResult[CommonFields.getI()])) {
                Mark.getMark().setIcon(RED_CROSS);
                Mark.getMark().setVisible(true);
                MakeTextField.getMakeTextField().setEditable(false);
            }
            Pictures.getPicture().setIcon(MyBox.picturesResult[CommonFields.getI()]);//pictureB
            Ask.getAsk().setText(MyBox.manyAsksResult[CommonFields.getI()]);
            MakeTextField.getMakeTextField().setText(CommonFields.answerUser[CommonFields.getI()]);
        }
        if (CommonFields.getI() == MyBox.manyAsksResult.length - 1)
            SwitchButtons.getNext().setEnabled(false);//next
        SwitchButtons.setupPopupHint(SwitchButtons.getNext(), SwitchButtons.getBack(), SwitchButtons.RIGHT_ENABLED, SwitchButtons.LEFT_ENABLED);
        MakeTextField.setupPopupHint(MakeTextField.getMakeTextField(), MakeTextField.FIELD_EDIT);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    /*
    НАЖАТИЕ НА КЛАВИШИ ENTER, LEFT, RIGHT
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (!MyBox.isWasPressed[CommonFields.getI()] && (!MakeTextField.getMakeTextField().getText().equals(""))) {
                    if (MakeTextField.getMakeTextField().getText().equalsIgnoreCase(MyBox.answerResult[CommonFields.getI()])) {
                        MyBox.isRightResult[CommonFields.getI()] = true;
                        Mark.getMark().setIcon(GREEN_MARK);
                        Mark.getMark().setVisible(true);
                        CommonFields.setYes(CommonFields.getYes() + 1);
                        CommonFields.setYesObj(CommonFields.getYes());
                    } else {
                        MyBox.isRightResult[CommonFields.getI()] = false;
                        Mark.getMark().setIcon(RED_CROSS);
                        Mark.getMark().setVisible(true);
                        CommonFields.setNot(CommonFields.getNot() + 1);
                        CommonFields.setNotObj(CommonFields.getNot());
                    }
                    Counter.getCounter().setText(//MyBox.counter.setText
                            "<html>" + "<font color = \"00ff00\">" + CommonFields.getYesObj().toString() + "</font>" +
                                    " : " +
                            "<font color = \"ff0000\">" + CommonFields.getNotObj().toString() + "</font>" + "</html>");
                    CommonFields.answerUser[CommonFields.getI()] = MakeTextField.getMakeTextField().getText();
                    MakeTextField.getMakeTextField().setEditable(false);
                    MyBox.isWasPressed[CommonFields.getI()] = true;
                    if (CommonFields.getYes() + CommonFields.getNot() == CommonFields.LENGTH) {
                        Final.interfaceF();
                        Final.getWin_final().setVisible(true);
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                goBack();
                break;
            case KeyEvent.VK_RIGHT:
                goOn();
                break;
            default:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void buildInterface() {
        new Ask().initAsk(new Font("Arial", Font.ITALIC, 17), false);
        new Pictures().initPicture(Comboboxes.HARD_G);
        MakeTextField.getMakeTextField().initTextField(50, 150, 500, 400, 30);
        Mark.getMark().initMark(/*Mark.getMark(), */true, 580, 490, 50, 50);
        new Counter().InitCounter(Counter.getCounter());
        SwitchButtons.getNext().initSwitchButton(SwitchButtons.getNext(), CommonFields.NEXT, true, 500, 550, 100, 40);
        SwitchButtons.getBack().initSwitchButton(SwitchButtons.getBack(), CommonFields.BACK, false, 100, 550, 100, 40);
        FrontPanel.getPanel().add(Ask.getAsk());//ask
        FrontPanel.getPanel().add(Pictures.getPicture());//pictureB
        FrontPanel.getPanel().add(MakeTextField.getMakeTextField());
        FrontPanel.getPanel().add(Mark.getMark());
        FrontPanel.getPanel().add(Counter.getCounter());//MyBox.counter
        FrontPanel.getPanel().add(SwitchButtons.getBack());//previous
        FrontPanel.getPanel().add(SwitchButtons.getNext());//next
        if (SwitchButtons.getNext().isEnabled())
            SwitchButtons.getNext().setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + RIGHT_ENABLED + "</font>" + "</html>");
        if (MyBox.isWasPressed[CommonFields.getI()]) {
            MakeTextField.getMakeTextField().setText(CommonFields.answerUser[CommonFields.getI()]);
            MakeTextField.getMakeTextField().setEditable(false);
            if (MyBox.isRightResult[CommonFields.getI()])
                Mark.getMark().setIcon(GREEN_MARK);
            else
                Mark.getMark().setIcon(RED_CROSS);
            Mark.getMark().setVisible(true);
        } else {
            MakeTextField.getMakeTextField().setEditable(true);
            MakeTextField.getMakeTextField().setText("");
            MakeTextField.getMakeTextField().requestFocus();
            Mark.getMark().setVisible(false);
        }
        if (!flag) {
            SwitchButtons.getBack().addActionListener(e -> {
                goBack();
            });
            SwitchButtons.getNext().addActionListener(e -> {
                goOn();
            });
            MakeTextField.getMakeTextField().addKeyListener(this);
            SwitchButtons.getBack().addKeyListener(this);//previous
            SwitchButtons.getNext().addKeyListener(this);//next
            flag = true;
        }
    }
}
