package task;

import matrix.Matrix;

public class Task16 extends Task {
    public Task16(){
        super("#16");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                textArea.setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                textArea.append("Введено " + value + "\n");
                Matrix m= Matrix.getRandomizedMatrix(value);
                textArea.append("Исходная матрица: \n\n" + m + "\n\n");
                textArea.append("Матрица, в которой строки переставлены в порядке увеличения их суммы: \n\n" +
                        m.getMatrixWithIncreasingRowSums() + "\n\n");
            }
        }).start();
    }
}