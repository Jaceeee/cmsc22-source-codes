package lab.lab8.nonabstract;

/**
 * Created by Juan Carlos on 12/17/2016.
 */
public class TestShape{
    public static void main(String[] args){
        Shape shape = new Shape("purple",true);

        if(shape.isFilled()){
            System.out.println(shape);
        } else{
            System.out.println("loser");
        }

        Shape shape2 = new Rectangle(3.0,4.0,"purple",true);

        if(shape2.isFilled()){
            System.out.println(shape2);
        } else{
            System.out.println("loser");
        }

        Rectangle shape3 = (Rectangle) shape2;
        System.out.printf("Area = %.2f, Perimeter = %.2f\n", shape3.getArea(), shape3.getPerimeter());

        Shape shape4 = new Circle(3.0,"purple",true);

        if(shape.isFilled()){
            System.out.println(shape4);
        } else{
            System.out.println("loser");
        }

        Circle shape5 = (Circle) shape4;
        System.out.printf("Area = %.2f, circumference = %.2f\n", shape5.getArea(), shape5.getPerimeter());

        Shape shape6 = new Square(3.0,"purple",true);

        if(shape.isFilled()){
            System.out.println(shape6);
        } else{
            System.out.println("loser");
        }

        Square shape7 = (Square) shape6;
        System.out.printf("Area = %.2f, Perimeter = %.2f\n", shape7.getArea(), shape7.getPerimeter());
    }
}