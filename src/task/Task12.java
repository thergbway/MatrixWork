package task;

import matrix.Matrix;

public class Task12 extends Task {
    public Task12(){
        super("#12");
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

                int rowIndex= -1;
                textArea.append("Пожалуйста, введите число- индекс строки, в которую будет перемещен минимум\n");
                rowIndex= readInt();
                while(rowIndex < 0 || rowIndex >= value){
                    textArea.append("Введено неправильное число, попробуйте ещё раз\n");
                    rowIndex= readInt();
                }
                textArea.append("Введено " + rowIndex + "\n");

                int columnIndex= -1;
                textArea.append("Пожалуйста, введите число- индекс столбца, в которую будет перемещен минимум\n");
                columnIndex= readInt();
                while(columnIndex < 0 || columnIndex >= value){
                    textArea.append("Введено неправильное число, попробуйте ещё раз\n");
                    columnIndex= readInt();
                }
                textArea.append("Введено " + columnIndex + "\n");

                textArea.append("Позиция перемещения минимума матрицы: (" + rowIndex + "; " + columnIndex + ")" + "\n");
                textArea.append("Исходная матрица : \n\n" + m + "\n\n");
                m.setMinToPosition(rowIndex, columnIndex);
                textArea.append("Матрица c перемещенным минимумом : \n\n" + m);
            }
        }).start();
    }
}