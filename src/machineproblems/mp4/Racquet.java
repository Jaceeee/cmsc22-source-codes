package machineproblems.mp4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Juan Carlos on 10/22/2016.
 */

public class Racquet extends JPanel {
    //static final (constants for position and racquet dimensions)
    private static final int YBOTTOM = 330; //Y is for the racquet at the bottom portion of the screen
    private static final int YTOP = 30; //YTOP is for the racquet at the top portion of the screen
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;

    int x = 0;   //variable horizontal position
    int xa = 0;  //speed
    private int score = 0;
    boolean player;  //determines whether this object is the bottom player or not
    private Game game;


    public Racquet(Game game, boolean player) {
        this.game = game;
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;  //I move the racquet side to side within legal bounds only, whenever this method is called
    }

    @Override
    public void paint(Graphics g) {
        if (player) { //sets the colors of sprites and positions
            g.setColor(Color.RED);
            g.fillRect(x, YBOTTOM, WIDTH, HEIGHT);
        } else {
            g.setColor(Color.BLUE);
            g.fillRect(x, YTOP, WIDTH, HEIGHT);
        }
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    } //racquet doesn't move because user didn't press anything or released the particular movement keys

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)   //if left movement keys are pressed
            xa = -2;  //i change the speed to its negative (change direction)
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)   //if right movement keys
            xa = 2;
    }

    public Rectangle getBounds() { //used to generate an invisible bordering rectangle
        if (player)
            return new Rectangle(x, YBOTTOM, WIDTH, HEIGHT);
        else
            return new Rectangle(x, YTOP, WIDTH, HEIGHT);
    }

    public int getTopY() { //we get the y-coordinate of the collidable side of the respective racquets
        if (player)
            return YBOTTOM - HEIGHT;
        else
            return YTOP + HEIGHT;
    }

    public void reset() {
        score = 0;
    }
}