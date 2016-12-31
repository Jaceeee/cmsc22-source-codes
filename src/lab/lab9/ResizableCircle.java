package lab.lab9;

/*
 * Submission by Michael Loewe Alivio, Michael Ervin Pacana, and Juan Carlos Roldan
 * October 12, 2016
 */

import java.io.*;
import java.util.*;
public class ResizableCircle extends Circle implements Resizable, Drawable {
    public ResizableCircle(double radius) {
        super(radius);
    }

    public void resize(int percent) {//r = 5
        double newPercent = (double) (percent) / 100;
        System.out.println(newPercent);
        radius += newPercent * radius;
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

    public void render(){
        int x, y, i, j, ctr;
        ctr = 0;
        x = 20;
        y = 20;
        sleep(1000);
        clearScreen();

        if(x < radius || y < radius){
            throw new IllegalArgumentException("Radius must fit within coordinates");
        }
        for(i = 0; i <= y+radius ; i++){
            for(j = 0; j <= x+radius;j++){

                if(i == y){
                    if(j == x-radius || j == x+radius){
                        System.out.print("X");
                    }
                    if(j ==x){
                        System.out.print("X");
                    }
                }
                else if(i > y-radius && i < y + radius){
                    if(j == x - ctr || j == x + ctr){
                        if(i <= y - radius + (radius/4) || i > y + radius -(radius/4))
                            System.out.print("X");
                        else{
                            if((i%2 != 0 || i <= y + radius -(radius/4) && i % 2 != 0 ))
                                System.out.print("X");
                        }
                    }
                }
                else{
                    if( i == y-radius && j == x ||  i == y+radius && j == x){
                        System.out.print("X");
                        ctr = 1;
                    }
                }
                System.out.print("  ");
            }

            if (ctr != 0 && i > y-radius && i <= y){
                if(ctr < radius){
                    if(i <= y - radius + (radius/4)) { ctr+=2; }
                    else {
                        if(ctr < radius){ ctr++; }
                    }
                }
            }
            else if(ctr!=0 && i > y && i < y+radius){
                if(i >= y+ (radius/4) && i < y + radius - (radius/4)){ ctr--; }
                else{
                    if(i >= y + radius - (radius/4)){ ctr-=2;}
                }
            }
            System.out.print("\n");
        }
    }
}