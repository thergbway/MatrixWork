package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task13 extends Task {
    public Task13(){
        super("#13");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                appendText("Введено " + value + "\n");
                Matrix m= MatrixUtils.getRandomizedMatrixWithZeroes(value, 20);
                appendText("Исходная матрица с нулями: \n\n" + m + "\n\n");
                appendText("Матрица с нулевыми элементами в конце строк : \n\n" + m.getMatrixWithZeroEndingRows());
            }
        }).start();
    }
}