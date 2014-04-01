package matrix;

import java.util.Arrays;

import static java.lang.Math.round;

/**
 * Представляет из себя класс вектора с соответствующими ему функциями
 */
public class Vector implements Cloneable{
    private float[] coord;

    /**
     * Создание вектора по заданному содержимому
     * @param coord массив координат вектора
     */
    public Vector(float... coord){
        this.coord= coord.clone();
    }

    /**
     * Создание нулевого вектора с заданной размерностью
     * @param dimension размерность
     */
    public Vector(int dimension){
        coord= new float[dimension];
    }

    /**
     * Создание вектора - копии указанного
     * @param v вектор - прототип
     */
    public Vector(Vector v){
        coord= v.coord.clone();
    }

    /**
     * Изменение координаты вектора
     * @param index номер координаты
     * @param value устанавливаемое значение
     */
    public void setCoord(int index, float value){
        coord[index]= value;
    }

    /**
     * Получение соответствующей координамты
     * @param index номер координаты
     * @return значение координаты
     */
    public float getCoord(int index){
        return coord[index];
    }

    /**
     * Получение размера вектора
     * @return размер вектора
     */
    public int size(){
        return coord.length;
    }

    /**
     * Проверяет, является ли значение под указанным индексом в векторе максимальным
     * @param index индекс значения, которое должно быть проверено
     * @return результат проверки
     */
    public boolean isMax(int index){
        float value= coord[index];

        float[] ascendingValues= coord.clone();
        Arrays.sort(ascendingValues);

        boolean result= true;
        for (int i = 0; i < ascendingValues.length - 1; i++) {
            if(ascendingValues[i] >= value){
                result= false;
                break;
            }
        }

        return result;
    }

    /**
     * Проверяет, является ли значение под указанным индексом в векторе минимальным
     * @param index индекс значения, которое должно быть проверено
     * @return результат проверки
     */
    public boolean isMin(int index){
        float value= coord[index];

        float[] ascendingValues= coord.clone();
        Arrays.sort(ascendingValues);

        boolean result= true;
        for (int i = 1; i < ascendingValues.length; i++) {
            if(ascendingValues[i] <= value){
                result= false;
                break;
            }
        }

        return result;
    }

    /**
     * @return является ли вектор нулевым
     */
    public boolean isZero(){
        for(float value: coord)
            if(value != 0.0f)
                return false;
        return true;
    }

    /**
     * Проверяет, есть ли в векторе указанное значение
     * @param value значение для проверки
     * @return резульатат проверки
     */
    public boolean isHolding(float value){
        for(float val: coord)
            if(val == value)
                return true;
        return false;
    }

    @Override
    public Vector clone(){
        return new Vector(this);
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder("[");

        for(int i= 0; i < coord.length - 1; ++i){
            str.append(" ");
            str.append(String.format("%10.2f", coord[i]));
            str.append(" ");
        }

        str.append(" ");
        str.append(String.format("%10.2f", coord[coord.length - 1]));
        str.append("]");
        return str.toString();
    }

    /**
     * Для задания 14. Представить вектор с округленными до целого числа элементами
     * @return строка с данным представлением
     */
    public String showWithIntValues(){
        StringBuilder str= new StringBuilder("[");

        for(int i= 0; i < coord.length - 1; ++i){
            str.append(" ");
            str.append(String.format("%5d", round(coord[i])));
            str.append(" ");
        }

        str.append(" ");
        str.append(String.format("%5d", round(coord[coord.length - 1])));
        str.append("]");
        return str.toString();
    }
}