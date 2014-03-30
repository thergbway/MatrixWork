package task;

import matrix.Matrix;

public class Task18 extends Task {
    public Task18(){
        super("#18");
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
                float maxLocalMaximum= m.getMaxLocalMaximum();
                textArea.append("Наибольший среди локальных максимумов: ");
                if(!Float.isNaN(maxLocalMaximum))
                    textArea.append("" + maxLocalMaximum);
                else
                    textArea.append("не найдено");
            }
        }).start();
    }
}