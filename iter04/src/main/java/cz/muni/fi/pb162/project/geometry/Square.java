package cz.muni.fi.pb162.project.geometry;


/**
 * @author Pavel Shishkin
 */
public class Square implements Circular{
    private final Vertex2D[] arrayOfVertices;
    /**
     *
     *  first Square konstr
     * @param center is center
     * @param diameter is diameter
     */
    public Square(Vertex2D center, double diameter){
        double radius = diameter/2.0;
        Vertex2D left = new Vertex2D(center.getX() - radius, center.getY());
        Vertex2D bottom = new Vertex2D(center.getX(), center.getY() - radius);
        Vertex2D right = new Vertex2D(center.getX() + radius, center.getY());
        Vertex2D top = new Vertex2D(center.getX(), center.getY() + radius);
        arrayOfVertices = new Vertex2D[]{left, bottom, right, top};
    }
    /**
     *
     *  second Square konstr
     * @param circle is circle
     */
    public Square(Circle circle){
        arrayOfVertices = new Square(circle.getCenter(), circle.getWidth()).arrayOfVertices;
    }

    /**
     *
     *  @return square
     * @param index is index
     */
    public Vertex2D getVertex(int index){
        if (0>index || index>3){
            return null;
        }
        return arrayOfVertices[index];

    }
    /**
     *
     *  @return toString
     */
    public String toString() {
        return "Square: vertices="+
                getVertex(0) + " " +
                getVertex(1) + " " +
                getVertex(2) + " " +
                getVertex(3);
    }

    @Override
    public Vertex2D getCenter() {
        return getVertex(0).createMiddle(getVertex(2));
    }

    @Override
    public double getRadius() {
        return getVertex(3).getX()-(getVertex(0).getX());
    }
}
