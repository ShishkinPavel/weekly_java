package cz.muni.fi.pb162.project.geometry;

import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Collection;
/**
 * @author Pavel Shishkin
 */
public class Paper implements Drawable{
    private Color color;
    private final Set<ColoredPolygon> polygons;

    /**
     * setter
     */
    public Paper(){
        color = Color.BLACK;
        this.polygons = new HashSet<>();
    }

    /**
     * @param drawable is dr
     */
    public Paper(Drawable drawable){
        color = Color.BLACK;
        this.polygons = Set.copyOf(drawable.getAllDrawnPolygons());
    }

    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) {
        if (color != Color.WHITE){
            polygons.add(new ColoredPolygon(polygon, color));
        }
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        polygons.remove(polygon);
    }

    @Override
    public void eraseAll() {
        polygons.clear();
    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableSet(polygons);
    }

    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> vertex2DS = new HashSet<>();
        for (ColoredPolygon c: polygons) {
            int count = c.getPolygon().getNumVertices();
            for(int i = 0; i<count; i++){
                vertex2DS.add(c.getPolygon().getVertex(i));
            }
        }
        return vertex2DS.size();

    }
}
