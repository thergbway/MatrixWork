package task;

import matrix.Matrix;

public class Task13 extends Task {
    public Task13(){
        super("#13");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                textArea.setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                textArea.append("Введено " + value + "\n");
                Matrix m= Matrix.getRandomizedMatrixWithZeroes(value, 20);
                textArea.append("Исходная матрица с нулями: \n\n" + m + "\n\n");
                textArea.append("Матрица с нулевыми элементами в конце строк : \n\n" + m.getMatrixWithZeroEndingRows());
            }
        }).start();
    }
}