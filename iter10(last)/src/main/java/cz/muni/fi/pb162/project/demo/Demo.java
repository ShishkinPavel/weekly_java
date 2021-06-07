package cz.muni.fi.pb162.project.demo;


import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.io.File;
import java.io.IOException;

/**
 * Class for running main method.
 *
 * @author Pavel Shishkin
 */
public class Demo {

    /**
     * Runs the code.
     *
     * @param args command line arguments, will be ignored
     * @exception IOException for io
     */
    public static void main(String[] args) throws IOException {
        File file = new File("polygon-ok.txt");
        LabeledPolygon polygon = new LabeledPolygon.Builder()
                .addVertex("vrchol x", new Vertex2D(123,456))
                .read(file)
                .build();

        polygon.writeJson(System.out);
        System.out.println("Hello World!");

    }

}
