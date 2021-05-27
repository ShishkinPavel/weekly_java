package cz.muni.fi.pb162.project.geometry;


/**
 * @author Pavel Shishkin
 */
public class Square extends GeneralRegularPolygon implements Circular{
    /**
     *
     *  first Square konstr
     * @param center is center
     * @param diameter is diameter
     */
    public Square(Vertex2D center, double diameter){
        super(center, 4, diameter/2);

    }
    /**
     *
     *  second Square konstr
     * @param circle is circle
     */
    public Square(Circle circle){
        super(circle.getCenter(), 4, circle.getWidth()/2);
    }


    /**
     *
     *  @return toString
     */
    @Override
    public String toString() {
        return "Square: vertices="+
                getVertex(0) + " " +
                getVertex(1) + " " +
                getVertex(2) + " " +
                getVertex(3);
    }

}
