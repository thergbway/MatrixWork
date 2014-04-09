package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task11 extends Task {
    public Task11(){
        super("#11");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                appendText("Введено " + value + "\n");
                Matrix m= MatrixUtils.getRandomizedMatrixWithZeroes(value, 60);
                appendText("Исходная матрица : \n\n" + m + "\n\n");
                m.removeZeroRowsAndColumns();
                appendText("Матрица без нулевых строчек и столбцов : \n\n" + m);
            }
        }).start();
    }
}