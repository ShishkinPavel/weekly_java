package cz.muni.fi.pb162.project.geometry;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.stream.Collectors;


/**
 * LabeledPolygon
 * @author Pavel Shishkin
 */
public final class LabeledPolygon  extends SimplePolygon implements Polygon, Labelable, Sortable, PolygonWritable{

    private final SortedMap<String,Vertex2D> vertices;

    @Override
    public void write(OutputStream os) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            for (String key : vertices.keySet()) {
                bw.write(Double.toString(vertices.get(key).getX()));
                bw.write(" ");
                bw.write(Double.toString(vertices.get(key).getY()));
                bw.write(" ");
                bw.write(key);
                bw.newLine();
            }
        }
    }

    @Override
    public void write(File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        write(os);
    }

    /**
     * @param os is output string
     * @exception IOException for wrong io
     */
    public void writeJson(OutputStream os) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutput = gson.toJson(vertices);
        OutputStreamWriter writer = new OutputStreamWriter(os);
        writer.write(jsonOutput);
        writer.flush();
    }




    /**
     * Builder
     * @author Pavel Shishkin
     */
    public static class Builder implements Buildable<LabeledPolygon>, PolygonReadable {

        private final Map<String, Vertex2D> map = new HashMap<>();

        @Override
        public LabeledPolygon build() {
            return new LabeledPolygon(map);
        }

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
        public Builder read(InputStream is) throws IOException {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            Map<String, Vertex2D> possible = new HashMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                String [] sliced = line.split(" ", 3);

                if (sliced.length < 3) {
                    throw new IOException("Each Vertex should be written as: \"x y vertex name\"");
                }

                try {
                    double x = Double.parseDouble(sliced [0]);
                    double y = Double.parseDouble(sliced [1]);
                    possible.put(sliced[2], new Vertex2D(x, y));
                } catch (NumberFormatException e) {
                    throw new IOException("Coordinate x or y is written wrongly");
                }
            }
            br.close();
            isr.close();

            for (String key: possible.keySet()) {
                addVertex(key,possible.get(key));
            }

            return this;
        }

        @Override
        public Builder read(File file) throws IOException {
            InputStream is = new FileInputStream(file);
            read(is);
            return this;
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
