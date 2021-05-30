package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;


/**
 * LabeledPolygon
 * @author Pavel Shishkin
 */
public final class LabeledPolygon  extends SimplePolygon implements Polygon, Labelable, Sortable{

    private final SortedMap<String,Vertex2D> vertices;

    /**
     * Builder
     * @author Pavel Shishkin
     */
    public static class Builder implements Buildable<LabeledPolygon> {

        private final Map<String, Vertex2D> map = new HashMap<>();

        /**
         * addVertex
         * @param label for vertex
         * @param vertex2D the point
         * @return new built
         */
        public Builder addVertex(String label, Vertex2D vertex2D) {
            if(label == null) {
                throw new IllegalArgumentException("Empty vertex label.");
            }
            if (vertex2D == null) {
                throw new IllegalArgumentException("Empty vertex.");
            }
            map.put(label,vertex2D);
            return this;
        }

        @Override
        public LabeledPolygon build() {
            return new LabeledPolygon(map);
        }
    }
    /**
     * constructor checks the correctness of the input field
     *
     * @param vertices field of input
     */
    public LabeledPolygon(Map<String, Vertex2D> vertices) {
        super(vertices.values().toArray(new Vertex2D[0]));
        this.vertices = new TreeMap<>(vertices);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("index < 0.");
        }
        return vertices.values().toArray(new Vertex2D[]{new Vertex2D(0, 0)})[index%getNumVertices()];
    }

    @Override
    public int getNumVertices() {
        return vertices.size();
    }

    @Override
    public Vertex2D getVertex(String label) {
        if (label == null) {
            throw new NullPointerException("Empty vertex.");
        }
        if (!vertices.containsKey(label)) {
            throw new IllegalArgumentException("No label in vertices");
        }
        return vertices.get(label);
    }

    @Override
    public Collection<String> getLabels() {
        return Collections.unmodifiableSet(vertices.keySet());
    }

    @Override
    public Collection<String> getLabels(Vertex2D vertex) {
        return vertices.entrySet().stream()
                .filter(entry->entry.getValue().equals(vertex))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices() {
        return new TreeSet<>(vertices.values());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        SortedSet<Vertex2D> sorted = new TreeSet<>(comparator);
        sorted.addAll(vertices.values());
        return sorted;
    }

    /**
     * duplicate vertices
     * @return TreeSet
     */
    public Collection<Vertex2D> duplicateVertices() {
        List<Vertex2D> vertices = new ArrayList<>(this.vertices.values());
        return vertices.stream()
                .filter(e -> Collections.frequency(vertices, e) > 1)
                .collect(Collectors.toSet());
    }

}
