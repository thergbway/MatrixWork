package task;

import matrix.Matrix;

public class Task20 extends Task {
    public Task20(){
        super("#20");
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
                textArea.append("Матрица, у которой элементы переставлены так, что её максимальный\n" +
                        "элемент находится в левом верхнем углу, следующий по величине - в позиции (2, 2),\n" +
                        "следующий - в позиции (3, 3), и так далее для всей диагонали:\n\n" +
                        m.getMatrixOfIncreasingDiagonalValues() + "\n\n");
            }
        }).start();
    }
}