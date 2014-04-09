package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task9 extends Task {
    public Task9(){
        super("#9");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                appendText("Введено " + value + "\n");
                Matrix m= MatrixUtils.getRandomizedMatrix(value);
                appendText("Исходная матрица: \n\n" + m + "\n\n");
                m.decreaseAllRowValuesAtRowAverage();
                appendText("После вычета из элементов каждой строки матрицы её среднего арифметического: \n\n" +
                        m + "\n\n");
            }
        }).start();
    }
}