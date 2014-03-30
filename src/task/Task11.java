package task;

import matrix.Matrix;

public class Task11 extends Task {
    public Task11(){
        super("#11");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                textArea.setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                textArea.append("Введено " + value + "\n");
                Matrix m= Matrix.getRandomizedMatrixWithZeroes(value, 60);
                textArea.append("Исходная матрица : \n\n" + m + "\n\n");
                m.removeZeroRowsAndColumns();
                textArea.append("Матрица без нулевых строчек и столбцов : \n\n" + m);
            }
        }).start();
    }
}