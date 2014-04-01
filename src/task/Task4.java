package task;

import matrix.Matrix;

import java.util.Arrays;

public class Task4 extends Task {
    public Task4(){
        super("#4");
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
                Float[] sums = m.getSumBetweenEachPositivesForRows();
                textArea.append("Суммы элементов по каждой строке между первыми двумя положительными числами: \n\n" + Arrays.toString(sums) + "\n\n");
            }
        }).start();
    }
}