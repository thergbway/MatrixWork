package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task18 extends Task {
    public Task18(){
        super("#18");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int matrixSize= readInt();
                appendText("Введено " + matrixSize + "\n");

                Matrix m= MatrixUtils.getRandomizedMatrix(matrixSize);
                appendText("Исходная матрица: \n\n" + m + "\n\n");
                float maxLocalMaximum= m.getMaxLocalMaximum();
                appendText("Наибольший среди локальных максимумов: ");
                if(!Float.isNaN(maxLocalMaximum))
                    appendText("" + maxLocalMaximum);
                else
                    appendText("не найдено");
            }
        }).start();
    }
}