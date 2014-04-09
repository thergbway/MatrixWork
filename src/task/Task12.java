package task;

import matrix.Matrix;
import matrix.MatrixUtils;

public class Task12 extends Task {
    public Task12(){
        super("#12");
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

                int rowIndex= -1;
                appendText("Пожалуйста, введите число- индекс строки, в которую будет перемещен минимум\n");
                rowIndex= readInt();
                while(rowIndex < 0 || rowIndex >= value){
                    appendText("Введено неправильное число, попробуйте ещё раз\n");
                    rowIndex= readInt();
                }
                appendText("Введено " + rowIndex + "\n");

                int columnIndex= -1;
                appendText("Пожалуйста, введите число- индекс столбца, в которую будет перемещен минимум\n");
                columnIndex= readInt();
                while(columnIndex < 0 || columnIndex >= value){
                    appendText("Введено неправильное число, попробуйте ещё раз\n");
                    columnIndex= readInt();
                }
                appendText("Введено " + columnIndex + "\n");

                appendText("Позиция перемещения минимума матрицы: (" + rowIndex + "; " + columnIndex + ")" + "\n");
                appendText("Исходная матрица : \n\n" + m + "\n\n");
                m.setMinToPosition(rowIndex, columnIndex);
                appendText("Матрица c перемещенным минимумом : \n\n" + m);
            }
        }).start();
    }
}