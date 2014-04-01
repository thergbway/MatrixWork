package task;

import matrix.Matrix;

import java.util.Arrays;

public class Task3 extends Task {
    public Task3(){
        super("#3");
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
                Float[] sequence = m.getMaxIncreasingElements();
                textArea.append("Наибольшее число возрастающих элементов, идущих подряд: \n\n" + Arrays.toString(sequence) + "\n\n");
            }
        }).start();
    }
}