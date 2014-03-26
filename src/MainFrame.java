import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton[] startTaskButtons;
    private static final int TASK_COUNT= 20;
    private static final String[] TASK_NAMES= new String[]{
            "1 Not done yet",
            "2 Not done yet",
            "3 Not done yet",
            "4 Not done yet",
            "5 Транспонирование квадратной матрицы",
            "6 Вычисление евклидовой нормы матрицы",
            "7 Not done yet",
            "8 Not done yet",
            "9 Not done yet",
            "10 Not done yet",
            "11 Not done yet",
            "12 Not done yet",
            "13 Not done yet",
            "14 Not done yet",
            "15 Not done yet",
            "16 Not done yet",
            "17 Not done yet",
            "18 Not done yet",
            "19 Not done yet",
            "20 Not done yet",
    };

    public MainFrame(String s){
        super(s);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

                    }
                };
            case 8:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 9:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 10:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 11:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 12:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 13:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 14:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 15:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 16:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 17:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 18:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 19:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            case 20:
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                };
            default:
                throw new IllegalArgumentException();
        }
    }
}