package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task14 extends Task {
    public Task14(){
        super("#14");
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
                appendText("Матрица с округленными до целого числа элементами : \n\n" + m.showWithIntValues());
            }
        }).start();
    }
}