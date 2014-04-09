package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task17 extends Task {
    public Task17(){
        super("#17");
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
                appendText("Число локальных минимумов для данной матрицы\n" +
                        "(число точек, угловые и соседние элементы которой строго больше её значения): " +
                        m.getLocalMinimumCount());
            }
        }).start();
    }
}