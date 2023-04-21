package com.kvv.quiz.develop;

/**
 * Список сохранённых попыток
 * @author Kukushkin V.
 */
import com.kvv.quiz.tasks.CommonFields;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.awt.Color.BLACK;

public class Journal {
    private static final int WINDOW_WIDTH = 700, WINDOW_HEIGHT = 500;
    private static JFrame frameGournal = new JFrame("Сохранённые попытки");
    private static JPanel panelGournal = new JPanel();
    private static ImageIcon cross = new ImageIcon(CommonFields.PATH_PHOTO + "Redcross_B.png");
    private static JLabel delete = new JLabel(cross);
    private static int count = 0;

    /*
    Методы
     */
    public static JFrame getFrameJournal() {
        return frameGournal;
    }

    public static JPanel getPanelJournal() {
        return panelGournal;
    }

    public static int getCount() {
        return count;
    }

    static void setCount(int count) {
        Journal.count = count;
    }

    public Journal() {
        frameGournal.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frameGournal.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        panelGournal.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frameGournal.add(panelGournal);
        frameGournal.setResizable(false);
        frameGournal.setLayout(null);
        frameGournal.setVisible(true);
        panelGournal.setLayout(null);
        panelGournal.setBackground(BLACK);
        panelGournal.setVisible(true);
    }

    public static void makeGP(){
        int k = 0;
        CommonFields.labels.add(new MyJLabel(count, k, "Раздел: " + CommonFields.textR));
        k++;
        CommonFields.labels.add(new MyJLabel(count, k, "Тема: " + CommonFields.textT));
        k++;
        CommonFields.labels.add(new MyJLabel(count, k, "Уровень: " + CommonFields.textG));
        CommonFields.buttons.add(new MyJButton(count));//КНОПКА "ПРОДОЛЖИТЬ ПОПЫТКУ"
        CommonFields.objects.add(new MyJPanels(count));//НОВАЯ ПАНЕЛЬ
        panelGournal.add(CommonFields.objects.get(count));
        count++;//ПОРЯДКОВЫЙ НОМЕР ПАНЕЛИ
    }

    public static void reconstruction() {
        for (int i = 0; i < count; i++) {
            try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "/src/SaveGournalInterface"))){
                String s = br.readLine();
                int k = 0;
                while ((s != null) && (k < 3)) {
                    CommonFields.labels.add(new MyJLabel(i, k, s));
                    k++;
                    s = br.readLine();
                }
            } catch (IOException ex) {
                System.out.println("ОШИБКА В MyGournal.reconstruction(): " + ex.getMessage());
            }
            CommonFields.buttons.add(new MyJButton(i));
            CommonFields.objects.add(new MyJPanels(i));
            panelGournal.add(CommonFields.objects.get(i));
        }
        panelGournal.repaint();
    }
}
