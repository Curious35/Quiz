package com.kvv.quiz.frontpageclasses;

/**
 * Класс начальной страницы приложения
 * @author Kukushkin V.
 */
import com.kvv.quiz.tasks.AnswerChooseGround;
import com.kvv.quiz.tasks.AnswerInputGround;
import com.kvv.quiz.tasks.CommonFields;
import com.kvv.quiz.develop.Journal;
import com.kvv.quiz.tasks.MyBox;
import com.kvv.quiz.develop.WriterReader;
import com.kvv.quiz.endwindow.Final;
import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Quiz extends KeyAdapter implements ActionListener {    
    private static final int WINDOW_WIDTH = 700, WINDOW_HEIGHT = 700;
    private static final String NAME = "Викторина";

    private static final JFrame WIN = new JFrame(NAME);

    private static int index = 1;
    
    static int getIndex() {
        return index;
    }
    
    static void setIndex(int index) {
        Quiz.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ReadyButton.getReady().setToolTipText(null);
        if (e.getSource().equals(Comboboxes.CHAPTER))
            switch ((String) Objects.requireNonNull(Comboboxes.CHAPTER.getSelectedItem())) {//Считывает выбранный пункт меню
                case Comboboxes.GEOGRAPHY:
                    Comboboxes.THEME.setModel(new DefaultComboBoxModel<>(Comboboxes.geographyT));
                    Comboboxes.THEME.setEnabled(true);
                    ReadyButton.getReady().setEnabled(true);
                    break;
                case Comboboxes.HISTORY:
                    Comboboxes.THEME.setModel(new DefaultComboBoxModel<>(Comboboxes.historyT));
                    Comboboxes.THEME.setEnabled(true);
                    ReadyButton.getReady().setEnabled(true);
                    break;
                default:
        } else {
            index = (Objects.requireNonNull(Comboboxes.GROUND.getSelectedItem())).equals(Comboboxes.groundT[0]) ? 1 : 2;
            FrontPanel.getPanel().removeAll();
            FrontPanel.getPanel().repaint();
            if (!(Objects.requireNonNull(Comboboxes.CHAPTER.getSelectedItem())).toString().equals(Comboboxes.NONE)) {
                CommonFields.textR = (String) Comboboxes.CHAPTER.getSelectedItem();
                MyBox.initMasResults();
                switch ((String) Comboboxes.CHAPTER.getSelectedItem()) {
                    case Comboboxes.GEOGRAPHY:
                        switch ((String) Objects.requireNonNull(Comboboxes.THEME.getSelectedItem())) {
                            case Comboboxes.CAPITALS:
                                CommonFields.textT = (String) Comboboxes.THEME.getSelectedItem();
                                switch ((String) Objects.requireNonNull(Comboboxes.GROUND.getSelectedItem())) {
                                    case Comboboxes.LIGHT_G:
                                        CommonFields.textG = (String) Comboboxes.GROUND.getSelectedItem();
                                        MyBox.assignArraysLIGHT(MyBox.manyAsksG1, MyBox.bufG1, MyBox.answerG1, MyBox.pathA, MyBox.picturesG1A);
                                        CommonFields.setI(CommonFields.ZERO);
                                        AnswerChooseGround.mp.buildInterface();
                                        break;
                                    case Comboboxes.HARD_G:
                                        CommonFields.textG = (String) Comboboxes.GROUND.getSelectedItem();
                                        CommonFields.answerUser = MyBox.c;
                                        MyBox.assignArraysHARD(MyBox.manyAsksG1, MyBox.answerG1, MyBox.pathB, MyBox.picturesG1B);
                                        CommonFields.setI(CommonFields.ZERO);
                                        AnswerInputGround.msg.buildInterface();
                                        FrontPanel.getPanel().repaint();
                                        break;
                                    default:
                                }
                                break;
                            default:
                        }
                        break;
                    case Comboboxes.HISTORY:
                        switch ((String) Objects.requireNonNull(Comboboxes.THEME.getSelectedItem())) {
                            case Comboboxes.USA:
                                CommonFields.textT = (String) Comboboxes.THEME.getSelectedItem();
                                switch ((String) Objects.requireNonNull(Comboboxes.GROUND.getSelectedItem())) {
                                    case Comboboxes.LIGHT_G:
                                        CommonFields.textG = (String) Comboboxes.GROUND.getSelectedItem();
                                        MyBox.assignArraysLIGHT(MyBox.manyAsksHNA, MyBox.bufHNA, MyBox.answerHNA, MyBox.pathHNA, MyBox.picturesHNA);
                                        CommonFields.setI(CommonFields.ZERO);
                                        AnswerChooseGround.mp.buildInterface();
                                        break;
                                    case Comboboxes.HARD_G:
                                        CommonFields.answerUser = MyBox.c;
                                        AnswerInputGround.msg.buildInterface();
                                        FrontPanel.getPanel().repaint();
                                        break;
                                    default:
                                }
                                break;
                            default:
                        }
                        break;            
                    default:
                }
                Comboboxes.CHAPTER.setModel(new DefaultComboBoxModel<>(Comboboxes.dataR));
            }
        }
    }

    private Quiz(JFrame frame) {
        MyBox mb = new MyBox();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(FrontPanel.getPanel());
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setVisible(true);
        FrontPanel.getPanel().setLayout(null);        
        new Menu().InitMenu();
        frame.setJMenuBar(Menu.getMenuBar());
        Comboboxes.CHAPTER.setName("JCB1");
        Comboboxes.THEME.setName("JCB2");
        ReadyButton.getReady().addActionListener(this);
        Comboboxes.CHAPTER.addActionListener(this);
        Comboboxes.CHAPTER.addKeyListener(this);
        new Final();
        Final.getWin_final().setVisible(false);     
        new EditInterface();
        EditInterface.getFrame().setVisible(false);
        new Journal();
        Journal.getFrameJournal().setVisible(false);
        WriterReader.getCountInFile();//Восстанавливаем значение переменной Count
        if (Journal.getCount() != 0)
            Journal.reconstruction();//Восстанавливаем попытки
        initialWindow();
    }

    public static void initialWindow() {
        FrontPageLabel.getHead().initFrontPageLabel(FrontPageLabel.getHead(), 100, 40, 500, 100, false);
        FrontPageLabel.getChapter().initFrontPageLabel(FrontPageLabel.getChapter(), 150, 200, 250, 40, false);
        FrontPageLabel.getTheme().initFrontPageLabel(FrontPageLabel.getTheme(), 150, 310, 250, 40, false);
        FrontPageLabel.getGround().initFrontPageLabel(FrontPageLabel.getGround(), 150, 410, 250, 40, false);
        Comboboxes.CHAPTER.setBounds(150, 250, 400, 40);
        Comboboxes.THEME.setBounds(150, 360, 400, 40);
        Comboboxes.THEME.setEnabled(false);
        Comboboxes.GROUND.setBounds(150, 460, 400, 40);
        ReadyButton.getReady().initReadyButton(ReadyButton.getReady(), 300, 555, 100, 40, false);
        FrontPanel.getPanel().initFrontPanel(FrontPanel.getPanel());
    }
    
    public static void main(String[] args) {
        new Quiz(WIN);
    }
}
