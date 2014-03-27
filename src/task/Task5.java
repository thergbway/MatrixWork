package task;

import matrix.Matrix;

public class Task5 extends Task {
    public Task5(){
        super("task.Task 5");
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
                textArea.append("Транспонированная матрица: \n\n" + m.getTransposedMatrix() + "\n");
            }
        }).start();
    }
}