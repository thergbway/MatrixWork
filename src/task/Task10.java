package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task10 extends Task {
    public Task10(){
        super("#10");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                appendText("Введено " + value + "\n");
                Matrix m= MatrixUtils.getRandomizedMatrixWithDuplicates(value, value, 20);
                appendText("Исходная матрица : \n\n" + m + "\n\n");
                m.removeRowAndColumnsWithMaximum();
                appendText("Матрица без строчек и столбцов содержащих максимальный элемент : \n\n" + m);
            }
        }).start();
    }
}