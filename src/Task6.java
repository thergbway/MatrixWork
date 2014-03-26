import matrix.Matrix;

class Task6 extends Task{
    public Task6(){
        super("Task 6");
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
                textArea.append("Норма матрицы: " + m.getEuclidNorm() + "\n");
            }
        }).start();
    }
}
