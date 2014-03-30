import task.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton[] startTaskButtons;
    private static final int FRAME_POSITION_X= 200;
    private static final int FRAME_POSITION_Y= 200;
    private static final int TASK_COUNT= 20;
    private static final String[] TASK_NAMES= new String[]{
            "1 Not done yet",
            "2 Сдвиги матриц",
            "3 Not done yet",
            "4 Not done yet",
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
        startTaskButtons = new JButton[TASK_COUNT];

        for(int i= 0; i< TASK_COUNT; ++i){
            startTaskButtons[i]= new JButton(TASK_NAMES[i]);
            startTaskButtons[i].addActionListener(getActionListenerByTaskIndex(i+1));
            add(startTaskButtons[i]);
        }
    }
    private ActionListener getActionListenerByTaskIndex(int index){
        switch (index){
            case 1:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 2:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task2();
                    }
                };
            case 3:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 4:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 5:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task5();
                    }
                };
            case 6:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task6();
                    }
                };
            case 7:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task7();
                    }
                };
            case 8:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task8();
                    }
                };
            case 9:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task9();
                    }
                };
            case 10:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task10();
                    }
                };
            case 11:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task11();
                    }
                };
            case 12:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task12();
                    }
                };
            case 13:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task13();
                    }
                };
            case 14:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task14();
                    }
                };
            case 15:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task15();
                    }
                };
            case 16:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task16();
                    }
                };
            case 17:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task17();
                    }
                };
            case 18:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task18();
                    }
                };
            case 19:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Task19();
                    }
                };
            case 20:
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
}
