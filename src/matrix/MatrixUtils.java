package matrix;

import java.util.Random;

/**
 * Содержит функции для генерации матриц и др.
 */
public class MatrixUtils {

    /**
     * Генерация матрицы случайных чисел
     *
     * @param dimension размерность
     * @return квадратная матрица случайных чисел
     */
    public static Matrix getRandomizedMatrix(int dimension) {
        return getRandomizedMatrixWithZeroes(dimension, 0);
    }

    /**
     * Генерация матрицы случайных чисел с преоблажанием нулей
     *
     * @param dimension      размерность
     * @param zeroPercentage процент нулевых элементов(от 0 до 100)
     * @return квадратная матрица случайных чисел c преобладанием нулей
     */
    public static Matrix getRandomizedMatrixWithZeroes(int dimension, int zeroPercentage) {
        return getRandomizedMatrixWithDuplicates(dimension, 0.0f, zeroPercentage);
    }

    /**
     * Генерация квадратной матрицы случайных чисел с дублями
     *
     * @param dimension           размерность
     * @param duplicatesValue     значение элементов - дублей
     * @param duplicatePercentage частота появления дубля
     * @return квадратная матрица случайных чисел с дублями
     */
    public static Matrix getRandomizedMatrixWithDuplicates(int dimension, float duplicatesValue, int duplicatePercentage) {
        Matrix rlt = new Matrix(dimension);
        Matrix.Iterator it = rlt.new Iterator();
        Random rand = new Random();
        final int MAX_PERCENT = 101;

        while (it.hasNext()) {
            it.next();
            float newValue;
            if (rand.nextInt(MAX_PERCENT) < duplicatePercentage)
                newValue = duplicatesValue;
            else
                newValue = rand.nextFloat() * 2.0f * dimension - dimension;
            it.set(newValue);
        }

        return rlt;
    }
}
