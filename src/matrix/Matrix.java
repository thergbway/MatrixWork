package matrix;

import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Matrix{
    private Vector[] vectors;

    public Matrix(Vector... vectors){
        //validation
        if(vectors.length == 0)
            throw new IllegalArgumentException("Cannot create matrix without any vector or dimension");
        for(Vector v: vectors){
            if(v.size() != vectors[0].size())
                throw new IllegalArgumentException("All vectors of matrix must have the same sizes");
        }

        this.vectors= vectors.clone();
    }
    /**
     * Создание квадратной матрицы выбранного размера
     * @param dimension размер одной из сторон
     */
    public Matrix(int dimension){
        //validation
        if(dimension< 1)
            throw new IllegalArgumentException("dimension must be positive");

        vectors= new Vector[dimension];
        for (int i = 0; i < vectors.length; i++) {
            vectors[i]= new Vector(dimension);
        }
    }
    public Matrix(int rows, int columns){
        //validation
        if(rows < 1 || columns < 1)
            throw new IllegalArgumentException("rows and columns must be positive");

        vectors= new Vector[rows];
        for (int i = 0; i < vectors.length; i++) {
            vectors[i]= new Vector(columns);
        }
    }
    public Matrix(Matrix m){
        vectors= new Vector[m.vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = m.vectors[i].clone();
        }
    }

    /**
     * Устанавливает на указанное место в матрице её минимальный элемент,
     * а на его месте - указанный элемент
     * @param row индекс строки
     * @param column индекс столбца
     */
    public void setMinToPosition(int row, int column){
        int minIndexRow = -1;
        int minIndexColumn = -1;

        float currentMin= Float.POSITIVE_INFINITY;
        for (int i = 0; i < vectors.length; i++) {
            for (int j = 0; j < vectors[0].size(); j++) {
                if(currentMin >= getValue(i, j)){
                    minIndexRow = i;
                    minIndexColumn = j;
                    currentMin = getValue(i, j);
                }
            }
        }

        swapColumns(minIndexColumn, column);
        swapRows(minIndexRow, row);
    }

    public void setValue(int row, int column, float value){
        vectors[row].setCoord(column,value);
    }
    public void setVectorRow(int row, Vector value){
        vectors[row]= value.clone();
    }
    public void setVectorColumn(int column, Vector value){
        for(int i=0; i< vectors.length; ++i)
            setValue(i, column, value.getCoord(i));
    }

    public float getValue(int row, int column){
        return vectors[row].getCoord(column);
    }
    public Vector getVectorRow(int row){
        return vectors[row].clone();
    }
    public Vector getVectorColumn(int column){
        Vector result= new Vector(vectors.length);
        for(int i=0; i<vectors.length; ++i)
            result.setCoord(i, vectors[i].getCoord(column));
        return result;
    }
    public Matrix getTransposedMatrix(){
        Vector[] vecs= new Vector[vectors[0].size()];
        for(int i=0; i< vecs.length; ++i)
            vecs[i]= getVectorColumn(i);
        return new Matrix(vecs);
    }

    /**
     * Finds one dimension array representing this matrix
     * @return such array
     */
    private float[] getOneDimensionArray(){
        final int diagonalSize= vectors.length;
        float[] values= new float[diagonalSize * diagonalSize];
        Iterator it= new Iterator();
        for (int i = 0; i < values.length; i++) {
            values[i]= it.next();
        }
        return values;
    }

    /**
     * Finds two dimension array representing this matrix
     * @return such array
     */
    private float[][] getTwoDimensionArray(){
        final int diagonalSize= vectors.length;
        float[][] values= new float[diagonalSize][diagonalSize];
        Iterator it = new Iterator();

        for (int i = 0; i < diagonalSize; i++) {
            for (int j = 0; j < diagonalSize; j++) {
                values[i][j] = it.next();
            }
        }

        return values;
    }

    /**
     * Обменять строки матрицы
     * @param indexA номер первой строки
     * @param indexB номер второй строки
     */
    public void swapRows(int indexA, int indexB){
        Vector a= getVectorRow(indexA);
        Vector b= getVectorRow(indexB);
        setVectorRow(indexB, a);
        setVectorRow(indexA, b);
    }

    /**
     * Поиск максимально длинной последовательности увеличивающихся элементов матрицы, идущих подряд
     * @return найденная последовательность
     */
    public Float[] getMaxIncreasingElements(){
        List<Float> maxSequence = new LinkedList<Float>();
        List<Float> list = new LinkedList<Float>();
        Iterator it = new Iterator();
        float current = 0.0f;

        while (it.hasNext()){
            current = it.next();
            if(list.isEmpty() || list.get(list.size() - 1) <= current)
                list.add(current);
            else{
                if(maxSequence.size() < list.size()) {
                    maxSequence.clear();
                    maxSequence.addAll(list);
                }
                list.clear();
                list.add(current);
            }
        }
        if(maxSequence.size() < list.size()) {
            maxSequence.clear();
            maxSequence.addAll(list);
        }
        return maxSequence.toArray(new Float[0]);
    }

    /**
     * Обменять столбцы матрицы
     * @param indexA номер первого столбца
     * @param indexB номер второго столбца
     */
    public void swapColumns(int indexA, int indexB){
        Vector a= getVectorColumn(indexA);
        Vector b= getVectorColumn(indexB);
        setVectorColumn(indexB, a);
        setVectorColumn(indexA, b);
    }

    public void swapElements(int rowA, int columnA, int rowB, int columnB){
        final float temp= vectors[rowA].getCoord(columnA);
        vectors[rowA].setCoord(columnA, vectors[rowB].getCoord(columnB));
        vectors[rowB].setCoord(columnB, temp);
    }

    /**
     *
     * @return повернутая на 90 градусов против часовой стрелки матрица
     */
    public Matrix get90DegreeTurnedMatrix(){
        Matrix result= new Matrix(vectors[0].size(), vectors.length);
        for (int i = 0; i < vectors[0].size(); i++) {
            result.setVectorRow(vectors[0].size() - 1 - i, getVectorColumn(i));
        }
        return result;
    }

    /**
     *
     * @return повернутая на 180 градусов против часовой стрелки матрица
     */
    public Matrix get180DegreeTurnedMatrix(){
        return get90DegreeTurnedMatrix().get90DegreeTurnedMatrix();
    }

    /**
     *
     * @return повернутая на 270 градусов против часовой стрелки матрица
     */
    public Matrix get270DegreeTurnedMatrix(){
        return get180DegreeTurnedMatrix().get90DegreeTurnedMatrix();
    }

    /**
     * Вычислить среднее арифметическое строки с указанным индексом
     * @param rowIndex индекс строки
     * @return среднее арифметическое
     */
    public float getRowAverage(int rowIndex){
        float result = 0;
        Vector v= getVectorRow(rowIndex);
        for (int i = 0; i < v.size(); i++) {
            result+= v.getCoord(i);
        }
        return result/v.size();
    }

    /**
     * Уменьшает значение каждого элемента строки на среднее арифметическое это строки
     * @param rowIndex индекс строки
     */
    public void decreaseRowValuesAtRowAverage(int rowIndex){
        float average= getRowAverage(rowIndex);
        for (int i = 0; i < vectors[0].size(); i++) {
            setValue(rowIndex, i, getValue(rowIndex, i) - average);
        }
    }

    /**
     * Уменьшает значения всех элементов матрицы на величину среднего арифметического, вычисленного для каждой строки
     */
    public void decreaseAllRowValuesAtRowAverage(){
        for (int i = 0; i < vectors.length; i++) {
            decreaseRowValuesAtRowAverage(i);
        }
    }

    /**
     * Задание 20. Возвращает матрицу, в которой главная диагональ
     * заполнена убывающими элементами, начиная с максимального в позиции [0;0]
     * @return Искомая матрица
     */
    public Matrix getMatrixOfIncreasingDiagonalValues(){
        //validation
        if(vectors.length != vectors[0].size())
            throw new IllegalArgumentException("Matrix must be square one");

        Matrix result= new Matrix(this);
        final int diagonalSize= vectors.length;

        float[] maxValues= result.getOneDimensionArray();
        Arrays.sort(maxValues);//ascending order

        for (int i = 0; i < diagonalSize; i++) {
            Iterator it= result.new Iterator();
            while (it.hasNext()){
                if(maxValues[maxValues.length - 1 - i] == it.next())
                    break;
            }
            result.swapElements(i, i, it.getCurrRow(), it.getCurrColumn());
        }

        return result;
    }

    /**
     * Поиск количеств элементов- локальных минимумов
     * Для задания 17
     * @return количество локальных минимумов
     */
    public int getLocalMinimumCount(){
        if(vectors.length < 3 || vectors[0].size() < 3)
            return 0;

        int localMinimumCount= 0;

        for (int i = 1; i < vectors.length - 1; i++) {
            for (int j = 1; j < vectors[0].size() - 1; j++) {
                float current= getValue(i, j);

                float v1= getValue(i - 1, j - 1);
                float v2= getValue(i - 1, j);
                float v3= getValue(i - 1, j + 1);
                float v4= getValue(i, j - 1);
                float v5= getValue(i, j + 1);
                float v6= getValue(i + 1, j - 1);
                float v7= getValue(i + 1, j);
                float v8= getValue(i+1, j+1);

                if(current < v1 &&
                        current < v2 &&
                        current < v3 &&
                        current < v4 &&
                        current < v5 &&
                        current < v6 &&
                        current < v7 &&
                        current < v8)
                    ++localMinimumCount;
            }
        }
        return localMinimumCount;
    }

    /**
     * Поиск количеств элементов- локальных максимумов
     * Для задания 18
     * @return массив локальных максимумов
     */
    public Float[] getLocalMaximums(){
        if(vectors.length < 3 || vectors[0].size() < 3)
            return new Float[0];

        ArrayList<Float> maximums = new ArrayList<Float>();

        for (int i = 1; i < vectors.length - 1; i++) {
            for (int j = 1; j < vectors[0].size() - 1; j++) {
                float current= getValue(i, j);

                float v1= getValue(i - 1, j - 1);
                float v2= getValue(i - 1, j);
                float v3= getValue(i - 1, j + 1);
                float v4= getValue(i, j - 1);
                float v5= getValue(i, j + 1);
                float v6= getValue(i + 1, j - 1);
                float v7= getValue(i + 1, j);
                float v8= getValue(i+1, j+1);

                if(current > v1 &&
                        current > v2 &&
                        current > v3 &&
                        current > v4 &&
                        current > v5 &&
                        current > v6 &&
                        current > v7 &&
                        current > v8)
                    maximums.add(current);
            }
        }
        return maximums.toArray(new Float[0]);
    }

    /**
     * Поиск максимального из локальных максимумов
     * Для задания 18
     * @return искомый максимум или NaN, если максимум не найден
     */
    public float getMaxLocalMaximum(){
        Float[] maximums= getLocalMaximums();

        if(maximums.length == 0)
            return Float.NaN;

        Arrays.sort(maximums);

        return maximums[maximums.length - 1];
    }

    /**
     *
     * @return евклидова норма матрицы
     */
    public float getEuclidNorm(){
        float result= 0;
        Iterator it= new Iterator();

        while(it.hasNext()){
            result+= Math.pow(it.next(), 2.0);
        }
        return (float)Math.sqrt(result);
    }

    /**
     * Возвращает определитель квадратной матрицы
     * @return определитель квадратной матрицы
     */
    public double getDeterminant(){
        //validation
        if(vectors.length != vectors[0].size())
            throw new IllegalArgumentException("Not square matrix");

        if(vectors.length == 1 && vectors[0].size() == 1)
            return getValue(0, 0);

        double result= 0;
        for(int j= 0; j< vectors[0].size(); ++j){
            Matrix currentMinor= new Matrix(this);
            currentMinor.removeRow(0);
            currentMinor.removeColumn(j);
            result+= pow(-1.0, 1 + j + 1) * getValue(0, j) * currentMinor.getDeterminant();
        }
        return result;
    }

    /**
     * Для задания 16. Построение матрицы, у которой суммы каждой строки увеличиваются
     * @return матрица, у которой суммы каждой строки увеличиваются
     */
    public Matrix getMatrixWithIncreasingRowSums(){
        Map<Float, Vector> map= new TreeMap<Float, Vector>();
        for (int i = 0; i < vectors.length; i++) {
            map.put(getRowSum(i), getVectorRow(i));
        }
        Collection<Vector> vectorCollection= map.values();
        Vector[] vectors= vectorCollection.toArray(new Vector[0]);
        return new Matrix(vectors);
    }

    /**
     * Поиск количества седловых точек матрицы.
     * Для задания 15.
     * @return количество седловых точек матрицы
     */
    public int getSaddlePointCount(){
        int saddlePointCount= 0;

        for (int i = 0; i < vectors.length; i++) {
            for (int j = 0; j < vectors[0].size(); j++) {
                Vector row= getVectorRow(i);
                Vector column= getVectorColumn(j);

                if(row.isMin(j) && column.isMax(i))
                    ++saddlePointCount;
            }
        }
        return saddlePointCount;
    }

    /**
     * Возвращает матрицу, в которой столбцы идут в порядке увеличения их характеристок
     * Характеристика столбца- сумма модулей его элементов
     * Необходима для 19 задания
     * @return Искомая матрица
     */
    public Matrix getMatrixWithIncreasingCharacteristic(){
        Map<Float, Vector> map= new TreeMap<Float, Vector>();
        for (int i = 0; i < vectors[0].size(); i++)
            map.put(getColumnCharacteristic(i), getVectorColumn(i));
        Collection<Vector> newVectorCollection= map.values();
        Object[] newVectorObjects= newVectorCollection.toArray();
        Vector[] newVectors= new Vector[newVectorObjects.length];
        for (int i = 0; i < newVectors.length; i++) {
            newVectors[i]= (Vector)newVectorObjects[i];

        }

        Matrix temp= new Matrix(newVectors);
        return temp.get270DegreeTurnedMatrix();
    }

    /**
     * Возвращает матрицу, в которой элементы равные нулю располагаются в конце строк
     * @return искомая матрица
     */
    public Matrix getMatrixWithZeroEndingRows(){
        Matrix rlt= new Matrix(this);

        for (int i = 0; i < vectors.length; i++) {
            List<Float> nonZeroList= new ArrayList<Float>();
            List<Float> zeroList= new ArrayList<Float>();
            for (int j = 0; j < vectors[0].size(); j++) {
                float current = getValue(i, j);
                if(current == 0.0f)
                    zeroList.add(current);
                else
                    nonZeroList.add(current);
            }
            List<Float> finalList= new ArrayList<Float>();
            finalList.addAll(nonZeroList);
            finalList.addAll(zeroList);

            Float[] currentVector= finalList.toArray(new Float[0]);
            float[] currentVectorPrimitive= new float[currentVector.length];
            for (int p = 0; p < currentVectorPrimitive.length; p++)
                currentVectorPrimitive[p]= currentVector[p];
            rlt.setVectorRow(i, new Vector(currentVectorPrimitive));
        }

        return rlt;
    }

    public float getColumnCharacteristic(int columnIndex){
        float result= 0.0f;
        for (int i = 0; i < vectors.length; i++)
            result+= abs(getValue(i, columnIndex));
        return result;
    }

    /**
     * Удаляет из матрицы нулевые строки и столбцы
     */
    public void removeZeroRowsAndColumns(){
        for (int i = vectors.length - 1; i >= 0; --i)
            if(vectors[i].isZero())
                removeRow(i);

        if(vectors.length > 0)
            for (int i = vectors[0].size() - 1; i >= 0 ; --i)
                if(getVectorColumn(i).isZero())
                    removeColumn(i);
    }

    /**
     * Поиск суммы элементов строки матрицы
     * @param rowIndex индекс строки
     * @return сумма элементов строки
     */
    public float getRowSum(int rowIndex){
        float sum = 0.0f;
        for (int i = 0; i < vectors[0].size(); i++) {
            sum += getValue(rowIndex, i);
        }
        return sum;
    }

    /**
     * Создание массива сумм элементов матрицы между первым и вторым положительным элементом каждой строки
     * Для задания 4
     * @return массив сумм
     */
    public Float[] getSumBetweenEachPositivesForRows(){
        List<Float> sumsList = new LinkedList<Float>();

        for (int i = 0; i < vectors.length; i++) {
            int foundPositives = 0;
            float rowSum = 0.0f;
            for (int j = 0; j < vectors[i].size(); j++) {
                float current = vectors[i].getCoord(j);
                if(current > 0.0f){
                    ++foundPositives;
                    if(foundPositives == 1)
                        continue;
                    else
                        break;
                }
                if(foundPositives == 1)
                    rowSum += current;
            }
            if(foundPositives == 2)
                sumsList.add(rowSum);
            else
                sumsList.add(0.0f);
        }

        return sumsList.toArray(new Float[0]);
    }

    /**
     * Удаляет из матрицы строку
     * @param rowIndex индекс строки
     */
    public void removeRow(int rowIndex){
        Vector[] newVectors= new Vector[vectors.length - 1];
        for (int i = 0, j = 0; i < vectors.length; i++) {
            if(i != rowIndex){
                newVectors[j]= vectors[i].clone();
                ++j;
            }

        }
        vectors= newVectors;
    }

    /**
     * Удаление из матрицы всех столбцов и строк, содержащих максимальный элемент матрицы
     * Для задания 10
     */
    public void removeRowAndColumnsWithMaximum(){

        float currentMax= Float.NEGATIVE_INFINITY;
        for (int i = 0; i < vectors.length; i++) {
            for (int j = 0; j < vectors[0].size(); j++) {
                if(currentMax <= getValue(i, j))
                    currentMax= getValue(i, j);
            }
        }

        for (int i = vectors.length - 1; i >= 0 ; --i) {
            if(getVectorRow(i).isHolding(currentMax))
                removeRow(i);
        }

        if(vectors.length > 0)
            for (int i = vectors[0].size() - 1; i >= 0 ; --i) {
                if(getVectorColumn(i).isHolding(currentMax))
                    removeColumn(i);
            }
    }

    /**
     * Удаляет из матрицы столбец
     * @param columnIndex индекс столбца
     */
    public void removeColumn(int columnIndex){
        Matrix temp = get270DegreeTurnedMatrix();
        temp.removeRow(columnIndex);
        temp = temp.get90DegreeTurnedMatrix();
        vectors= temp.vectors;
    }

    /**
     * Генерация матрицы случайных чисел
     * @param dimension размерность
     * @return квадратная матрица случайных чисел
     */
    public static Matrix getRandomizedMatrix(int dimension){
        return getRandomizedMatrixWithZeroes(dimension, 0);
    }

    /**
     * Генерация матрицы случайных чисел с преоблажанием нулей
     * @param dimension размерность
     * @param zeroPercentage процент нулевых элементов(от 0 до 100)
     * @return квадратная матрица случайных чисел c преобладанием нулей
     */
    public static Matrix getRandomizedMatrixWithZeroes(int dimension, int zeroPercentage){
        return getRandomizedMatrixWithDuplicates(dimension, 0.0f, zeroPercentage);
    }

    /**
     * Генерация квадратной матрицы случайных чисел с дублями
     * @param dimension размерность
     * @param duplicatesValue значение элементов - дублей
     * @param duplicatePercentage частота появления дубля
     * @return квадратная матрица случайных чисел с дублями
     */
    public static Matrix getRandomizedMatrixWithDuplicates(int dimension, float duplicatesValue, int duplicatePercentage){
        Matrix rlt= new Matrix(dimension);
        Matrix.Iterator it= rlt.new Iterator();
        Random rand= new Random();

        while(it.hasNext()){
            it.next();
            float newValue;
            if(rand.nextInt(101) < duplicatePercentage)
                newValue= duplicatesValue;
            else
                newValue= rand.nextFloat()*2.0f*dimension - dimension;
            it.set(newValue);
        }

        return rlt;
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder("[\n");
        for(Vector v: vectors){
            str.append(v);
            str.append("\n");
        }
        str.append("]");
        return str.toString();
    }

    /**
     * Задание 14. Представить матрицу с округленными до целого числа элементами
     * @return строка с данным представлением
     */
    public String showWithIntValues(){
        StringBuilder str= new StringBuilder("[\n");
        for(Vector v: vectors){
            str.append(v.showWithIntValues());
            str.append("\n");
        }
        str.append("]");
        return str.toString();
    }

    /**
     * Для задания 1. Перемещает строки матрицы в порядке увеличения значений
     * элементов k-го столбца
     * @param columnIndex индекс столбца k
     */
    public void sortRowsByColumn(int columnIndex){
        Map<Float, Vector> map = new TreeMap<Float, Vector>();
        for (int i = 0; i < vectors.length; i++)
            map.put(vectors[i].getCoord(columnIndex), vectors[i]);
        Vector[] newVectors = new ArrayList<Vector>(map.values()).toArray(new Vector[0]);
        vectors = newVectors;
    }

    /**
     * Выполняет циклический сдвиг матрицы влево на shift позиций
     * Для задания 2
     * @param shift количество позиций для сдвига
     * @return ссылка на объект, у которого был вызван метод
     */
    public Matrix leftShift(int shift){
        final int matrixWidth= vectors[0].size();
        for (int i = 0; i < shift; i++) {
            for (int j = 1; j < matrixWidth; j++) {
                swapColumns(j-1, j);
            }
        }
        return this;
    }

    /**
     * Выполняет циклический сдвиг матрицы вправо на shift позиций
     * Для задания 2
     * @param shift количество позиций для сдвига
     * @return ссылка на объект, у которого был вызван метод
     */
    public Matrix rightShift(int shift){
        final int matrixWidth= vectors[0].size();
        for (int i = 0; i < shift; i++) {
            for (int j = matrixWidth-1; j >= 1 ; --j) {
                swapColumns(j, j-1);
            }
        }
        return this;
    }

    /**
     * Выполняет циклический сдвиг матрицы вверх на shift позиций
     * Для задания 2
     * @param shift количество позиций для сдвига
     * @return ссылка на объект, у которого был вызван метод
     */
    public Matrix upShift(int shift){
        final int matrixHeight= vectors.length;
        for (int i = 0; i < shift; i++) {
            for (int j = 1; j < matrixHeight; j++) {
                swapRows(j - 1, j);
            }
        }
        return this;
    }

    /**
     * Выполняет циклический сдвиг матрицы вниз на shift позиций
     * Для задания 2
     * @param shift количество позиций для сдвига
     * @return ссылка на объект, у которого был вызван метод
     */
    public Matrix downShift(int shift) {
        final int matrixHeight= vectors.length;
        for (int i = 0; i < shift; i++) {
            for (int j = matrixHeight-1; j >= 1 ; --j) {
                swapRows(j - 1, j);
            }
        }
        return this;
    }

    public class Iterator{
        private int row= 0;
        private int column= -1;

        public boolean hasNext(){
            return !(row == vectors.length-1 && column == vectors[0].size()-1);
        }
        public float next(){
            if(row == vectors.length-1 && column == vectors[0].size()-1)
                throw new NoSuchElementException();
            ++column;
            if(column == vectors[0].size()){
                column= 0;
                ++row;
            }
            return vectors[row].getCoord(column);
        }
        public void set(float value){
           vectors[row].setCoord(column, value);
        }
        public int getCurrRow(){
            return row;
        }
        public int getCurrColumn(){
            return column;
        }
    }
}