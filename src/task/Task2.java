package task;

import matrix.Matrix;

public class Task2 extends Task {
    public Task2(){
        super("#2");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                textArea.setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int value= readInt();
                textArea.append("Введено " + value + "\n");
                textArea.append("Пожалуйста, введите число- величину сдвига\n");
                int shift= readInt();
                textArea.append("Введено " + shift + "\n");

                Matrix m= Matrix.getRandomizedMatrix(value);

                textArea.append("Исходная матрица: \n\n" + m + "\n\n");
                textArea.append("Матрица после сдвига влево: \n\n" + new Matrix(m).leftShift(shift) + "\n\n");
                textArea.append("Матрица после сдвига вправо: \n\n" + new Matrix(m).rightShift(shift) + "\n\n");
                textArea.append("Матрица после сдвига вверх: \n\n" + new Matrix(m).upShift(shift) + "\n\n");
                textArea.append("Матрица после сдвига вниз: \n\n" + new Matrix(m).downShift(shift) + "\n\n");
            }
        }).start();
    }
}
