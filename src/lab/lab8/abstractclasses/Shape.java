package lab.lab8.abstractclasses;
/*
 * Lab8 implementation of inheritance by Michael Loewe Alivio, Michael Ervin Pacana and Juan Carlos Roldan
 */


//parent class
public abstract class Shape{
    protected String color;
    protected boolean filled;

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
        return "A Shape with color of " + color + " and " + fill + '.';
    }

    //abstract compute for area function
    public abstract double getArea();

    //abstract compute for perimeter function
    public abstract double getPerimeter();
}