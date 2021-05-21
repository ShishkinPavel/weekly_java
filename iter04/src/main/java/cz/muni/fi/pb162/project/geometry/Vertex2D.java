package cz.muni.fi.pb162.project.geometry;
import java.util.Locale;

/**
 * Class for running main method.
 *
 * @author Pavel Shishkin
 */

public class Vertex2D {
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
}
