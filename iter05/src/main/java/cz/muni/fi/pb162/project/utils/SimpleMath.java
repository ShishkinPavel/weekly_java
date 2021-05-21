package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 *
 * @author Pavel Shishkin
 */

public class SimpleMath {

    /**
     *
     *  @return minX
     *  @param triangle is triangle
     */
    public static double minX(Triangle triangle){
        return Math.min(triangle.getVertex(0).getX(),
                Math.min(triangle.getVertex(1).getX(),
                        triangle.getVertex(2).getX()));
    }

    /**
     *
     *  @return minY
     *  @param triangle is triangle
     */
    public static double minY(Triangle triangle){
        return Math.min(triangle.getVertex(0).getY(),
                Math.min(triangle.getVertex(1).getY(),
                        triangle.getVertex(2).getY()));
    }

    /**
     *
     *  @return maxX
     *  @param triangle is triangle
     */
    public static double maxX(Triangle triangle){
        return Math.max(triangle.getVertex(0).getX(),
                Math.max(triangle.getVertex(1).getX(),
                        triangle.getVertex(2).getX()));
    }

    /**
     *
     *  @return maxY
     * @param triangle is triangle
     */
    public static double maxY(Triangle triangle){
        return Math.max(triangle.getVertex(0).getY(),
                Math.max(triangle.getVertex(1).getY(),
                        triangle.getVertex(2).getY()));
    }
}
