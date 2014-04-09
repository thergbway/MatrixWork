package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task6 extends Task {
    public Task6(){
        super("#6");
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
                appendText("Норма матрицы: " + m.getEuclidNorm() + "\n");
            }
        }).start();
    }
}
