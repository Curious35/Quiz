package com.kvv.quiz.frontpageclasses;

import com.kvv.quiz.tasks.CommonFields;
import com.kvv.quiz.tasks.Counter;
import com.kvv.quiz.develop.Journal;
import com.kvv.quiz.tasks.MyBox;
import com.kvv.quiz.develop.WriterReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Строка меню на начальной странице приложения
 * @author Kukushkin V.
 */
class Menu implements ActionListener {
    private static final String SPACE = " ";
    private static final String TEST = "<html><font size=4 face=\"Arial\"><u>З</u>" + SPACE + "а" + SPACE + "д" + SPACE + "а" + SPACE + "н" + SPACE + "и" + SPACE + "е</font></html>";//"<html><u>Т</u>ест</html>"
    private static final String HELP = "<html><font size=4 face=\"Arial\"><u>С</u>" + SPACE + "п" + SPACE + "р" + SPACE + "а" + SPACE + "в" + SPACE + "к" + SPACE + "а</font></html>";//"<html><u>С</u>правка</html>"
    
    private static final KeyStroke NEW_MENU    = KeyStroke.getKeyStroke("control N");
    private static final KeyStroke OPEN_MENU   = KeyStroke.getKeyStroke("control O");
    private static final KeyStroke SAVE_MENU   = KeyStroke.getKeyStroke("control S");
    private static final KeyStroke DELETE_MENU = KeyStroke.getKeyStroke("control D");
    private static final KeyStroke EXIT_MENU   = KeyStroke.getKeyStroke("control E");
    private static final KeyStroke START_MENU  = KeyStroke.getKeyStroke("control T");
    private static final KeyStroke RULES_MENU  = KeyStroke.getKeyStroke("control R");
    private static final KeyStroke ABOUT_MENU  = KeyStroke.getKeyStroke("control A");

    private static JMenuBar menuBar = new JMenuBar();
    private static JMenu file = new JMenu(TEST);
    private static JMenu help = new JMenu(HELP);
    private static JMenuItem newTest = new JMenuItem(CommonFields.NEW);
    private static JMenuItem open    = new JMenuItem(CommonFields.OPEN);
    private static JMenuItem save    = new JMenuItem(CommonFields.SAVE);
    private static JMenuItem delete  = new JMenuItem(CommonFields.DELETE);
    private static JMenuItem exit    = new JMenuItem(CommonFields.EXIT);
    private static JMenuItem reiting = new JMenuItem(CommonFields.REITING);
    private static JMenuItem rights  = new JMenuItem(CommonFields.RULES);
    private static JMenuItem about   = new JMenuItem(CommonFields.ABOUT);
    
    static JMenuBar getMenuBar(){
        return menuBar;
    }
    
    void InitMenu(){
        menuBar.add(file);
        menuBar.add(help);
        file.add(newTest);
        newTest.setAccelerator(NEW_MENU);
        file.add(open);
        open.setAccelerator(OPEN_MENU);
        file.add(save);
        save.setAccelerator(SAVE_MENU);
        file.add(delete);
        delete.setAccelerator(DELETE_MENU);
        file.add(exit);
        exit.setAccelerator(EXIT_MENU);
        help.add(reiting);
        reiting.setAccelerator(START_MENU);
        help.add(rights);
        rights.setAccelerator(RULES_MENU);
        help.add(about);
        about.setAccelerator(ABOUT_MENU);
        newTest.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        delete.addActionListener(this);
        exit.addActionListener(this);
        reiting.addActionListener(this);
        rights.addActionListener(this);
        about.addActionListener(this);
    }
    
    /*
    ВЫБОР ПУНКТА МЕНЮ
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case CommonFields.NEW:
                FrontPanel.getPanel().removeAll();
                FrontPanel.getPanel().repaint();
                //Вызов окна с вопросом: сохранить закрываемую попытку?
                CommonFields.setI(CommonFields.ZERO);
                CommonFields.setYes(CommonFields.ZERO);
                CommonFields.setYesObj(CommonFields.getYes());
                CommonFields.setNot(CommonFields.ZERO);
                CommonFields.setNotObj(CommonFields.getNot());
                Counter.getCounter().setText(//counter.setText
                        "<html>" + "<font color = \"00ff00\">" + CommonFields.getYesObj().toString() + "</font>" +
                                " : " +
                        "<font color = \"ff0000\">" + CommonFields.getNotObj().toString() + "</font>" + "</html>");
                MyBox.initMasResults();
                Quiz.initialWindow();
                break;
            case CommonFields.OPEN:
                Journal.getFrameJournal().setVisible(true);
                break;
            case CommonFields.SAVE:
                WriterReader.toRecord();
                if (Quiz.getIndex() == 1)
                    WriterReader.toRecordA();
                else if (Quiz.getIndex() == 2)
                    WriterReader.toRecordB();
                Journal.makeGP();//Счётчик увеличивается внутри метода makeGP()
                WriterReader.saveTextLabels(Journal.getCount() - 1);//СОХРАНЯЕМ РАЗДЕЛ, ТЕМУ И УРОВЕНЬ
                WriterReader.setCountInFile();//ЗАПИСЫВАЕМ ТЕКУЩЕЕ ЗНАЧЕНИЕ COUNT В ФАЙЛ
                Journal.getPanelJournal().repaint();
                break;
            case CommonFields.DELETE:
                Journal.getPanelJournal().removeAll();
                Journal.getPanelJournal().repaint();
                CommonFields.buttons.clear();
                CommonFields.labels.clear();
                CommonFields.objects.clear();
                WriterReader.clear();//ОБНУЛЕНИЕ СЧЁТЧИКА В КОНЦЕ МЕТОДА
                WriterReader.setCountInFile();//ЗАПИСЫВАЕМ ТЕКУЩЕЕ ЗНАЧЕНИЕ COUNT В ФАЙЛ
                break;
            case CommonFields.EXIT:
                WriterReader.setCountInFile();
                System.exit(0);
                break;
            case CommonFields.REITING:
                MyBox.setheadline("СТАТИСТИКА УЧАСТНИКА");
                EditInterface.getTextLabel().removeAll();
                EditInterface.getTextLabel().repaint();
                EditInterface.statistics(MyBox.getheadline());
                EditInterface.getFrame().setVisible(true);
                break;
            case CommonFields.RULES:
                MyBox.setheadline("Правила \"Викторины\"");
                EditInterface.getTextLabel().removeAll();
                EditInterface.getTextLabel().repaint();
                EditInterface.interfaceRules(MyBox.getheadline(), MyBox.getTEXT_RULES());
                EditInterface.getFrame().setVisible(true);
                break;
            case CommonFields.ABOUT:
                MyBox.setheadline("О программе");
                EditInterface.getTextLabel().removeAll();
                EditInterface.getTextLabel().repaint();
                EditInterface.interfaceAbout(MyBox.getheadline(), MyBox.getTEXT_ABOUT());
                EditInterface.getFrame().setVisible(true);
                break;
            default:
        }
    }
}
