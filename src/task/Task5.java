package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task5 extends Task {
    public Task5(){
        super("#5");
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
                appendText("Транспонированная матрица: \n\n" + m.getTransposedMatrix() + "\n");
            }
        }).start();
    }
}