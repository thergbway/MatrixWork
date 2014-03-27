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
        vectors= m.vectors.clone();
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

    public float getColumnCharacteristic(int columnIndex){
        float result= 0.0f;
        for (int i = 0; i < vectors.length; i++)
            result+= abs(getValue(i, columnIndex));
        return result;
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
     *
     * @param dimension размерность
     * @return квадратная матрица случайных чисел
     */
    public static Matrix getRandomizedMatrix(int dimension){
        Matrix rlt= new Matrix(dimension);
        Matrix.Iterator it= rlt.new Iterator();
        Random rand= new Random();

        while(it.hasNext()){
            it.next();
            it.set(rand.nextFloat()*2.0f*dimension - dimension);
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
    }
}