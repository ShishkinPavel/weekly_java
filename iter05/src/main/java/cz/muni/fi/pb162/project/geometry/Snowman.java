package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author Pavel Shishkin
 */

public class Snowman {
    private RegularPolygon[] arrayOfCircles = new RegularPolygon[3];
    private final double num = 0.8;


    /**
     *
     *  first Snowman konstr
     * @param regularPolygon is polygon
     * @param number  is number
     */


    public Snowman (RegularPolygon regularPolygon, double number){
        if (number<=0.0 || number>1.0){
                number = num;
        }
        double radius = regularPolygon.getRadius();
        Vertex2D center = regularPolygon.getCenter();
        int edges = regularPolygon.getNumEdges();

        for (int i = 0; i < 3; i++){
            arrayOfCircles[i] = new GeneralRegularPolygon(center, edges, radius);
            radius *= number;
            center = new Vertex2D(arrayOfCircles[i].getCenter().getX(),
                    arrayOfCircles[i].getCenter().getY() +
                            radius +
                            arrayOfCircles[i].getRadius());

        }

    }

    /**
     *
     *  second Snowman konstr
     * @param regularPolygon is circular
     */
    public Snowman(RegularPolygon regularPolygon){
        arrayOfCircles = new Snowman(regularPolygon, 0.8).arrayOfCircles;
    }

    /**
     * @return Snowman
     */
    public RegularPolygon[] getBalls(){
        return arrayOfCircles;
    }

}
