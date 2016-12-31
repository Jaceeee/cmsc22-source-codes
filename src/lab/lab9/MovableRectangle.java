package lab.lab9;

/*
 * Submission by Michael Loewe Alivio, Michael Ervin Pacana, and Juan Carlos Roldan
 * October 12, 2016
 */

import java.io.IOException;

public class MovableRectangle implements Movable, Drawable {

    private static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed){
        if(x2 < x1 || y2 < y1){
            throw new IllegalArgumentException("Bottom right values are lesser than Top left values");
        }
        topLeft = new MovablePoint(x1,y1,xSpeed,ySpeed);
        bottomRight = new MovablePoint(x2,y2,xSpeed,ySpeed);
        sleep(1000);
        render();
        clearScreen();
        System.out.println("\n");
    }

    public String toString(){
        render();
        return "Top left at x = " + topLeft.x + " y = " + topLeft.y + " and Bottom Right at x = " + bottomRight.x + " y = " + bottomRight.y;
    }

    public void moveUp(){
        sleep(1000);
        clearScreen();

        topLeft.y -= topLeft.ySpeed;
        bottomRight.y -= bottomRight.ySpeed;
        render();
        System.out.println("\n");
    }

    public void moveDown(){
        sleep(1000);
        clearScreen();

        topLeft.y += topLeft.ySpeed;
        bottomRight.y += bottomRight.ySpeed;
        render();
        System.out.println("\n");
    }

    public void moveLeft(){
        sleep(1000);
        clearScreen();

        topLeft.x -= topLeft.xSpeed;
        bottomRight.x -= bottomRight.xSpeed;
        render();
        System.out.println("\n");
    }

    public void moveRight(){
        sleep(1000);
        clearScreen();

        topLeft.x += topLeft.xSpeed;
        bottomRight.x += bottomRight.xSpeed;
        render();
        System.out.println("\n");

    }

    public void render(){
        int x1,tpleftx = topLeft.x,tplefty = topLeft.y;
        int y1,botrightx = bottomRight.x,botrighty = bottomRight.y;

        if(tpleftx < 0){            //if topleft x coordinate is lesser than 0 i set ni siya to zero because the console can only read positive - positive coordinates
            botrightx = botrightx - tpleftx;    //in order for the rectangle to still be symmetrical, top left x coordinate must subtract from the bottom right x value
            tpleftx = 0;                        // remember topleft x value is still negative
        }
        if(tplefty < 0){
            botrighty = botrighty - tplefty;    //same as above
            tplefty = 0;
        }

        for(y1 = 0; y1 < tplefty; y1++){
            System.out.print("\n");
        }

        for(; y1 <= botrighty; y1++){
            for(x1 = 0; x1 < tpleftx; x1++){
                System.out.print(" ");
            }
            System.out.print("X");
            for(; x1 < botrightx - 1; x1++){
                if(y1 == tplefty || y1 == botrighty){
                    System.out.print("X");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.print("X");
            System.out.print("\n");
        }
    }
}