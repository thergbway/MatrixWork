package task;

import matrix.Matrix;

public class Task14 extends Task {
    public Task14(){
        super("#14");
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
                textArea.append("Матрица с округленными до целого числа элементами : \n\n" + m.showWithIntValues());
            }
        }).start();
    }
}