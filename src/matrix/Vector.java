package matrix;

public class Vector implements Cloneable{
    private float[] coord;

    public Vector(float... coord){
        this.coord= coord.clone();
    }
    public Vector(int dimension){
        coord= new float[dimension];
    }
    public Vector(Vector v){
        coord= v.coord.clone();
    }

    public void setCoord(int index, float value){
        coord[index]= value;
    }
    public float getCoord(int index){
        return coord[index];
    }
    public int size(){
        return coord.length;
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
            str.append(String.format("%15.8f", coord[i]));
            str.append(" ");
        }

        str.append(" ");
        str.append(String.format("%15.8f", coord[coord.length - 1]));
        str.append("]");
        return str.toString();
    }
}