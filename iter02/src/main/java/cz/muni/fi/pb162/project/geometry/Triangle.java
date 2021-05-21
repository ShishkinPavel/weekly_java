package cz.muni.fi.pb162.project.geometry;

/**
 * Class for running main method.
 *
 * @author Pavel Shishkin
 */

public class Triangle {
    private Vertex2D[] arrayOfVertices = new Vertex2D[3];
    private Triangle[] arrayOfTriangles = new Triangle[3];

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
     * @return null or vert
     * @param index is index
     */
    public Vertex2D getVertex(int index){
        if (-1<index && index<3){
            return arrayOfVertices[index];
        }
        return null;
    }

    /**
     * add vert
     * @param vertex is vertex
     * @param index is index
     */
    public void setVertex(int index, Vertex2D vertex){
        if (-1<index && index<3){
            arrayOfVertices[index] = vertex;
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
}
