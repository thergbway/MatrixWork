package task;

import matrix.Matrix;

public class Task10 extends Task {
    public Task10(){
        super("#10");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                textArea.setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                textArea.append("Введено " + value + "\n");
                Matrix m= Matrix.getRandomizedMatrixWithDuplicates(value, value, 20);
                textArea.append("Исходная матрица : \n\n" + m + "\n\n");
                m.removeRowAndColumnsWithMaximum();
                textArea.append("Матрица без строчек и столбцов содержащих максимальный элемент : \n\n" + m);
            }
        }).start();
    }
}