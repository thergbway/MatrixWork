package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task19 extends Task {
    public Task19(){
        super("#19");
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
                appendText("Матрица, в которой столбцы переставлены в порядке убывания их характеристик: \n\n" +
                        m.getMatrixWithIncreasingCharacteristic() + "\n\n");
            }
        }).start();
    }
}