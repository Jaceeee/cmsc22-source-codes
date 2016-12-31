package lab.lab8.abstractclasses;

/**
 * Created by Juan Carlos on 12/17/2016.
 */
/*
 * Lab8 implementation of inheritance by Michael Loewe Alivio, Michael Ervin Pacana and Juan Carlos Roldan
 */

//used for implementation of sin function
import java.lang.Math;
import java.util.*;

/* Team protato feels that the instructions were sort of unclear on whether what kind of triangle would appear, as it only mentioned three sides in its constructor.
 * In the implementation of the test shape, a constructor that takes only three sides is called, we assume all angles are 60 degrees (equilateral triangle).
 * Else, if a constructor with three angles in addition to three sides is called, we set the angles accordingly.
 */
public class Triangle extends Shape{
    protected double side1;
    protected double side2;
    protected double side3;

    protected double angle1; //angle1 is opposite side1, and so on
    protected double angle2;
    protected double angle3;

    Triangle() {
        super();
        side1 = side2 = side3 = 1.0;
        angle1 = angle2 = angle3 = 60.0;
    }

    Triangle(double side1, double side2, double side3) {
        super();

        if(side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("Invalid side length.");
        } else{
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.angle1 = this.angle2 = this.angle3 = 60.0;
        }
    }

    Triangle(double side1, double side2, double side3, double angle1, double angle2, double angle3) {
        super();

        if(side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("Invalid side length.");
        } else{
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.angle1 = angle1;
            this.angle2 = angle2;
            this.angle3 = angle3;
        }
    }

    Triangle(double side1, double side2, double side3, String color, Boolean filled) {
        super(color, filled);

        if(side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("Invalid side length.");
        } else{
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.angle1 = this.angle2 = this.angle3 = 60.0;
        }
    }

    Triangle(double side1, double side2, double side3, double angle1, double angle2, double angle3, String color, Boolean filled) {
        super(color, filled);

        if(side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("Invalid side length.");
        } else{
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.angle1 = angle1;
            this.angle2 = angle2;
            this.angle3 = angle3;
        }
    }

    public double getArea() {
        double angleInDegrees = Math.toRadians(angle3);
        return 0.5 * side1 * (Math.sin(angleInDegrees) * side2);
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        String shape;
        shape = String.format("A Circle with side lengths: %.2f, %.2f, %.2f and angle measures: %.2f degrees, %.2f degrees, %.2f degrees which is a subclass of %s",side1, side2, side3, angle1, angle2, angle3, super.toString());
        return shape;
    }
}