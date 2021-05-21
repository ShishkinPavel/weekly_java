package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 *
 * @author Pavel Shishkin
 */

public class Gauger {
    static void printMeasurement(Measurable measurable){
        System.out.println("Width: " + measurable.getWidth() + "\n" +
                "Height: " + measurable.getHeight());
    }

    static void printMeasurement(Triangle triangle){
        System.out.println(triangle.toString());
        printMeasurement((Measurable) triangle);
    }
}
