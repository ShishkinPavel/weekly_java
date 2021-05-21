package cz.muni.fi.pb162.project.geometry;
import java.util.Locale;

/**
 * Class for running main method.
 *
 * @author Pavel Shishkin
 */

public class Vertex2D {
    private double x;
    private double y;

    /**
     * create Vertex2D
     */

    public Vertex2D() {
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Formatted card.
     * @return formatted cords.
     */

    public String getInfo() {
        return String.format(Locale.US, "[%.1f, %.1f]", this.x, this.y);
    }
    /**
     * Sum.
     * @return sum of cords.
     */
    public double sumCoordinates() {
        return this.x + this.y;
    }

    /**
     * Plus.
     * @param vertex sum
     */

    public void move(Vertex2D vertex) {
        this.x += vertex.x;
        this.y += vertex.y;
    }
}
