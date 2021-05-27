package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;

/**
 *
 * @author Pavel Shishkin
 */

public class SimpleMath {

    /**
     *
     *  @return minX
     *  @param polygon is polygon
     */
    public static double minX(Polygon polygon){
        double x = polygon.getVertex(0).getX();
        for (int i = 0; i<polygon.getNumVertices();i++){
            double newX = polygon.getVertex(i).getX();
            if (newX<x){
                x = newX;
            }
        }
        return x;
    }

    /**
     *
     *  @return minY
     *  @param polygon is polygon
     */
    public static double minY(Polygon polygon){
        double y = polygon.getVertex(0).getY();
        for (int i = 0; i<polygon.getNumVertices();i++){
            double newY = polygon.getVertex(i).getY();
            if (newY<y){
                y = newY;
            }
        }
        return y;
    }

    /**
     *
     *  @return maxX
     *  @param polygon is polygon
     */
    public static double maxX(Polygon polygon){
        double x = polygon.getVertex(0).getX();
        for (int i = 0; i<polygon.getNumVertices();i++){
            double newX = polygon.getVertex(i).getX();
            if (newX>x){
                x = newX;
            }
        }
        return x;
    }

    /**
     *
     *  @return maxY
     * @param polygon is polygon
     */
    public static double maxY(Polygon polygon){
        double y = polygon.getVertex(0).getY();
        for (int i = 0; i<polygon.getNumVertices();i++){
            double newY = polygon.getVertex(i).getY();
            if (newY>y){
                y = newY;
            }
        }
        return y;
    }
}
