package cz.muni.fi.pb162.project.geometry;



/**
 *
 * @author Pavel Shishkin
 */
public class ColoredPolygon {
    private final Polygon polygon;
    private final Color color;

    /**
     * @param polygon is polygon
     * @param color is color
     */
    public ColoredPolygon(Polygon polygon, Color color){
        this.polygon = polygon;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        ColoredPolygon coloredPolygon = (ColoredPolygon) object;
        return getPolygon() == coloredPolygon.polygon && getColor() == coloredPolygon.color;
    }
    @Override
    public int hashCode() {
        return polygon.hashCode() + color.hashCode();
    }
}
