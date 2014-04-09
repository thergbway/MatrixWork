package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task8 extends Task {
    public Task8(){
        super("#8");
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
                appendText("Определитель матрицы: " + m.getDeterminant() + "\n\n");
            }
        }).start();
    }
}