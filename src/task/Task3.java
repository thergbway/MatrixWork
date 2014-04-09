package task;

import matrix.Matrix;
import matrix.MatrixUtils;

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
                setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                appendText("Введено " + value + "\n");

                Matrix m= MatrixUtils.getRandomizedMatrix(value);
                appendText("Исходная матрица: \n\n" + m + "\n\n");
                Float[] sequence = m.getMaxIncreasingElements();
                appendText("Наибольшее число возрастающих элементов, идущих подряд: \n\n" + Arrays.toString(sequence) + "\n\n");
            }
        }).start();
    }
}