package cz.muni.fi.pb162.project.geometry;

import java.util.Locale;
import java.util.Objects;

/**
 * Class for running main method.
 *
 * @author Pavel Shishkin
 */

public class Vertex2D implements Comparable<Vertex2D> {
    private final double x,y;

    /**
     * create vertex
     * @param x is x;
     * @param y is y;
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return this.x;
    }


    public double getY() {
        return this.y;
    }


    /**
     * @return formatted cords.
     * @param vertex is vertex
     */

    public double distance(Vertex2D vertex){
        if(vertex == null){
            return -1.0;
        }else {
            //sqrt((x2-x1)^2+(y2-y1)^2)
            return Math.sqrt((vertex.x-x)*(vertex.x-x)+(vertex.y-y)*(vertex.y-y));
        }
    };

    @Override
    public String toString() {
        return String.format(Locale.US, "[%s, %s]", x, y);
    }

    /**
     * @return new mid vertex
     * @param vertex is vertex
     */
    public Vertex2D createMiddle(Vertex2D vertex){
        return new Vertex2D((x+ vertex.x)/2, (y+vertex.y)/2);
    }

    @Override
    public boolean equals(Object object){
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Vertex2D vertex2D = (Vertex2D) object;
        return Double.compare(vertex2D.x, x) == 0 && Double.compare(vertex2D.y, y) == 0;

    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Vertex2D object) {
        if (this.getX() == object.getX()){
            return Double.compare(this.getY(), object.getY());
        }
        return Double.compare(this.getX(), object.getX());
    }

}
