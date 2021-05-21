package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 *
 * @author Pavel Shishkin
 */

public abstract class SimplePolygon implements Polygon{


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
