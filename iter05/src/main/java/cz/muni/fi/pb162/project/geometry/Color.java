package cz.muni.fi.pb162.project.geometry;


/**
 *
 * @author Pavel Shishkin
 */
public enum Color {
    WHITE, GREEN, BLACK, PINK, YELLOW, RED, BLUE, ORANGE;


    /**
     * Returns lowerCase of color
     * @return color
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

