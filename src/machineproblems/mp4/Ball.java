package machineproblems.mp4;

import java.awt.Graphics2D;
import java.awt.Rectangle;


/**
 * Created by Juan Carlos on 10/22/2016.
 */

public class Ball {
    private static final int DIAMETER = 30;

    float x = 0;
    float y = 50;
    float xa = 1;  //horizontal speed
    float ya = 1;  //vertical speed
    float yConstant = 1;
    //we can link the Ball class to the game class by including the Game object as a field
    private Game game;


    public Ball(Game game) {
        this.game = game;
    }

    public int getDiameter() {
        return DIAMETER;
    }

    void move() {
        boolean changeDirection = true;
        if (x + xa < 0)
            xa = game.getSpeed();   //whenever ball reaches the edge of side screens, we change its direction horizontal
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.getSpeed();
        else if (y + yConstant > game.getHeight() - DIAMETER) {  //when ball reaches end of vertical screens, we increase player scores
            game.racquet1.increaseScore();
            y = 50;
            x = 0;
            x = ya = xa = 1;   //also there is a reset of ball speeds and position
            game.resetSpeed(); //reset of game speed
        } else if (y + yConstant < 0 + DIAMETER) {   //the reset is also happens here
            game.racquet2.increaseScore();
            y = 50;
            x = 0;
            ya = xa = 1;
            game.resetSpeed();
        } else if (collisionWith1()) {  //whenever we have a collision, we change direction vertically
            ya = -game.getSpeed();
            yConstant = -yConstant;
            y = game.racquet1.getTopY() - DIAMETER;  //we put the ball directly on top or bottom of its respective racquet so there are no unnecessary collisions
            game.increaseSpeed();  //and we increase ball speeds
        } else if (collisionWith2()) {  //same here
            ya = game.getSpeed();
            yConstant = -yConstant;
            y = game.racquet2.getTopY() + DIAMETER;
            game.increaseSpeed();
        } else
            changeDirection = false;  //else, there is no collision with screens or racquets

        if (changeDirection) //sound playable when there is a collision with screen or racquet
            Sound.BALL.play();
        //change of positions
        x = x + xa;
        y = y + ya;
    }

    //following collisionWith methods determine if each racquet caught a ball
    private boolean collisionWith1() {
        return game.racquet1.getBounds().intersects(getBounds());
    }//intersects is a method used to determine whether there is an overlap between two rectangles

    private boolean collisionWith2() {
        return game.racquet2.getBounds().intersects(getBounds());
    }

    //creates an invisible square boundary around the ball that determines collision
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, DIAMETER, DIAMETER);
    }

    public void paint(Graphics2D g) {
        g.fillOval((int) x, (int) y, 30, 30);
    } //typecasted because fields are float values

}
