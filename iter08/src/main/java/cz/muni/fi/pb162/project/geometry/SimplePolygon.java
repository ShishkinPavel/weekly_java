package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.utils.SimpleMath;

import java.util.Arrays;

/**
 *
 * @author Pavel Shishkin
 */

public abstract class SimplePolygon implements Polygon{


    /**
     * @throws MissingVerticesException if count < 3
     * @param vertex2DS is array of vertices
     */
    public SimplePolygon(Vertex2D[] vertex2DS) throws MissingVerticesException {
        if (vertex2DS == null || Arrays.asList(vertex2DS).contains(null)){
            throw new IllegalArgumentException("null shouldn't be in list");
        }
        if (vertex2DS.length < 3){
            throw new MissingVerticesException("count of vertices must be > 3");
        }


    }


    @Override
    public double getHeight(){
        return Math.abs(SimpleMath.minY(this) - SimpleMath.maxY(this));
    }

    @Override
    public double getWidth(){
        return Math.abs(SimpleMath.minX(this) - SimpleMath.maxX(this));
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Polygon: vertices = ");
        for (int i = 0; i < getNumVertices(); i++){
            stringBuilder.append(getVertex(i)).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        return stringBuilder.toString();
    }

    @Override
    public abstract Vertex2D getVertex(int index);

    @Override
    public abstract int getNumVertices();
}
