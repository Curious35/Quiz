package com.kvv.quiz.tasks;

/**
 *
 * @author Kukushkin V.
 */
import com.kvv.quiz.frontpageclasses.Quiz;
import javax.swing.*;
import java.awt.*;

public class MyBox {

    /*
    География 1
     */
    public static String[] manyAsksG1 = {
            "Выберите столицу государства Непал",
            "Выберите столицу Новой Зеландии",
            "Столица Парагвая - это ...",
            "Стольный град Монголии",
            "Столица Мексики",
            "Столица Бразилии",
            "Столица Канады",
            "Столица Венесуэлы",
            "Столица Мали",
            "Столица Таджикистана"
    };
    public static String[][] bufG1 ={
            {"Сува", "Нукуалофа", "Катманду", "Басра"},
            {"Окленд", "Веллингтон", "Касабланка", "Ашкелон"},
            {"Асунсьон", "Манагуа", "Порт-о-Пренс", "Карачи"},
            {"Нук", "Улан-Батор", "Пхеньян", "Хошимин"},
            {"Гранада", "Нджамена", "Панама", "Мехико"},
            {"Буэнос-Айрес", "Бразилиа", "Рио-де-Жанейро", "Тяньцзинь"},
            {"Ванкувер", "Оттава", "Тампа", "Орландо"},
            {"Барселона", "Луанда", "Лодзь", "Каракас"},
            {"Бамако", "Велкопоповице", "Цербст", "Кербела"},
            {"Атырау", "Бишкек", "Гётеборг", "Душанбе"}
    };

    public static String[] answerG1 = {"Катманду", "Веллингтон", "Асунсьон", "Улан-Батор", "Мехико", "Бразилиа",
            "Оттава", bufG1[7][3], "Бамако", "Душанбе"};

    public static String[] pathA = {CommonFields.PATH_PHOTO + "Kathmandu_A.jpg",
            CommonFields.PATH_PHOTO + "Wellington_A.jpg",
            CommonFields.PATH_PHOTO + "Asuncion_A.jpg",
            CommonFields.PATH_PHOTO + "Ulan-Bator_A.jpg",
            CommonFields.PATH_PHOTO + "Mehico_A.jpg",
            CommonFields.PATH_PHOTO + "Brasilia_A.jpg",
            CommonFields.PATH_PHOTO + "Ottawa_A.jpg",
            CommonFields.PATH_PHOTO + "Caracas_A.jpg",
            CommonFields.PATH_PHOTO + "Bamako_A.jpg",
            CommonFields.PATH_PHOTO + "Dushanbe_A.jpg"};

    public static ImageIcon[] picturesG1A = {
            new ImageIcon(Quiz.class.getResource(pathA[0])),
            new ImageIcon(Quiz.class.getResource(pathA[1])),
            new ImageIcon(Quiz.class.getResource(pathA[2])),
            new ImageIcon(Quiz.class.getResource(pathA[3])),
            new ImageIcon(Quiz.class.getResource(pathA[4])),
            new ImageIcon(Quiz.class.getResource(pathA[5])),
            new ImageIcon(Quiz.class.getResource(pathA[6])),
            new ImageIcon(Quiz.class.getResource(pathA[7])),
            new ImageIcon(Quiz.class.getResource(pathA[8])),
            new ImageIcon(Quiz.class.getResource(pathA[9]))
    };

    public static String[] pathB = {CommonFields.PATH_PHOTO + "Kathmandu_B.jpg",
            CommonFields.PATH_PHOTO + "Wellington_B.jpg",
            CommonFields.PATH_PHOTO + "Asuncion_B.jpg",
            CommonFields.PATH_PHOTO + "Ulan-Bator_B.jpg",
            CommonFields.PATH_PHOTO + "Mehico_B.jpg",
            CommonFields.PATH_PHOTO + "Brasilia_B.jpg",
            CommonFields.PATH_PHOTO + "Ottawa_B.jpg",
            CommonFields.PATH_PHOTO + "Caracas_B.jpg",
            CommonFields.PATH_PHOTO + "Bamako_B.jpg",
            CommonFields.PATH_PHOTO + "Dushanbe_B.jpg"};

    public static ImageIcon[] picturesG1B = {
            new ImageIcon(Quiz.class.getResource(pathB[0])),
            new ImageIcon(Quiz.class.getResource(pathB[1])),
            new ImageIcon(Quiz.class.getResource(pathB[2])),
            new ImageIcon(Quiz.class.getResource(pathB[3])),
            new ImageIcon(Quiz.class.getResource(pathB[4])),
            new ImageIcon(Quiz.class.getResource(pathB[5])),
            new ImageIcon(Quiz.class.getResource(pathB[6])),
            new ImageIcon(Quiz.class.getResource(pathB[7])),
            new ImageIcon(Quiz.class.getResource(pathB[8])),
            new ImageIcon(Quiz.class.getResource(pathB[9]))
    };

    /*
    История 1
     */
    public static String[] manyAsksHNA = {
            "В каком году началась война за независимость США?",
            "Первым президентом США избрали ...",
            "Сколько дней правил Джефферсон?",
            "Дата принятия Декларации независимости США",
            "Восстание Шейса началось в ... году",
            "Гражданская война в США",
            "Время Англо-Американской войны.",
            "Самый первый штат США.",
            "Из скольких штатов состоит США?",
            "Период Великой депрессии"
    };
    public static String[][] bufHNA ={
            {"1775", "1776", "1765", "1783"},
            {"Лафайет", "Монро", "Джефферсон", "Вашингтон"},
            {"2865", "2922", "31", "199"},
            {"4.07.1776", "14.07.1789", "9.11.1799", "22.08.1643"},
            {"1787", "1929", "1786", "1818"},
            {"1853-1856", "1861-1865", "1905-1907", "1789-1799"},
            {"1916-1919", "1912", "1926", "1812-1815"},
            {"Пенсильвания", "Вашингтон", "Делавэр", "Вермонт"},
            {"51", "50", "52", "49"},
            {"1929-1933", "1775-1783", "1929-1939", "1941"}
    };

    public static String[] answerHNA = {bufHNA[0][0], bufHNA[1][3], bufHNA[2][1], bufHNA[3][0], bufHNA[4][2], bufHNA[5][1],
            bufHNA[6][3], bufHNA[7][2], bufHNA[8][1], bufHNA[9][2]};

    public static String[] pathHNA = {CommonFields.PATH_PHOTO + "1_A.jpg",
            CommonFields.PATH_PHOTO + "2_A.jpg",
            CommonFields.PATH_PHOTO + "3_A.jpg",
            CommonFields.PATH_PHOTO + "4_A.jpg",
            CommonFields.PATH_PHOTO + "5_A.jpg",
            CommonFields.PATH_PHOTO + "6_A.jpg",
            CommonFields.PATH_PHOTO + "7_A.jpg",
            CommonFields.PATH_PHOTO + "8_A.jpg",
            CommonFields.PATH_PHOTO + "9_A.png",
            CommonFields.PATH_PHOTO + "10_A.jpg"};

    public static ImageIcon[] picturesHNA = {
            new ImageIcon(Quiz.class.getResource(pathHNA[0])),
            new ImageIcon(Quiz.class.getResource(pathHNA[1])),
            new ImageIcon(Quiz.class.getResource(pathHNA[2])),
            new ImageIcon(Quiz.class.getResource(pathHNA[3])),
            new ImageIcon(Quiz.class.getResource(pathHNA[4])),
            new ImageIcon(Quiz.class.getResource(pathHNA[5])),
            new ImageIcon(Quiz.class.getResource(pathHNA[6])),
            new ImageIcon(Quiz.class.getResource(pathHNA[7])),
            new ImageIcon(Quiz.class.getResource(pathHNA[8])),
            new ImageIcon(Quiz.class.getResource(pathHNA[9]))
    };
    
    /*
    Массивы с данными, заполняемые в зависимости от выбранного игроком теста
     */
    public static String[] manyAsksResult = new String[CommonFields.LENGTH];
    public static String[][] bufResult = new String[CommonFields.LENGTH][4];
    public static String[] answerResult = new String[CommonFields.LENGTH];
    public static ImageIcon[] picturesResult = new ImageIcon[CommonFields.LENGTH];
    public static String[] pathResult = new String[CommonFields.LENGTH];
    public static boolean[] isRightResult = new boolean[CommonFields.LENGTH];

    public static boolean[] isWasPressed = new boolean[CommonFields.LENGTH];
    public static Color[][] rememberColor = new Color[CommonFields.LENGTH][bufResult[CommonFields.getI()].length];

    public static String[] c = new String[CommonFields.LENGTH];
    static String[][] d = new String[CommonFields.LENGTH][4];
    static ImageIcon[] im = new ImageIcon[CommonFields.LENGTH];

    private static String headline = "";
    
    public static String getheadline(){
        return headline;
    }
    
    public static void setheadline(String headline){
        MyBox.headline = headline;
    }
    
    private static final String TEXT_ABOUT = "\"Викторина\", версия 1.0. \nДата выпуска: декабрь 2018 года.\n" +
            "Разработчик: Кукушкин В. В. (город Урюпинск).\nСоздатель благодарен кандидату технических наук, " +
            "профессору кафедры прикладной математики вологодского государственного университета Свердлову Сергею Залмановичу " +
            "за полезные замечания, высказанные во время работы над \"Викториной\"";
    
    public static final String getTEXT_ABOUT(){
        return TEXT_ABOUT;
    }
    
    private static final String TEXT_RULES =
            "<html>" +
                    "<style> " +
                    "<font size=4 face=\"Arial\">" +
                    "<ol>" +
                    "<li>"+"Участник викторины выбирает из списков интересующие его раздел, тему и уровень." + "</li>" +
                    "<li>"+"Нажатие на кнопку \"Готово\" открывает выбранное задание." + "</li>" +
                    "<li>"+"Тип задания зависит от выбранного уровня." + "</li>" +
                    "<ul>" +
                    "<li>"+"Если выбран уровень \"Попроще\", то участнику викторины откроется тест с четырьмя вариантами ответа, один" +
                    " и только один из которых правильный." + "</li>" +
                    "<li>"+"Если выбран уровень \"Посложнее\", то участнику викторины откроется задание со свободным ответом." +
                    "Свободным ответом считается единственное, занесённое в поле ввода слово." + "</li>" +
                    "</ul>" +
                    "<li>" + "Всякое задание викторины состоит пока из десяти вопросов." + "</li>" +
                    "<li>" + "Переключаться между вопросами можно при помощи кнопок \"Вперёд\" и \"Назад\", а так же " +
                    "с помощью клавиатуры, нажимая соответственно RIGHT или LEFT." + "</li>" +
                    "<li>" + "Каждый тест снабжён счётчиком, учитывающим Ваши ответы. Количество правильных отмечается зелёным цветом, " +
                    "а неверных - красным." + "</li>" +
                    "<li>" + "\"Викторина\" снабжена меню. Для выбора пункта меню можно воспользоваться горячими клавишами." + "</li>" +
                    "</ol>" +
                    "</font>" +
                    "</style>" +
            "</html>";
    
    public static final String getTEXT_RULES(){
        return TEXT_RULES;
    }
    
    public static void initMasResults() {
        manyAsksResult = c;
        answerResult = c;
        bufResult = d;
        pathResult = c;
        picturesResult = im;
        for (int j = 0; j < manyAsksResult.length; j++) {
            isWasPressed[j] = false;
            isRightResult[j] = false;
            for (int k = 0; k < bufResult[CommonFields.getI()].length; k++)
                rememberColor[j][k] = CommonFields.getBaseColor();
        }
    }
    
    public static void assignArraysLIGHT(String[] a1, String[][] a2, String[] a3, String[] a4, ImageIcon[] im) {
        manyAsksResult = a1;
        bufResult      = a2;
        answerResult   = a3;
        pathResult     = a4;
        picturesResult = im;
    }
    
    public static void assignArraysHARD(String[] a1, String[] a2, String[] a3, ImageIcon[] im) {
        manyAsksResult = a1;
        answerResult   = a2;
        pathResult     = a3;
        picturesResult = im;
    }
}