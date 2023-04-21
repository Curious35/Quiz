package com.kvv.quiz.frontpageclasses;

import javax.swing.JComboBox;

/**
 * Выпадающие списки на начальной странице приложения и их значения
 * @author Kukushkin v.
 */
public class Comboboxes {
    static final String NONE      = "<html><font size=4 face=\"Arial\" color=\"RED\">Не выбран</font></html>";
    static final String GEOGRAPHY = "<html><font size=4 face=\"Arial\">География</font></html>";
    static final String HISTORY   = "<html><font size=4 face=\"Arial\">История</font></html>";
    public static final String LIGHT_G   = "<html><font size=4 face=\"Arial\">Попроще</font></html>";
    public static final String HARD_G    = "<html><font size=4 face=\"Arial\">Посложнее</font></html>";
    static final String CAPITALS  = "<html><font size=4 face=\"Arial\">Столицы государств</font></html>";
    static final String USA       = "<html><font size=4 face=\"Arial\">США</font></html>";
    
    static String[] dataR      = {NONE, GEOGRAPHY, HISTORY};
    public static String[] groundT    = {LIGHT_G, HARD_G};
    static String[] geographyT = {CAPITALS};
    static String[] historyT   = {USA};
    
    static JComboBox<String> CHAPTER = new JComboBox<>(dataR);
    static JComboBox<String> THEME   = new JComboBox<>();
    static JComboBox<String> GROUND  = new JComboBox<>(groundT);
}
