package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author Pavel Shishkin
 */

public class Snowman {
    private Circle[] arrayOfCircles = new Circle[4];


    /**
     *
     *  first Snowman konstr
     * @param circular is circular
     * @param number  is number
     */

    // I apologize for the spaghetti code

    public Snowman (Circular circular, double number){
        if (number<=0 || number>1){
                number = 0.8;
        }
        double radius = circular.getRadius();
        Vertex2D center = circular.getCenter();

        for (int i = 0; i < 4; i++){
            arrayOfCircles[i] = new Circle(center, radius);
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
     * @param circular is circular
     */
    public Snowman(Circular circular){
        arrayOfCircles = new Snowman(circular, 0.8).arrayOfCircles;
    }

    /**
     * @return Snowman
     */
    public Circular[] getBalls(){
        return arrayOfCircles;
    }

}
