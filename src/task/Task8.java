package task;

import matrix.Matrix;

public class Task8 extends Task {
    public Task8(){
        super("task.Task 8");
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
                textArea.append("Определитель матрицы: " + m.getDeterminant() + "\n\n");
            }
        }).start();
    }
}