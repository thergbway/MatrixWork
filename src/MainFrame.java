import task.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс - графическое окно, в котором находятся кнопки для запуска заданий
 */
public class MainFrame extends JFrame {
    private static final int FRAME_POSITION_X= 200;
    private static final int FRAME_POSITION_Y= 200;
    private static final int TASK_COUNT= 20;
    private static final String[] TASK_NAMES= new String[]{
            "1 Упорядочение строк по элементам столбца k",
            "2 Сдвиги матриц",
            "3 Наибольшее число возрастающих элементов идущих подряд",
            "4 Суммы между положительными эл. в строках",
            "5 Транспонирование квадратной матрицы",
            "6 Вычисление евклидовой нормы матрицы",
            "7 Поворот матрицы на 90, 180, 270 градусов",
            "8 Определитель матрицы",
            "9 Вычитание из строк их среднего арифметического",
            "10 Матрица без строк и столбцов с макс. элементом",
            "11 Матрица без нулевых столбцов и строк",
            "12 Матрица, где в указанном месте минимум",
            "13 Матрица с нулевыми элементами в конце строк",
            "14 Матрица с округленными до целого числа элементами",
            "15 Количество седловых точек",
            "16 Матрица с увеличивающейся суммой строк",
            "17 Число локальных минимумов",
            "18 Поиск наибольшего локального максимума",
            "19 Матрица с уменьшающимися характеристиками столбцов",
            "20 Матрица с макс. элементами на главной диагонали",
    };

    /**
     * @param s frame title
     */
    public MainFrame(String s){
        super(s);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(FRAME_POSITION_X, FRAME_POSITION_Y, getWidth(), getHeight());

        setLayout(new GridLayout(0,1));
        JButton[] startTaskButtons = new JButton[TASK_COUNT];

//        for(int i= 0; i< TASK_COUNT; ++i){
//            startTaskButtons[i]= new JButton(TASK_NAMES[i]);
//            startTaskButtons[i].addActionListener(getActionListenerByTaskIndex(i+1));
//            add(startTaskButtons[i]);
//        }

        int i= 0;
        for(Task t: Task.values()){
            startTaskButtons[i]= new JButton(TASK_NAMES[i]);
            startTaskButtons[i].addActionListener(getActionListenerByTaskIndex(t));
            add(startTaskButtons[i]);
            ++i;
        }

    }

    /**
     * Функция, возвращающая объект - слушатель кнопок в соответствии с заданием
     * @param task номер задания
     * @return соответствующий слушатель кнопки
     */
    private ActionListener getActionListenerByTaskIndex(Task task){
        switch (task){
            case TASK1:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task1();
                    }
                };
            case TASK2:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task2();
                    }
                };
            case TASK3:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task3();
                    }
                };
            case TASK4:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task4();
                    }
                };
            case TASK5:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task5();
                    }
                };
            case TASK6:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task6();
                    }
                };
            case TASK7:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task7();
                    }
                };
            case TASK8:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task8();
                    }
                };
            case TASK9:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task9();
                    }
                };
            case TASK10:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task10();
                    }
                };
            case TASK11:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task11();
                    }
                };
            case TASK12:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task12();
                    }
                };
            case TASK13:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task13();
                    }
                };
            case TASK14:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task14();
                    }
                };
            case TASK15:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task15();
                    }
                };
            case TASK16:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task16();
                    }
                };
            case TASK17:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task17();
                    }
                };
            case TASK18:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task18();
                    }
                };
            case TASK19:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task19();
                    }
                };
            case TASK20:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task20();
                    }
                };
            default:
                throw new IllegalArgumentException();
        }
    }

    private enum Task{
        TASK1, TASK2, TASK3, TASK4, TASK5, TASK6, TASK7, TASK8, TASK9, TASK10,
        TASK11, TASK12, TASK13, TASK14, TASK15, TASK16, TASK17, TASK18, TASK19, TASK20
    }
}
