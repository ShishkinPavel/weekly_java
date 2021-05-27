package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author Pavel Shishkin
 */
public class Circle extends GeneralRegularPolygon implements Measurable, Circular {


    /**
     * @param center is center
     * @param radius is radius
     */
    public Circle(Vertex2D center, double radius){
        super(center, Integer.MAX_VALUE, radius);
        super.setColor(Color.RED);
    }

    /**
     * create a Circle
     */
    public Circle() {
        super(new Vertex2D(0.0, 0.0), Integer.MAX_VALUE, 1.0);
        super.setColor(Color.RED);
    }


    @Override

    public double getEdgeLength() {
        return 0;
    }


    /**
     * print
     * @return string
     */
    @Override
    public String toString() {
        return "Circle: center=" + getCenter() + ", radius=" + getRadius();
    }


}
