package cz.muni.fi.pb162.project.geometry;

/**
 * Class for running main method.
 *
 * @author Pavel Shishkin
 */

public class Triangle extends ArrayPolygon{
    private static final double EPSILON = 0.001;
    private final Triangle[] arrayOfTriangles;

    /**
     * create a triangle
     * @param v1 is v1
     * @param v2 is v2
     * @param v3 is v3
     */

    public Triangle(Vertex2D v1, Vertex2D v2, Vertex2D v3){
        super(new Vertex2D[]{v1, v2, v3});
        arrayOfTriangles = new Triangle[3];
    }

    /**
     * create a triangle
     * @param v1 is v1
     * @param v2 is v2
     * @param v3 is v3
     * @param depth is depth
     */
    public Triangle(Vertex2D v1, Vertex2D v2, Vertex2D v3, int depth){
        this(v1, v2, v3);
        divide(depth);

    }


    private double[] getSideLenghts() {
        double[] sides = new double[3];
        for (int i = 0; i<getNumVertices(); i++){
            sides[i] = getVertex(i).distance(getVertex(i+1));
        }
        return sides;
    }


    void divide(int depth){
        if (depth<1) {
            return;
        }
        depth-=1;
        divide();
        for (Triangle triangle:arrayOfTriangles){
            triangle.divide(depth);

        }

    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Triangle: vertices=");
        for (int i = 0; i < getNumVertices(); i++){
            stringBuilder.append(getVertex(i)).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        return stringBuilder.toString();
    }

    public boolean isDivided(){
        return arrayOfTriangles[0] != null;
    }

    /**
     * @return false or true and create subtriangles
     */
    public boolean divide(){
        if (isDivided()){
            return false;
        }
        for (int i = 0;i<getNumVertices();i++){
            arrayOfTriangles[i] = new Triangle(
                    getVertex(i),
                    getVertex(i).createMiddle(getVertex(i+1)),
                    getVertex(i).createMiddle(getVertex(i+2)));
        }
        return true;
    }


    /**
     * @return false or true if equilateral
     */
    public boolean isEquilateral(){
        double[] sides = getSideLenghts();
        double etalon = sides[0];
        for (double i:sides){
            if (i - etalon > 0.01){
                return false;
            }
        }
        return true;
    }

    /**
     * @return null or subtriangle
     * @param index is index
     */
    public Triangle getSubTriangle(int index){
        if (-1<index && index<getNumVertices()) {
            return arrayOfTriangles[index];
        }
        return null;
    }



}
