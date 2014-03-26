package matrix;

import java.util.NoSuchElementException;
import java.util.Random;

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
    public Matrix(int dimension){
        //validation
        if(dimension< 1)
            throw new IllegalArgumentException("dimension must be positive");

        vectors= new Vector[dimension];
        for (int i = 0; i < vectors.length; i++) {
            vectors[i]= new Vector(dimension);
        }
    }

    public void setValue(int row, int column, float value){
        vectors[row].setCoord(column,value);
    }
    public void setVectorRaw(int row, Vector value){
        vectors[row]= value.clone();
    }
    public void setVectorColumn(int column, Vector value){
        for(int i=0; i< vectors.length; ++i)
            setValue(i, column, value.getCoord(i));
    }

    public float getValue(int row, int column){
        return vectors[row].getCoord(column);
    }
    public Vector getVectorRaw(int row){
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