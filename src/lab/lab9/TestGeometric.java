package lab.lab9;

/*
 * Submission by Michael Loewe Alivio, Michael Ervin Pacana, and Juan Carlos Roldan
 * October 12, 2016
 */

public class TestGeometric{
    public static void main(String[] args){
        Resizable o1 = new ResizableCircle(10);
        System.out.println(o1);
        o1.resize(-50);
        System.out.println(o1);

        GeometricObject o2 = new Circle(10);
        System.out.println(o2);

    }
}