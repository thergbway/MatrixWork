package task;

import matrix.Matrix;

public class Task1 extends Task {
    public Task1(){
        super("#1");
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

                int columnIndex= -1;
                textArea.append("Пожалуйста, введите число- индекс столбца, относительно которого производить упорядочение\n");
                columnIndex= readInt();
                while(columnIndex < 0 || columnIndex >= value){
                    textArea.append("Введено неправильное число, попробуйте ещё раз\n");
                    columnIndex= readInt();
                }
                textArea.append("Введено " + columnIndex + "\n");
                textArea.append("Исходная матрица: \n\n" + m + "\n\n");
                m.sortRowsByColumn(columnIndex);
                textArea.append("Матрица упорядоченных по столбцу строк: \n\n" + m + "\n\n");
            }
        }).start();
    }
}