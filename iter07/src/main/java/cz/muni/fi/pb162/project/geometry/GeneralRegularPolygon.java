package cz.muni.fi.pb162.project.geometry;


/**
 *
 * @author Pavel Shishkin
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored{

    private final Vertex2D center;
    private final double radius;
    private final int ecount;
    private Color color = Color.BLACK;

    /**
     * Set the color of object,
     * @param center is center of polygon
     * @param ecount is count of edges of polygon
     * @param radius is radius of polygon
     */
    public GeneralRegularPolygon(Vertex2D center, int ecount, double radius){
        this.center = center;
        this.ecount = ecount;
        this.radius = radius;
    }

    @Override
    public Vertex2D getCenter() {
        return center;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public double getWidth() {
        return radius*2;
    }

    @Override
    public double getHeight() {
        return getWidth();
    }

    @Override
    public int getNumEdges() {
        return ecount;
    }

    @Override
    public double getEdgeLength() {
        return getWidth()*Math.sin(Math.PI/getNumEdges());
    }

    @Override
    public Vertex2D getVertex(int index) {
        double x = center.getX() - radius*Math.cos(2*index*Math.PI/ecount);
        double y = center.getY() - radius*Math.sin(2*index*Math.PI/ecount);
        return new Vertex2D(x, y);
    }

    /**
     * Set the color of object,
     * @return String of poly
     */
    public String toString(){
        return String.format("%s-gon: center=%s, radius=%s, color=%s",
                ecount, center,radius,color);

    }

}
