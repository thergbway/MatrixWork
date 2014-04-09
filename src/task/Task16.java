package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task16 extends Task {
    public Task16(){
        super("#16");
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
                appendText("Матрица, в которой строки переставлены в порядке увеличения их суммы: \n\n" +
                        m.getMatrixWithIncreasingRowSums() + "\n\n");
            }
        }).start();
    }
}