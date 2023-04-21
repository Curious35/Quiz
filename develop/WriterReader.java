package com.kvv.quiz.develop;

/**
 * Чтение и запись попыток в файл
 * @author Kukushkin V.
 */
import com.kvv.quiz.tasks.CommonFields;
import com.kvv.quiz.tasks.MyBox;
import java.awt.*;
import java.io.*;

public class WriterReader {
    public static void toRecordB() {
        //ОТВЕТ ИГРОКА
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/AnswerUser", true)) {
            for (int j = 0; j < CommonFields.LENGTH; j++) {
                writer.write(CommonFields.answerUser[j] + '\n');
            }
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА 1: " + ex.getMessage());
        }

        //ПРАВИЛЬНЫЙ ЛИ ДАН ОТВЕТ?
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/IsRightAnswer", true)) {
            for (int j = 0; j < CommonFields.LENGTH; j++) {
                if (MyBox.isRightResult[j])
                    writer.write("true" + '\n');
                else
                    writer.write("false" + '\n');
            }
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА 2: " + ex.getMessage());
        }
    }

    public static void toRecordA() {
        //ТЕСТОВЫЕ ВАРИАНТЫ ОТВЕТА
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/BufResult", true)) {
            for (int j = 0; j < CommonFields.LENGTH; j++)
                for (int k = 0; k < 4; k++)
                    writer.write(MyBox.bufResult[j][k] + '\n');
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА 3: " + ex.getMessage());
        }

        //ЦВЕТ КНОПОК ВЫБОРА
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/RememberColor", true)) {
            for (int j = 0; j < CommonFields.LENGTH; j++) {
                for (int k = 0; k < 4; k++) {
                    if (MyBox.rememberColor[j][k] == CommonFields.getBaseColor())
                        writer.write("BASE_COLOR\n");
                    else if (MyBox.rememberColor[j][k] == Color.GREEN)
                        writer.write("GREEN\n");
                    else
                        writer.write("RED\n");
                }
            }
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА 4: " + ex.getMessage());
        }
    }

    public static void toRecord() {
        //ВОПРОСЫ
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/ManyAsksResult", true)) {
            for (int j = 0; j < CommonFields.LENGTH; j++)
                writer.write(MyBox.manyAsksResult[j] + '\n');
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА 5: " + ex.getMessage());
        }

        //БЫЛ ЛИ ДАН ОТВЕТ
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/IsWasPressed", true)) {
            for (int j = 0; j < CommonFields.LENGTH; j++) {
                if (MyBox.isWasPressed[j])
                    writer.write("true" + '\n');
                else
                    writer.write("false" + '\n');
            }
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА 6: " + ex.getMessage());
        }

        //ПРАВИЛЬНЫЕ ОТВЕТЫ
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/AnswerResult", true)) {
            for (int j = 0; j < CommonFields.LENGTH; j++)
                writer.write(MyBox.answerResult[j] + '\n');
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА 7: " + ex.getMessage());
        }

        //ПУТИ К КАРТИНКАМ
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/PathPicturesResult", true)) {
            for (int j = 0; j < CommonFields.LENGTH; j++)
                writer.write(MyBox.pathResult[j] + '\n');
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА 8: " + ex.getMessage());
        }

        //ПОКАЗАНИЯ СЧЁТЧИКА
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/PastCounters", true)) {
            writer.write("" + CommonFields.getYes() + '\n');
            writer.write("" + CommonFields.getNot() + '\n');
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА 9: " + ex.getMessage());
        }
    }

    public static void clear() {
        System.out.println("ВОШЛИ В МЕТОД CLEAR()");
        try(FileWriter wr1 = new FileWriter(CommonFields.PATH_PROJECT + "src/AnswerUser", false);
            FileWriter wr2 = new FileWriter(CommonFields.PATH_PROJECT + "src/AnswerResult", false);
            FileWriter wr3 = new FileWriter(CommonFields.PATH_PROJECT + "src/BufResult", false);
            FileWriter wr4 = new FileWriter(CommonFields.PATH_PROJECT + "src/IsWasPressed", false);
            FileWriter wr5 = new FileWriter(CommonFields.PATH_PROJECT + "src/ManyAsksResult", false);
            FileWriter wr6 = new FileWriter(CommonFields.PATH_PROJECT + "src/PathPicturesResult", false);
            FileWriter wr7 = new FileWriter(CommonFields.PATH_PROJECT + "src/RememberColor", false);
            FileWriter wr8 = new FileWriter(CommonFields.PATH_PROJECT + "src/SaveGournalInterface", false);
            FileWriter wr9 = new FileWriter(CommonFields.PATH_PROJECT + "src/PastCounters", false);
            FileWriter wr10 = new FileWriter(CommonFields.PATH_PROJECT + "src/IsRightAnswer", false)) {
            wr1.write("");
            wr1.flush();
            wr2.write("");
            wr2.flush();
            wr3.write("");
            wr3.flush();
            wr4.write("");
            wr4.flush();
            wr5.write("");
            wr5.flush();
            wr6.write("");
            wr6.flush();
            wr7.write("");
            wr7.flush();
            wr8.write("");
            wr8.flush();
            wr9.write("");
            wr9.flush();
            wr10.write("");
            wr10.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА CLEAR: " + ex.getMessage());
        }
        Journal.setCount(0);
    }
//В ФАЙЛЕ SaveGournalInterface ХРАНИТЬ ЛИШЬ НАЗВАНИЯ РАЗДЕЛА, ТЕМЫ И УРОВНЯ
    //СОХРАНЕНИЕ ВНЕШНЕГО ОБЛИКА ПАНЕЛЕЙ ЖУРНАЛА
    public static void saveTextLabels(int j) {
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/SaveGournalInterface", true)) {
            writer.write((CommonFields.labels.get(3*j)).getText() + '\n');//РАЗДЕЛ
            writer.write((CommonFields.labels.get(3*j + 1)).getText() + '\n');//ТЕМА
            writer.write((CommonFields.labels.get(3*j + 2)).getText() + '\n');//УРОВЕНЬ
            writer.append(CommonFields.GUARD);
            writer.flush();
        } catch(IOException ex) {
            System.out.println("ОШИБКА В saveGournal: " + ex.getMessage());
        }
    }

    /*
    ЗАНОСИМ ЗНАЧЕНИЕ ПЕРЕМЕННОЙ COUNT В ФАЙЛ
     */
    public static void setCountInFile() {
        String s = String.valueOf(Journal.getCount());
        try(FileWriter writer = new FileWriter(CommonFields.PATH_PROJECT + "src/CountPanels", false)) {
            writer.write(s);
            writer.flush();
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*
    ВОССТАНАВЛИВАЕМ ЗНАЧЕНИЕ ПЕРЕМЕННОЙ COUNT В ПРОГРАММЕ
     */
    public static void getCountInFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(CommonFields.PATH_PROJECT + "src/CountPanels"))){
            String s = br.readLine();
            if (s != null)
                Journal.setCount(Integer.parseInt(s));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
