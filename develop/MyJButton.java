package com.kvv.quiz.develop;

/**
 *
 * @author Kukushkin V.
 */
import com.kvv.quiz.tasks.CommonFields;
import com.kvv.quiz.tasks.MyBox;
import com.kvv.quiz.tasks.Counter;
import com.kvv.quiz.frontpageclasses.Comboboxes;
import com.kvv.quiz.tasks.AnswerChooseGround;
import com.kvv.quiz.tasks.AnswerInputGround;
import com.kvv.quiz.frontpageclasses.FrontPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyJButton extends JButton implements ActionListener {
    MyJButton(int formI) {
        setBounds(450, (formI + 1)*MyJPanels.getHEIGHT_PANEL() - 100, 200, 50);
        setBackground(java.awt.Color.ORANGE);
        setFont(new Font("Arial", Font.PLAIN, 14));
        setText("Продолжить попытку");
        addActionListener(this);
    }

    /*
    ОБРАБОТКА НАЖАТИЯ НА КНОПКУ "ПРОДОЛЖИТЬ ПОПЫТКУ"
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int i = 0;
        while (CommonFields.buttons.get(i) != e.getSource())//ИЩЕМ КНОПКУ, НА КОТОРУЮ НАЖАЛИ equals()
                i++;
        //ВОПРОСЫ
        try(FileReader fr = new FileReader(CommonFields.PATH_PROJECT + "src/ManyAsksResult");
            BufferedReader br = new BufferedReader(fr)){
            String s = "";
            int j = 0, k = 0;
            while (k != i) {
                do {
                    s = br.readLine();
                } while (!s.equals(CommonFields.GUARD) && (s != null));//УСЛОВИЕ ПРОДОЛЖЕНИЯ ЦИКЛА, СЧИТЫВАНИЕ ПОГРАНИЧНИКА
                if (s.equals(CommonFields.GUARD))
                    k++;
                else {
                    k = i;
                    System.out.println("ФАЙЛ НЕОЖИДАННО КОНЧИЛСЯ");
                }
            }
            s = br.readLine();//СЛЕДУЮЩАЯ ЗА ПОГРАНИЧНИКОМ СТРОКА
            while ((j < CommonFields.LENGTH) && (s != null)) {
                MyBox.manyAsksResult[j] = s;
                System.out.println("Вопрос, записываемый в массив: " + MyBox.manyAsksResult[j]);
                j++;
                s = br.readLine();//СЧИТЫВАЕМ СЛЕДУЮЩУЮ СТРОКУ
            }
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println("ОШИБКА R1: " + ex.getMessage());
        }

        //БЫЛ ЛИ ДАН ОТВЕТ
        try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "src/IsWasPressed"))){
            String s = "";
            int j = 0, k = 0;
            while (k != i) {
                do {
                    s = br.readLine();
                } while (!s.equals(CommonFields.GUARD) && (s != null));
                if (s.equals(CommonFields.GUARD))
                    k++;
                else {
                    k = i;
                    System.out.println("ФАЙЛ НЕОЖИДАННО КОНЧИЛСЯ");
                }
            }
            s = br.readLine();
            while ((j < CommonFields.LENGTH) && (s != null)) {
                if (s.equals("true"))
                    MyBox.isWasPressed[j] = true;
                else
                    MyBox.isWasPressed[j] = false;
                j++;
                s = br.readLine();
            }
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println("ОШИБКА R2: " + ex.getMessage());
        }

        //ПРАВИЛЬНЫЕ ОТВЕТЫ
        try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "src/AnswerResult"))){
            String s3 = "";
            int j = 0, k = 0;
            while (k != i) {
                do {
                    s3 = br.readLine();
                } while(!s3.equals(CommonFields.GUARD) && (s3 != null));
                if (s3.equals(CommonFields.GUARD))
                    k++;
                else {
                    k = i;
                    System.out.println("ФАЙЛ НЕОЖИДАННО КОНЧИЛСЯ");
                }
            }
            s3 = br.readLine();
            while ((j < CommonFields.LENGTH) && (s3 != null)) {
                MyBox.answerResult[j] = s3;
                j++;
                s3 = br.readLine();
            }
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println("ОШИБКА R3: " + ex.getMessage());
        }

        //ПУТИ К КАРТИНКАМ
        try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "src/PathPicturesResult"))){
            String s = "";
            int j = 0, k = 0;
            while (k != i) {
                do {
                    s = br.readLine();
                } while (!s.equals(CommonFields.GUARD) && (s != null));
                if (s.equals(CommonFields.GUARD))
                    k++;
                else {
                    k = i;
                    System.out.println("ФАЙЛ НЕОЖИДАННО КОНЧИЛСЯ");
                }
            }
            s = br.readLine();
            while ((j < CommonFields.LENGTH) && (s != null)) {
                MyBox.pathResult[j] = s;
                j++;
                s = br.readLine();
            }
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println("ОШИБКА R4: " + ex.getMessage());
        }

        //СЧИТЫВАЕМ ПОКАЗАНИЯ СЧЁТЧИКА
        try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "src/PastCounters"))){
            String s = "";
            int k = 0;
            while (k != i) {
                do {
                    s = br.readLine();
                } while (!s.equals(CommonFields.GUARD) && (s != null));//УСЛОВИЕ ПРОДОЛЖЕНИЯ ЦИКЛА, СЧИТЫВАНИЕ ПОГРАНИЧНИКА
                if (s.equals(CommonFields.GUARD))
                    k++;
                else {
                    k = i;
                    System.out.println("ФАЙЛ НЕОЖИДАННО КОНЧИЛСЯ");
                }
            }
            s = br.readLine();//СЛЕДУЮЩАЯ ЗА ПОГРАНИЧНИКОМ СТРОКА
            if (s != null) {
                CommonFields.setYes(Integer.parseInt(s));
                CommonFields.setYesObj(Integer.valueOf(s));
            }
            s = br.readLine();
            if (s != null) {
                CommonFields.setNot(Integer.parseInt(s));
                CommonFields.setNotObj(Integer.valueOf(s));
            }
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println("ОШИБКА R5: " + ex.getMessage());
        }

        //WriterReader.Reader();
        if (CommonFields.labels.get(3*i + 2).getText().equals("Уровень: " + Comboboxes.groundT[0])) {
            //ТЕСТОВЫЕ ВАРИАНТЫ ОТВЕТА
            try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "src/BufResult"))){
                String s = "";
                int j = 0, k1 = 0, k = 0;
                while (k != i) {
                    do {
                        s = br.readLine();
                    } while (!s.equals(CommonFields.GUARD) && (s != null));
                    if (s.equals(CommonFields.GUARD))
                        k++;
                    else {
                        k = i;
                        System.out.println("ФАЙЛ НЕОЖИДАННО КОНЧИЛСЯ");
                    }
                }
                s = br.readLine();
                while (j < CommonFields.LENGTH) {
                    while ((k1 < 4) && (s != null)) {
                        MyBox.bufResult[j][k1] = s;
                        k1++;
                        s = br.readLine();
                    }
                    j++;
                    k1 = 0;
                }
            } catch (IOException | IllegalArgumentException ex) {
                System.out.println("ОШИБКА R6: " + ex.getMessage());
            }

            //ЦВЕТ КНОПОК ВЫБОРА
            try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "src/RememberColor"))){
                String s = "";
                int j = 0, k = 0;
                while (k != i) {
                    do {
                        s = br.readLine();
                    } while (!s.equals(CommonFields.GUARD) && (s != null));
                    if (s.equals(CommonFields.GUARD))
                        k++;
                    else {
                        k = i;
                        System.out.println("ФАЙЛ НЕОЖИДАННО КОНЧИЛСЯ");
                    }
                }
                s = br.readLine();
                while (j < CommonFields.LENGTH) {
                    int k1 = 0;
                    while ((k1 < 4) && (s != null)) {
                        if (s.equals("BASE_COLOR"))
                            MyBox.rememberColor[j][k1] = CommonFields.getBaseColor();
                        else if (s.equals("GREEN"))
                            MyBox.rememberColor[j][k1] = Color.GREEN;
                        else
                            MyBox.rememberColor[j][k1] = Color.RED;
                        k1++;
                        s = br.readLine();
                    }
                    j++;
                }
            } catch (IOException | IllegalArgumentException ex) {
                System.out.println("ОШИБКА R7: " + ex.getMessage());
            }
            //WriterReader.readerA();
        }
        else {// УРОВЕНЬ ПОСЛОЖНЕЕ
            //ОТВЕТ ИГРОКА
            try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "src/AnswerUser"))){
                String s = "";
                int j = 0, k = 0;
                while (k != i) {
                    do {
                        s = br.readLine();
                    } while (!s.equals(CommonFields.GUARD) && (s != null));
                    if (s.equals(CommonFields.GUARD))
                        k++;
                    else {
                        k = i;
                        System.out.println("ФАЙЛ НЕОЖИДАННО КОНЧИЛСЯ");
                    }
                }
                s = br.readLine();
                while ((j < CommonFields.LENGTH) && (s != null)) {
                    CommonFields.answerUser[j] = s;
                    j++;
                    s = br.readLine();
                }
            } catch (IOException | IllegalArgumentException ex) {
                System.out.println("ОШИБКА R8: " + ex.getMessage());
            }

            //ПРАВИЛЬНЫЙ ЛИ ДАН ОТВЕТ?
            try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "src/IsRightAnswer"))){
                String s = "";
                int j = 0, k = 0;
                while (k != i) {
                    do {
                        s = br.readLine();
                    } while (!s.equals(CommonFields.GUARD) && (s != null));
                    if (s.equals(CommonFields.GUARD))
                        k++;
                    else {
                        k = i;
                        System.out.println("ФАЙЛ НЕОЖИДАННО КОНЧИЛСЯ");
                    }
                }
                s = br.readLine();
                while ((j < CommonFields.LENGTH) && (s != null)) {
                    if (s.equals("true"))
                        MyBox.isRightResult[j] = true;
                    else
                        MyBox.isRightResult[j] = false;
                    j++;
                    s = br.readLine();
                }
            } catch (IOException | IllegalArgumentException ex) {
                System.out.println("ОШИБКА R9: " + ex.getMessage());
            }
            //WriterReader.readerB();//ЕСЛИ В ОТКРЫВШУЮСЯ ПОПЫТКУ ВНЕСЛИ ИЗМЕНЕНИЕ, ТО СЧИТЫВАНИЕ С ИЗВЛЕЧЕНИЕМ
        }
        FrontPanel.getPanel().removeAll();
        Counter.getCounter().setText(//MyBox.counter.setText
                "<html>" + "<font color = \"00ff00\">" + CommonFields.getYesObj().toString() + "</font>" +
                        " : " +
                "<font color = \"ff0000\">" + CommonFields.getNotObj().toString() + "</font>" + "</html>");
        FrontPanel.getPanel().repaint();
        if (CommonFields.labels.get(3*i + 2).getText().equals("Уровень: " + Comboboxes.groundT[0])) {
            MyBox.picturesResult = MyBox.picturesG1A;
            FrontPanel.getPanel().setBackground(Color.LIGHT_GRAY);
            AnswerChooseGround.mp.buildInterface();//MyPlay.mp.interfaceA();
        } else {
            MyBox.picturesResult = MyBox.picturesG1B;
            AnswerInputGround.msg.buildInterface();//MySecondGround.msg.interfaceB();
        }
    }
}
