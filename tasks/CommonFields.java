package com.kvv.quiz.tasks;

import java.awt.Color;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Общие поля приложения
 * @author Kukushkin V.
 */
public class CommonFields {
    public static final int ZERO = 0;
    public static final int LENGTH = 10;
    public static final String PATH_PHOTO   = "/";
    public static final String PATH_PROJECT = "C:/Users/User/Desktop/DATA/HOME/JavaProjects/Quiz/";
    static final String BACK = "Назад";
    static final String NEXT = "Вперёд";
    
    public static final String NEW     = "Новый тест";
    public static final String OPEN    = "Открыть попытку";
    public static final String SAVE    = "Сохранить тест";
    public static final String DELETE  = "Удалить все попытки";
    public static final String EXIT    = "Выход";
    public static final String REITING = "Статистика игрока";
    public static final String RULES   = "Правила игры";
    public static final String ABOUT   = "О программе";
    
    public static final String GUARD = "==== ==== ====\n";
    
    private static final Color BASE_COLOR = new Color(238, 238, 238);
    
    public static Color color = new Color(0, 220, 0);
    
    public static String textR = "", textT = "", textG = "";
    
    public static String[] answerUser = new String[MyBox.manyAsksResult.length];//Хранит ответ игрока
    
    public static Vector<JButton> buttons = new Vector<>();
    public static Vector<JLabel> labels = new Vector<>();
    public static Vector<JPanel> objects = new Vector<>();
    
    private static int i = 0, yes = 0, not = 0;
    private static Integer yesObj = yes, notObj = not;
    
    static int getI() {
        return i;
    }

    public static void setI(int i) {
        CommonFields.i = i;
    }

    public static int getYes() {
        return yes;
    }

    public static void setYes(int yes) {
        CommonFields.yes = yes;
    }

    public static int getNot() {
        return not;
    }

    public static void setNot(int not) {
        CommonFields.not = not;
    }

    public static Integer getYesObj() {
        return yesObj;
    }

    public static void setYesObj(Integer yesObj) {
        CommonFields.yesObj = yesObj;
    }

    public static Integer getNotObj() {
        return notObj;
    }

    public static void setNotObj(Integer notObj) {
        CommonFields.notObj = notObj;
    }
    
    public static Color getBaseColor() {
        return BASE_COLOR;
    }
}