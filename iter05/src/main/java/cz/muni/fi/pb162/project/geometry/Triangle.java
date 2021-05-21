package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * Class for running main method.
 *
 * @author Pavel Shishkin
 */

public class Triangle implements Measurable{
    private final Vertex2D[] arrayOfVertices;
    private final Triangle[] arrayOfTriangles = new Triangle[3];

    /**
     * create a triangle
     * @param v1 is v1
     * @param v2 is v2
     * @param v3 is v3
     */

    public Triangle(Vertex2D v1, Vertex2D v2, Vertex2D v3){
        arrayOfVertices = new Vertex2D[] {v1, v2, v3};

    }

    /**
     * create a triangle
     * @param v1 is v1
     * @param v2 is v2
     * @param v3 is v3
     * @param depth is depth
     */
    public Triangle(Vertex2D v1, Vertex2D v2, Vertex2D v3, int depth){
        arrayOfVertices = new Vertex2D[]{v1, v2, v3};
        divide(depth);

    }
    /**
     * @return null or vert
     * @param index is index
     */
    public Vertex2D getVertex(int index){
        if (-1<index && index<3){
            return arrayOfVertices[index];
        }
        return null;
    }

    boolean isEquilateral(){
        double d1 = arrayOfVertices[0].distance(arrayOfVertices[1]);
        double d2 = arrayOfVertices[0].distance(arrayOfVertices[2]);
        double d3 = arrayOfVertices[1].distance(arrayOfVertices[2]);

        return Math.abs(d1-d2) < 0.001 &&
                Math.abs(d1-d3) < 0.001 &&
                Math.abs(d3-d2) < 0.001;
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
    public String toString() {
        return "Triangle: vertices=" + arrayOfVertices[0] + " " +
                arrayOfVertices[1] + " " +  arrayOfVertices[2];
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
        arrayOfTriangles[0] = new Triangle(arrayOfVertices[0],
                arrayOfVertices[0].createMiddle(arrayOfVertices[1]),
                arrayOfVertices[0].createMiddle(arrayOfVertices[2]));
        arrayOfTriangles[1] = new Triangle(arrayOfVertices[1],
                arrayOfVertices[1].createMiddle(arrayOfVertices[0]),
                arrayOfVertices[1].createMiddle(arrayOfVertices[2]));
        arrayOfTriangles[2] = new Triangle(arrayOfVertices[2],
                arrayOfVertices[2].createMiddle(arrayOfVertices[1]),
                arrayOfVertices[2].createMiddle(arrayOfVertices[0]));
        return true;
    }

    /**
     * @return null or subtriangle
     * @param index is index
     */
    public Triangle getSubTriangle(int index){
        if (-1<index && index<3) {
            return arrayOfTriangles[index];
        }
        return null;
    }


    @Override
    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

    @Override
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }
}
