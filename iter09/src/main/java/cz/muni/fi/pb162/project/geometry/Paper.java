package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;

import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Pavel Shishkin
 */
public class Paper implements Drawable, PolygonFactory{
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
    public void drawPolygon(Polygon polygon) throws TransparentColorException {
        if (color == Color.WHITE){
            throw new TransparentColorException("Color cant be white");
        }
        polygons.add(new ColoredPolygon(polygon, color));
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        polygons.remove(polygon);
    }

    @Override
    public void eraseAll() throws EmptyDrawableException {
        if (polygons.size() == 0){
            throw new EmptyDrawableException("paper is already clear");
        }
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

    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) throws MissingVerticesException{
        if (vertices.isEmpty()){
            throw new NullPointerException();
        }
        if (vertices.size() < 3){
            throw new MissingVerticesException("count of vertices < 3");
        }
        if (vertices.contains(null)){
            List<Vertex2D> nv = new ArrayList<>();
            for (Vertex2D v:
                 vertices) {
                if (v!=null){
                    nv.add(v);
                }
            }
            return new CollectionPolygon(nv);
        }
        return new CollectionPolygon(vertices);
    }

    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {
        int num = collectionPolygons.size();
        int count = 0;
        for (List<Vertex2D> l:
             collectionPolygons) {
            num -= 1;
            try {
                Polygon x = tryToCreatePolygon(l);
                drawPolygon(x);
                count += 1;
            }catch (MissingVerticesException | NullPointerException m){
                if (num == 0 && count == 0){
                    throw new EmptyDrawableException("", m);
                }
            } catch (TransparentColorException c){
                this.changeColor(Color.BLACK);
                }
            }
    }

    /**
     * @param color is color of polygon
     * @return polygons
     */
    public Collection<Polygon> getPolygonsWithColor(Color color){
        Collection<Polygon> polygons = new ArrayList<>();
        for (ColoredPolygon p:
             this.polygons) {
            if (p.getColor() == color){
                polygons.add(p.getPolygon());
            }
        }
        return polygons;
    }
}
