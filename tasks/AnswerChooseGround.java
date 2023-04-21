package com.kvv.quiz.tasks;

import com.kvv.quiz.endwindow.Final;
import com.kvv.quiz.frontpageclasses.Comboboxes;
import com.kvv.quiz.frontpageclasses.FrontPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;

/**
 * Уровень попроще
 * @author Kukushkin V.
 */
public class AnswerChooseGround extends KeyAdapter implements ActionListener, Grounds {
    public static AnswerChooseGround mp = new AnswerChooseGround();
    private static int j = 0;
    private boolean flag = false;
    
    @Override
    public void goBack() {
        if (CommonFields.getI() == MyBox.manyAsksG1.length - 1)//i - текущий на момент нажатия на кнопку
            SwitchButtons.getNext().setEnabled(true);//next
        if (CommonFields.getI() > 0) {
            CommonFields.setI(CommonFields.getI() - 1);//Устанавливаем текущий номер вопроса после нажания на кнопку
            if (!MyBox.isWasPressed[CommonFields.getI()]){
                MakeRadioButton.buttonSetEnabled(true);
                MakeRadioButton.setBaseColor();
                MakeRadioButton.getBg().clearSelection();
            }
            if (MyBox.isWasPressed[CommonFields.getI()]){
                MakeRadioButton.useRememberColor(CommonFields.getI(), 0);
                MakeRadioButton.setSelectJRB();
                MakeRadioButton.buttonSetEnabled(false);
            }
            j = 0;
            MakeRadioButton.buttonSetText(CommonFields.getI(), j);
            Pictures.getPicture().setIcon(MyBox.picturesResult[CommonFields.getI()]);//pictureA
            Ask.getAsk().setText(MyBox.manyAsksResult[CommonFields.getI()]);
        }
        if (CommonFields.getI() == 0)
            SwitchButtons.getBack().setEnabled(false);//previous
        SwitchButtons.setupPopupHint(SwitchButtons.getBack(), SwitchButtons.getNext(), SwitchButtons.LEFT_ENABLED, SwitchButtons.RIGHT_ENABLED);
    }
    
    @Override
    public void goOn() {
        if (CommonFields.getI() == 0)
            SwitchButtons.getBack().setEnabled(true);//previous
        if (CommonFields.getI() < MyBox.manyAsksG1.length - 1) {
            CommonFields.setI(CommonFields.getI() + 1);
            if (!MyBox.isWasPressed[CommonFields.getI()]){//Если ни одна из кнопок выбора на тек. стр. не была нажата, то ...
                MakeRadioButton.buttonSetEnabled(true);
                MakeRadioButton.setBaseColor();
                MakeRadioButton.getBg().clearSelection();
            }
            if (MyBox.isWasPressed[CommonFields.getI()]){
                MakeRadioButton.useRememberColor(CommonFields.getI(), 0);
                MakeRadioButton.setSelectJRB();
                MakeRadioButton.buttonSetEnabled(false);
            }
            j = 0;
            MakeRadioButton.buttonSetText(CommonFields.getI(), j);
            Pictures.getPicture().setIcon(MyBox.picturesResult[CommonFields.getI()]);//pictureA
            Ask.getAsk().setText(MyBox.manyAsksResult[CommonFields.getI()]);
        }
        if (CommonFields.getI() == MyBox.manyAsksG1.length - 1)
            SwitchButtons.getNext().setEnabled(false);//nex
        SwitchButtons.setupPopupHint(SwitchButtons.getNext(), SwitchButtons.getBack(), SwitchButtons.RIGHT_ENABLED, SwitchButtons.LEFT_ENABLED);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT://Вернуться к предыдущей странице
                goBack();
                break;
            case KeyEvent.VK_RIGHT://На следующую страницу
                goOn();
                break;
            case KeyEvent.VK_UP://Перемещение вверх по кнопкам класса JRadioButton
                break;
            case KeyEvent.VK_DOWN://Перемещение вниз по кнопкам класса JRadioButton
                break;
            case KeyEvent.VK_ENTER://Выбор ответа
                break;
            default:
        }
    }

    /*
    ОБРАБОТКА НАЖАТИЯ МЫШЬЮ НА КНОПКУ КЛАССА JRadioButton
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MyBox.isWasPressed[CommonFields.getI()] = true;
        if (e.getActionCommand().equals(MyBox.answerResult[CommonFields.getI()])) {
            if (e.getSource() == MakeRadioButton.getOne())
                MakeRadioButton.getOne().setBackground(Color.GREEN);
            else if (e.getSource() == MakeRadioButton.getTwo())
                MakeRadioButton.getTwo().setBackground(Color.GREEN);
            else if (e.getSource() == MakeRadioButton.getThree())
                MakeRadioButton.getThree().setBackground(Color.GREEN);
            else if (e.getSource() == MakeRadioButton.getFour())
                MakeRadioButton.getFour().setBackground(Color.GREEN);
            CommonFields.setYes(CommonFields.getYes() + 1);
            CommonFields.setYesObj(CommonFields.getYes());
        }
        else {
            if (e.getSource() == MakeRadioButton.getOne())
                MakeRadioButton.getOne().setBackground(Color.RED);
            else if (e.getSource() == MakeRadioButton.getTwo())
                MakeRadioButton.getTwo().setBackground(Color.RED);
            else if (e.getSource() == MakeRadioButton.getThree())
                MakeRadioButton.getThree().setBackground(Color.RED);
            else if (e.getSource() == MakeRadioButton.getFour())
                MakeRadioButton.getFour().setBackground(Color.RED);
            CommonFields.setNot(CommonFields.getNot() + 1);
            CommonFields.setNotObj(CommonFields.getNot());
        }
        Counter.getCounter().setText(//MyBox.counter.setText
                "<html>" + "<font color = \"00ff00\">" + CommonFields.getYesObj().toString() + "</font>" +
                        " : " +
                "<font color = \"ff0000\">" + CommonFields.getNotObj().toString() + "</font>" + "</html>");
        MakeRadioButton.buttonSetEnabled(false);
        MakeRadioButton.paintRadioButton((JRadioButton) e.getSource(), CommonFields.getI(), 0);//fillRememberColor
        if (CommonFields.getYes() + CommonFields.getNot() == CommonFields.LENGTH) {
            Final.interfaceF();
            Final.getWin_final().setVisible(true);
        }
    }

    @Override
    public void buildInterface() {
        FrontPanel.getPanel().setBackground(Color.LIGHT_GRAY);
        new Ask().initAsk(new Font("Arial", Font.ITALIC, 17), true);
        new Pictures().initPicture(Comboboxes.LIGHT_G);
        MakeRadioButton.getOne().initRadioButton(MakeRadioButton.getOne(), MyBox.bufResult[0][0], 500, 150, 150, 40, false);
        MakeRadioButton.getTwo().initRadioButton(MakeRadioButton.getTwo(), MyBox.bufResult[0][1], 500, 200, 150, 40, false);
        MakeRadioButton.getThree().initRadioButton(MakeRadioButton.getThree(), MyBox.bufResult[0][2], 500, 250, 150, 40, false);
        MakeRadioButton.getFour().initRadioButton(MakeRadioButton.getFour(), MyBox.bufResult[0][3], 500, 300, 150, 40, false);
        new Counter().InitCounter(Counter.getCounter());
        SwitchButtons.getNext().initSwitchButton(SwitchButtons.getNext(), CommonFields.NEXT, true, 500, 550, 100, 40);
        SwitchButtons.getBack().initSwitchButton(SwitchButtons.getBack(), CommonFields.BACK, false, 100, 550, 100, 40);
        FrontPanel.getPanel().add(Ask.getAsk());//ask
        FrontPanel.getPanel().add(Pictures.getPicture());//pictureA
        FrontPanel.getPanel().add(MakeRadioButton.getOne());
        FrontPanel.getPanel().add(MakeRadioButton.getTwo());
        FrontPanel.getPanel().add(MakeRadioButton.getThree());
        FrontPanel.getPanel().add(MakeRadioButton.getFour());
        FrontPanel.getPanel().add(SwitchButtons.getBack());//previous
        FrontPanel.getPanel().add(Counter.getCounter());//MyBox.counter
        FrontPanel.getPanel().add(SwitchButtons.getNext());//next
        if (MyBox.isWasPressed[0]) {
            MakeRadioButton.setSelectJRB();
            MakeRadioButton.buttonSetEnabled(false);
        } else {
            MakeRadioButton.buttonSetEnabled(true);
            MakeRadioButton.getOne().setSelected(false);
            MakeRadioButton.getTwo().setSelected(false);
            MakeRadioButton.getThree().setSelected(false);
            MakeRadioButton.getFour().setSelected(false);//ЭТО СВОЙСТВО НЕСМОТРЯ НА МЕТОД ВСЁ РАВНО ПОЧЕМУ-ТО true
        }
        MakeRadioButton.useRememberColor(0, 0);
        if (!flag) {
            SwitchButtons.getBack().addActionListener(e -> {//i - номер вопроса, previous
                goBack();
            });
            SwitchButtons.getNext().addActionListener(e -> {//next
                goOn();
            });
            MakeRadioButton.getOne().addActionListener(this);
            MakeRadioButton.getTwo().addActionListener(this);
            MakeRadioButton.getThree().addActionListener(this);
            MakeRadioButton.getFour().addActionListener(this);
            MakeRadioButton.getOne().addKeyListener(this);
            SwitchButtons.getNext().addKeyListener(this);//next
            SwitchButtons.getBack().addKeyListener(this);//previous
            flag = true;
        }
    }
}
