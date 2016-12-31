package lab.lab8.abstractclasses;

/*
 * Lab8 implementation of inheritance by Michael Loewe Alivio, Michael Ervin Pacana and Juan Carlos Roldan
 */

//derived class from Rectangle class
public class Square extends Rectangle{
    public Square() {
        super(1.0, 1.0);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide(){ return getLength(); }

    public void setSide(double side) {
        setLength(side);
        setLength(side);
    }

    public void setLength(double side) {
        setSide(side);
    }

    public void setWidth(double side) {
        setSide(side);
    }

    public String toString(){
        String shape;
        shape = String.format("A Square with side %.2f, which is a subclass of %s", getLength(), super.toString());
        return shape;
    }
}