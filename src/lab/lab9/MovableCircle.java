package lab.lab9;

/*
 * Submission by Michael Loewe Alivio, Michael Ervin Pacana, and Juan Carlos Roldan
 * October 12, 2016
 */

import java.io.*;
import java.util.*;
public class MovableCircle implements Movable, Drawable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        if(x < radius || y < radius){
            throw new IllegalArgumentException("Radius must fit within coordinates");
        }
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
        render();
        sleep(1000);
        clearScreen();
        sleep(1000);
    }

    public String toString() {
        render();
        return "I am a movable potato.\nCenter at x = " + center.x + " y = " + center.y + " with radius of " + radius;
    }

    public void moveUp() {
        center.y -= center.ySpeed;
        render();
    }

    public void moveDown() {
        center.y += center.ySpeed;
        render();
    }

    public void moveLeft() {
        center.x -= center.xSpeed;
        render();
    }

    public void moveRight() {
        center.x += center.xSpeed;
        render();
    }

    public static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void render(){
        int i, j, ctr = 0;
        sleep(1000);
        clearScreen();
        for(i = 0; i <= center.y+radius ; i++){
            for(j = 0; j <= center.x+radius;j++){

                if(i == center.y){
                    if(j == center.x-radius || j == center.x+radius){
                        System.out.print("X");
                    }
                    if(j ==center.x){
                        System.out.print("X");
                    }
                }
                else if(i > center.y-radius && i < center.y + radius){
                    if(j == center.x - ctr || j == center.x + ctr){
                        if(i <= center.y - radius + (radius/4) || i > center.y + radius -(radius/4))
                            System.out.print("X");
                        else{
                            if((i%2 != 0 || i <= center.y + radius -(radius/4) && i % 2 != 0 ))
                                System.out.print("X");
                        }
                    }
                }
                else{
                    if( i == center.y-radius && j == center.x ||  i == center.y+radius && j == center.x){
                        System.out.print("X");
                        ctr = 1;
                    }
                }
                System.out.print("  ");
            }

            if (ctr != 0 && i > center.y-radius && i <= center.y){
                if(ctr < radius){
                    if(i <= center.y - radius + (radius/4)) { ctr+=2; }
                    else {
                        if(ctr < radius){ ctr++; }
                    }
                }
            }
            else if(ctr!=0 && i > center.y && i < center.y+radius){
                if(i >= center.y+ (radius/4) && i < center.y + radius - (radius/4)){ ctr--; }
                else{
                    if(i >= center.y + radius - (radius/4)){ ctr-=2;}
                }
            }
            System.out.print("\n");
        }
    }
}