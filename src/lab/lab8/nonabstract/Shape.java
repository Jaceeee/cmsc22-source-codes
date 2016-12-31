package lab.lab8.nonabstract;

/**
 * Created by Juan Carlos on 12/17/2016.
 */

public class Shape{
    private String color;
    private boolean filled;

    public Shape(){
        color = "green";
        filled = true;
    }

    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public boolean isFilled(){ //this is the convention for a boolean getter. use isXXX instead of getXXX
        return filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public String toString(){
        String fill = (filled) ? "filled" : "not filled";
        return "A Shape with color of " + color + " and " + fill;
    }

}