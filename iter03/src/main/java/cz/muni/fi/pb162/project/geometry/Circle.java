package cz.muni.fi.pb162.project.geometry;


/**
 *
 * @author Pavel Shishkin
 */
public class Circle {
    private final Vertex2D center;
    private final double radius;

    /**
     * create a Circle
     */
    public Circle() {
        this.center = new Vertex2D(0.0, 0.0);
        this.radius = 1.0;
    }

    /**
     * @param center is center
     * @param radius is radius
     */
    public Circle(Vertex2D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }


    public Vertex2D getCenter() {
        return center;
    }
    /**
     * print
     * @return string
     */
    public String toString() {
        return "Circle: center=" + getCenter() + ", radius=" + getRadius();
    }
}
