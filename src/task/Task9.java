package task;

import matrix.Matrix;

public class Task9 extends Task {
    public Task9(){
        super("task.Task 9");
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
                m.decreaseAllRowValuesAtRowAverage();
                textArea.append("После вычета из элементов каждой строки матрицы её среднего арифметического: \n\n" +
                    m + "\n\n");
            }
        }).start();
    }
}