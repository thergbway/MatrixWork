package task;

import matrix.Matrix;

public class Task19 extends Task {
    public Task19(){
        super("task.Task 19");
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
                textArea.append("Матрица, в которой столбцы переставлены в порядке убывания их характеристик: \n\n" +
                       m.getMatrixWithIncreasingCharacteristic() + "\n\n");
            }
        }).start();
    }
}