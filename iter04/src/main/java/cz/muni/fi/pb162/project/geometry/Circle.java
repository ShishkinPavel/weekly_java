package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author Pavel Shishkin
 */
public class Circle implements Measurable, Circular {
    private final Vertex2D center;
    private final double radius;



    /**
     * @param center is center
     * @param radius is radius
     */
    public Circle(Vertex2D center, double radius){
        this.center = center;
        this.radius = radius;
    }

    /**
     * create a Circle
     */
    public Circle() {
        this.center = new Vertex2D(0.0, 0.0);
        this.radius = 1.0;
    }



    @Override
    public double getRadius() {
        return radius;
    }

    @Override
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

    @Override
    public double getWidth() {
        return radius * 2.0;
    }

    @Override
    public double getHeight() {
        return getWidth();
    }


}
