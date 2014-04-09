package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task2 extends Task {
    public Task2(){
        super("#2");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                appendText("Введено " + value + "\n");
                appendText("Пожалуйста, введите число- величину сдвига\n");
                int shift= readInt();
                appendText("Введено " + shift + "\n");

                Matrix m= MatrixUtils.getRandomizedMatrix(value);

                appendText("Исходная матрица: \n\n" + m + "\n\n");
                appendText("Матрица после сдвига влево: \n\n" + new Matrix(m).leftShift(shift) + "\n\n");
                appendText("Матрица после сдвига вправо: \n\n" + new Matrix(m).rightShift(shift) + "\n\n");
                appendText("Матрица после сдвига вверх: \n\n" + new Matrix(m).upShift(shift) + "\n\n");
                appendText("Матрица после сдвига вниз: \n\n" + new Matrix(m).downShift(shift) + "\n\n");
            }
        }).start();
    }
}
