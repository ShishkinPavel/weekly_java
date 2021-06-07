package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * @author Pavel Shishkin
 */

public class CollectionPolygon extends SimplePolygon{
    private final List<Vertex2D> collectionPolygon;
    /**
     * @param vertex2DS is list of vertex
     */

    public CollectionPolygon(Vertex2D[] vertex2DS){
        super(vertex2DS);
        collectionPolygon = List.copyOf(Arrays.asList(vertex2DS));
    }

    /**
     * @param collectionPolygon is list of polygons
     */
    public CollectionPolygon(List<Vertex2D> collectionPolygon){
        super(collectionPolygon.toArray(new Vertex2D[0]));
        this.collectionPolygon = List.copyOf(collectionPolygon);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0 || index>collectionPolygon.size()){
            throw new IllegalArgumentException("index should be > 0 and < count of vertices");
        }
        return collectionPolygon.get(index%collectionPolygon.size());
    }

    @Override
    public int getNumVertices() {
        return collectionPolygon.size();
    }

    @Override
    public boolean equals(Object object){
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        CollectionPolygon collectionPolygon1 = (CollectionPolygon) object;
        return this.hashCode() == collectionPolygon1.hashCode();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(List.of(collectionPolygon).toArray());
    }

    /**
     * @return CollPoly
     */
    public CollectionPolygon withoutLeftmostVertices(){
        List<Vertex2D> newColl = new ArrayList<>(List.copyOf(collectionPolygon));
        Vertex2D minXV = collectionPolygon.get(0);
        for(Vertex2D vertex2D : collectionPolygon){
            if (vertex2D.getX() < minXV.getX()){
                minXV = vertex2D;
            }
        }
        while (Collections.frequency(newColl, minXV) > 0){
            newColl.remove(minXV);
        }
        if(newColl.size()<1){
            return null;
        }
        return new CollectionPolygon(newColl);
    }
}