package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task7 extends Task {
    public Task7(){
        super("#7");
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
                appendText("Повернутая на 90 градусов матрица: \n\n" + m.get90DegreeTurnedMatrix() + "\n\n");
                appendText("Повернутая на 180 градусов матрица: \n\n" + m.get180DegreeTurnedMatrix() + "\n\n");
                appendText("Повернутая на 270 градусов матрица: \n\n" + m.get270DegreeTurnedMatrix() + "\n\n");
            }
        }).start();
    }
}
