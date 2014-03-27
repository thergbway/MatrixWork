import matrix.Matrix;

class Task7 extends Task{
    public Task7(){
        super("Task 7");
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
                textArea.append("Повернутая на 90 градусов матрица: \n\n" + m.get90DegreeTurnedMatrix() + "\n\n");
                textArea.append("Повернутая на 180 градусов матрица: \n\n" + m.get180DegreeTurnedMatrix() + "\n\n");
                textArea.append("Повернутая на 270 градусов матрица: \n\n" + m.get270DegreeTurnedMatrix() + "\n\n");
            }
        }).start();
    }
}
