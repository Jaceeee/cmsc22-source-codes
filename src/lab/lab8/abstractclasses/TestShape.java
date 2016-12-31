package lab.lab8.abstractclasses;

/*
 * TestShape implementation by Michael Loewe Alivio, Michael Ervin Pacana and Juan Carlos Roldan
 * Note: some of the following commented out lines are explanations to why the code fails to compile
 */



public class TestShape{
    public static void main(String[] args){
        Shape s1 = new Circle(5.5, "RED", false);  // Upcast Circle to Shape
        System.out.println(s1);                    // which version? Circle's version
        System.out.println(s1.getArea());          // which version? Circle's version
        System.out.println(s1.getPerimeter());     // which version? Circle's version
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());

        //System.out.println(s1.getRadius());  ERROR IN COMPILATION: getRadius() is not a member method of the Shape class. s1 is declared as a shape and is able to use only its own methods.
        Circle ss1 = (Circle) s1;
        System.out.println(ss1.getRadius());

        Circle c1 = (Circle)s1;                   // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        //Shape s2 = new Shape(); ERROR IN COMPILATION: Shape is an abstract class, and thus should not be instantiated.

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);   // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());

        //System.out.println(s3.getLength()); ERROR IN COMPILATION: s3 is still of type Shape. Class Shape does not have a getLength() function.
        Rectangle ss3 = (Rectangle) s3;
        System.out.println(ss3.getLength());

        Rectangle r1 = (Rectangle)s3;   // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6);     // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        //System.out.println(s4.getSide()); ERROR IN COMPILATION: s4 cannot use the getSide() function because it is a Shape, and getSide() belongs to the Square class.

        Square ss4 = (Square) s4;
        System.out.println(ss4.getSide());

        // Take note that we downcast Shape s4 to Rectangle,
        //  which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());

        //System.out.println(r2.getSide());  ERROR IN COMPILATION: Though r2 is now a Rectangle, it can't use a method available in its derived class, but not defined within Rectangle nor in the parent classes.
        Square rr2 = (Square) r2;
        System.out.println(rr2.getSide());
        System.out.println(r2.getLength());

        // Downcast Rectangle r2 to Square
        Square sq1 = (Square) r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());

        Triangle a = new Triangle(1,1,1);
        System.out.println(a);

        System.out.println("Perimeter = " + a.getPerimeter() + ", Area = " + a.getArea());
    }
}