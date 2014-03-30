package task;

import matrix.Matrix;

public class Task17 extends Task {
    public Task17(){
        super("#17");
    }
    @Override
    public void execute() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                textArea.setText("Пожалуйста, введите число- размерность квадратной матрицы\n");
                int matrixSize= readInt();
                textArea.append("Введено " + matrixSize + "\n");

                Matrix m= Matrix.getRandomizedMatrix(matrixSize);
                textArea.append("Исходная матрица: \n\n" + m + "\n\n");
                textArea.append("Число локальных минимумов для данной матрицы\n" +
                        "(число точек, угловые и соседние элементы которой строго больше её значения): " +
                        m.getLocalMinimumCount());
            }
        }).start();
    }
}