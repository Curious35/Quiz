package com.kvv.quiz.frontpageclasses;

/**
 *
 * @author Kukushkin V.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class EditInterface implements ActionListener {
    private static final int WINDOW_WIDTH = 700, WINDOW_HEIGHT = 500;
    private static final JFrame FRAME = new JFrame("Справка");
    private static JPanel panel = new JPanel();
    private static JPanel textLabel = new JPanel();
    private static JLabel headLineLabel = new JLabel();
    private static JEditorPane ep = new JEditorPane();
    private static JScrollPane sp = new JScrollPane(ep);
    private static JButton closeFrame = new JButton("Закрыть");
    private static JTextPane textArea = new JTextPane();
    private static final Font HEAD = new Font("Arial", Font.ITALIC, 22);
    private static final Font LINE = new Font("Arial", Font.PLAIN, 14);
    private static final Color COLOR = new Color(80, 255, 140);

    static JFrame getFrame() {
        return FRAME;
    }

    static JPanel getTextLabel() {return textLabel;}

    EditInterface() {
        FRAME.setDefaultCloseOperation(HIDE_ON_CLOSE);
        FRAME.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        FRAME.setResizable(true);
        FRAME.setLayout(null);
        FRAME.add(panel);
        FRAME.revalidate();
        FRAME.repaint();
        FRAME.setVisible(true);
        panel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
    }

    /*
    О ПРОГРАММЕ
     */
    static void interfaceAbout(String formHeadline, String formText) {
        headLineLabel.setLayout(null);
        headLineLabel.setBackground(COLOR);
        headLineLabel.setOpaque(true);
        headLineLabel.setBounds(0, 0, WINDOW_WIDTH, 80);
        headLineLabel.setFont(HEAD);
        headLineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headLineLabel.setText(formHeadline);

        textLabel.setBackground(COLOR);
        textLabel.setOpaque(true);
        textLabel.setBounds(0, 81, WINDOW_WIDTH, WINDOW_HEIGHT - headLineLabel.getHeight());
        textLabel.setLayout(null);
        textArea.setBounds(18, 50, 650, 250);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setAutoscrolls(true);
        textArea.setFont(LINE);
        textArea.setText(formText);
        closeFrame.setBounds(300, 440, 100, 40);
        closeFrame.setEnabled(true);
        closeFrame.setVisible(true);
        textLabel.add(textArea);
        textLabel.add(closeFrame);

        panel.add(headLineLabel);
        panel.add(textLabel);
        panel.revalidate();
        panel.repaint();
    }

    /*
    ПРАВИЛА
     */
    static void interfaceRules(String formHeadline, String formText) {
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        headLineLabel.setLayout(null);
        headLineLabel.setBackground(COLOR);
        headLineLabel.setOpaque(true);
        headLineLabel.setBounds(0, 0, WINDOW_WIDTH, 80);
        headLineLabel.setFont(HEAD);
        headLineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headLineLabel.setText(formHeadline);

        textLabel.setBackground(COLOR);
        textLabel.setOpaque(true);
        textLabel.setBounds(0, 81, WINDOW_WIDTH, WINDOW_HEIGHT - headLineLabel.getHeight());
        textLabel.setLayout(null);
        textLabel.add(sp);
        sp.setBounds(18, 50, 650, 250);
        ep.setEditable(false);
        ep.setContentType("text/html");
        ep.setText(formText);
        ep.revalidate();
        sp.repaint();
        panel.add(headLineLabel);
        panel.add(textLabel);
        panel.revalidate();
        panel.repaint();
    }

    /*
    СТАТИСТИКА ИГРОКА
     */
    static void statistics(String formHeadline) {
        headLineLabel.setLayout(null);
        headLineLabel.setBackground(COLOR);
        headLineLabel.setOpaque(true);
        headLineLabel.setBounds(0, 0, WINDOW_WIDTH, 80);
        headLineLabel.setText("<html> <font color=\"0000ff\">"+formHeadline+"</font><html>");


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(closeFrame))
            EditInterface.getFrame().setVisible(false);
    }
}
