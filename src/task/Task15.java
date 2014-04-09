package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task15 extends Task {
    public Task15(){
        super("#15");
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
                appendText("Количество седловых точек : " + m.getSaddlePointCount());
            }
        }).start();
    }
}