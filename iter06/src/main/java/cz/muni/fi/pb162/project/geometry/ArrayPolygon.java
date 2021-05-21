package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;

/**
 *
 * @author Pavel Shishkin
 */

public class ArrayPolygon extends SimplePolygon {
    private final Vertex2D[] vertex2DS;
    /**
     * @param vertex2DS is list of vertex
     */
    public ArrayPolygon(Vertex2D[] vertex2DS){
        if (vertex2DS == null){
            throw new IllegalArgumentException("shouldn't be null");
        }
        if (vertex2DS.length < 3){
            throw new IllegalArgumentException("count should be >= 3");
        }
        if (Arrays.asList(vertex2DS).contains(null)){
            throw new IllegalArgumentException("null shouldn't be in list");
        }
        this.vertex2DS = Arrays.copyOf(vertex2DS, vertex2DS.length);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0){
            throw new IllegalArgumentException("index should be > 0");
        }
        return vertex2DS[index % vertex2DS.length];
    }

    @Override
    public int getNumVertices() {
        return vertex2DS.length;
    }

    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        ArrayPolygon arrayPolygon = (ArrayPolygon) object;
        return Arrays.equals(vertex2DS, arrayPolygon.vertex2DS);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vertex2DS);
    }
}
