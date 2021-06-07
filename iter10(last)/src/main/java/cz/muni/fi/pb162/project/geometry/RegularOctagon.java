package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author Pavel Shishkin
 */
public class RegularOctagon extends GeneralRegularPolygon {

    /**
     * Set the color of object,
     * @param center is center of oct
     * @param radius is radius of oct
     */
    public RegularOctagon(Vertex2D center, double radius) {
        super(center, 8, radius);
    }
}
