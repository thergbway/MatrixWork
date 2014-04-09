package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task1 extends Task {
    public Task1(){
        super("#1");
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

                int columnIndex= -1;
                appendText("Пожалуйста, введите число- индекс столбца, относительно которого производить упорядочение\n");
                columnIndex= readInt();
                while(columnIndex < 0 || columnIndex >= value){
                    appendText("Введено неправильное число, попробуйте ещё раз\n");
                    columnIndex= readInt();
                }
                appendText("Введено " + columnIndex + "\n");
                appendText("Исходная матрица: \n\n" + m + "\n\n");
                m.sortRowsByColumn(columnIndex);
                appendText("Матрица упорядоченных по столбцу строк: \n\n" + m + "\n\n");
            }
        }).start();
    }
}