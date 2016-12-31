package lab.lab8.nonabstract;

/**
 * Created by Juan Carlos on 12/17/2016.
 */
public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle(){
        super();
        width = length = 1.0;
    }

    public Rectangle(double width, double length){
        super();
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled){
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() { return width; }

    public double getLength() { return length; }

    public void setWidth(double width){
        this.width = width;
    }

    public void setlength(double length){
        this.length = length;
    }

    public double getArea(){
        return length * width;
    }

    public double getPerimeter(){
        return 2 * (length + width);
    }

    public String toString(){
        String shape;
        shape = String.format("A Rectangle with width = %.2f and length %.2f, which is a subclass of %s", width, length, super.toString());
        return shape;
    }
}