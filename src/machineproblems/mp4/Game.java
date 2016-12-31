package machineproblems.mp4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.*;

/**
 * Created by Juan Carlos on 10/22/2016.
 */

@SuppressWarnings("serial")
public class Game extends JPanel {
    Ball ball = new Ball(this); //Game has a ball, 2 racquet objects
    private float speed = 1;
    boolean keepOnPlaying = true;  //determines if game is still running
    Racquet racquet1 = new Racquet(this, true);
    Racquet racquet2 = new Racquet(this, false);

    public Game() {
        addKeyListener(new KeyListener() {   //the anonymous class used for action listening (specifically key listening)
            @Override
            public void keyTyped(KeyEvent e) {   //no need to implement because not a sought after action
            }

            @Override
            public void keyPressed(KeyEvent e) {   //only the respective racquet for certain keys are affected depending on the key pressed
                if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT)
                    racquet1.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
                    racquet2.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {   //same as above, this time for keyRelease
                if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT)
                    racquet1.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
                    racquet2.keyReleased(e);
            }
        });
        setFocusable(true);   //without this, addKeyListener cannot perform action listening
    }

    private int getScore(boolean player) {
        if (player)
            return racquet1.getScore();
        else
            return racquet2.getScore();
    }

    public void resetSpeed() {
        speed = 1;
    }

    public float getSpeed() {
        return speed;
    }

    public void increaseSpeed() {
        speed += 0.2;
    }

    //called to initiate movement, and key listening
    private void move() {
        ball.move();
        racquet1.move();
        racquet2.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //superclass method that got overridden
        Graphics2D g2d = (Graphics2D) g;  //Graphics object g used to draw figures on the frame
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);  //smoothens edges of geometric components

        ball.paint(g2d);
        racquet1.paint(g2d);
        racquet2.paint(g2d);
        racquet1.setVisible(true);
        racquet2.setVisible(true);

        g2d.setColor(Color.GRAY);  //sets color, and fonts for scores
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore(true)), 10, 30);
        g2d.drawString(String.valueOf(getScore(false)), 10, 290);
    }

    public void gameOver() {
        Sound.GAMEOVER.play(); //play game over background audio
        Object[] options = {"Yes, please",  //options for play again and close
                "No, thanks"};
        int n = JOptionPane.showOptionDialog(this,   //returns a value to n which signifies a choice by user at the end of the game
                "Would you like to play again?",
                "Game Over!",
                JOptionPane.YES_NO_OPTION,  //type of option dialog
                JOptionPane.QUESTION_MESSAGE,   //type of message
                null,   //no icon
                options, //which texts go in the buttons
                options[1]);  //which button is primarily selected (but not clicked!)

        if (n == JOptionPane.YES_OPTION) { //what happens when I choose yes
            keepOnPlaying = true;    //i reset everything, including replayiing the background music
            racquet1.reset();
            racquet2.reset();
        } else if (n == JOptionPane.NO_OPTION) { //how about the no choice
            keepOnPlaying = false; //I just set the boolean for game status to false
            System.exit(ABORT); //then I just close the window
        }
    }

    public int getWinner() {  //gets winner (1 for bottom, 2 for top) or returns 0 if not determined
        if (racquet1.getScore() == 3)
            return 1;
        else if (racquet2.getScore() == 3)
            return 2;
        else
            return 0;
    }

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        do {
            JFrame frame = new JFrame("Mini Tennis");   //creates a new frame and adds this game to the frame
            frame.add(game);
            frame.setSize(300, 400);   //dimensions, length x width
            frame.setVisible(true);  //makes frame visible
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //if not included, no way of closing via close buttons

            while (true) {
                game.move(); //i call move to begin motion
                game.repaint(); //i keep on re-rendering the frame
                Thread.sleep(10); //i give the other threads a chance to render the frame; I stop execution of this thread momentarily
                if (game.getWinner() != 0) {
                    game.gameOver();   //option for replaying appears
                }
            }
        } while (game.keepOnPlaying);
    }
}