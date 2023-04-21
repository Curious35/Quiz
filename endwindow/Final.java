package com.kvv.quiz.endwindow;

import com.kvv.quiz.frontpageclasses.FrontPanel;
import com.kvv.quiz.frontpageclasses.Quiz;
import com.kvv.quiz.tasks.CommonFields;
import com.kvv.quiz.tasks.Counter;
import com.kvv.quiz.tasks.MyBox;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 * Заключительное окно с оценкой за выполненное задание
 * @author Kukushkin V.
 */
public class Final implements ActionListener {
    private static final int WINDOW_WIDTH = 600, WINDOW_HEIGHT = 565;
    private static final String ONE   = "1";
    private static final String TWO   = "2";
    private static final String THREE = "3";
    private static final String FOUR  = "4";
    private static final String FIVE  = "5";
    private static final String PUSTO = "";
    private static final String OUR_MARK = "Ваша оценка: ";
    private static JFrame win_final = new JFrame("Итоги");
    private static JPanel panel = new JPanel();
    private static JLabel headLine = new JLabel("Итоги");
    private static JLabel stat = new JLabel();
    private static JLabel t0 = new JLabel();
    private static JLabel mark = new JLabel();
    private static JLabel t1 = new JLabel(), t2 = new JLabel();
    private static JButton update = new JButton("Выбрать новое задание");
    private static Font gigant = new Font("Arial", Font.ITALIC, 70);
    private static Font textButton = new Font("Arial", Font.ITALIC, 14);
    private static Font head = new Font("Arial", Font.ITALIC, 22);
    private static Font speech = new Font("Arial", Font.ITALIC, 18);
    private static String text = "";
    private static Color color1 = new Color(255, 255, 100);
    private static String[] s = {
            "Очень печально...", "Не ожидал такого результата от Вас...",
            "Неудовлетворительный итог.", "Не отчаивайтесь, бывает и хуже, но реже.",
            "Удовлетворительно, но не хорошо.",
            "Хорошо, но не расслабляйтесь.", "Обратите внимание на допущенные ошибки.",
            "Молодчина! Так держать!"};

    public static JFrame getWin_final() {
        return win_final;
    }

    public Final() {
        win_final.setDefaultCloseOperation(HIDE_ON_CLOSE);
        win_final.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        win_final.setResizable(false);
        win_final.setLayout(null);
        win_final.add(panel);
        win_final.revalidate();
        win_final.repaint();
        win_final.setVisible(true);
        panel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panel.setBackground(color1);
        panel.setLayout(null);
        interfaceF();
        addListeners();
    }

    public static void interfaceF() {
        headLine.setFont(head);
        headLine.setBounds(50, 20, 500, 50);
        headLine.setOpaque(true);
        headLine.setBackground(color1);
        headLine.setHorizontalAlignment(SwingConstants.CENTER);
        headLine.setVerticalAlignment(SwingConstants.CENTER);

        stat.setOpaque(true);
        stat.setBackground(color1);
        stat.setFont(speech);
        switch (CommonFields.getYes()) {
            case 0: case 5: case 6: case 7: case 8: case 9: case 10:
                text = "ов";
                break;
            case 2: case 3: case 4:
                text = "а";
                break;
            default:
        }
        stat.setText("Вы правильно ответили на " + CommonFields.getYes() + " вопрос" + text + " из " + CommonFields.LENGTH + ".");
        stat.setBounds(50, 100, 500, 50);
        stat.setHorizontalAlignment(SwingConstants.CENTER);
        stat.setVerticalAlignment(SwingConstants.CENTER);

        t0.setOpaque(true);
        t0.setBackground(color1);
        t0.setFont(speech);
        t0.setText(OUR_MARK);
        t0.setBounds(105, 160, 200, 48);
        t0.setHorizontalAlignment(SwingConstants.LEFT);
        t0.setVerticalAlignment(SwingConstants.CENTER);

        mark.setOpaque(true);
        mark.setBounds(275, 210, 50, 110);
        mark.setBackground(color1);
        mark.setHorizontalAlignment(SwingConstants.CENTER);
        mark.setVerticalAlignment(SwingConstants.CENTER);
        mark.setFont(gigant);
        if (CommonFields.getYes() < 2) {
            mark.setText(ONE);
            mark.setForeground(Color.BLACK);
            t1.setText(s[0]);
            t2.setText(s[1]);
        } else if ((CommonFields.getYes() >= 2) && (CommonFields.getYes() < 5)) {
            mark.setText(TWO);
            mark.setForeground(Color.GRAY);
            t1.setText(s[2]);
            t2.setText(s[3]);
        } else if ((CommonFields.getYes() >= 5) && (CommonFields.getYes() < 7)) {
            mark.setText(THREE);
            mark.setForeground(Color.BLUE);
            t1.setText(s[4]);
            t2.setText("");
        } else if ((CommonFields.getYes() >= 7) && (CommonFields.getYes() < 9)) {
            mark.setText(FOUR);
            mark.setForeground(Color.GREEN);
            t1.setText(s[5]);
            t2.setText(s[6]);
        } else {
            mark.setText(FIVE);
            mark.setForeground(Color.RED);
            t1.setText(s[7]);
            t2.setText(PUSTO);
        }

        t1.setOpaque(true);
        t1.setBackground(color1);
        t1.setFont(speech);
        t1.setBounds(10, 330, 550, 40);
        t1.setHorizontalAlignment(SwingConstants.CENTER);
        t1.setVerticalAlignment(SwingConstants.CENTER);

        t2.setOpaque(true);
        t2.setBackground(color1);
        t2.setFont(speech);
        t2.setBounds(10, 372, 550, 40);
        t2.setHorizontalAlignment(SwingConstants.CENTER);
        t2.setVerticalAlignment(SwingConstants.CENTER);

        update.setFont(textButton);
        update.setBounds(200, 440, 200, 40);
        update.setEnabled(true);
        panel.add(headLine);
        panel.add(stat);
        panel.add(t0);
        panel.add(mark);
        panel.add(t1);
        panel.add(t2);
        panel.add(update);
        panel.revalidate();
        panel.repaint();
    }

    private void addListeners() {
        update.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(update)) {
            FrontPanel.getPanel().removeAll();
            FrontPanel.getPanel().repaint();
            CommonFields.setI(CommonFields.ZERO);
            CommonFields.setYes(CommonFields.ZERO);
            CommonFields.setYesObj(CommonFields.getYes());
            CommonFields.setNot(CommonFields.ZERO);
            CommonFields.setNotObj(CommonFields.getNot());
            Counter.getCounter().setText(
                    "<html>" + "<font color = \"00ff00\">" + CommonFields.getYesObj().toString() + "</font>" +
                            " : " +
                            "<font color = \"ff0000\">" + CommonFields.getNotObj().toString() + "</font>" + "</html>");
            MyBox.initMasResults();
            Quiz.initialWindow();
            win_final.setVisible(false);
            FrontPanel.getPanel().setVisible(true);
        }
    }
}
