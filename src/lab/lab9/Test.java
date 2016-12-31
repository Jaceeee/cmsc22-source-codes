package lab.lab9;

/*
 * Submission by Michael Loewe Alivio, Michael Ervin Pacana, and Juan Carlos Roldan
 * October 12, 2016
 */
public class Test{
    public static void main(String[] args){
        Movable m1 = new MovablePoint(5,6,10,5);
        m1.moveLeft();
        System.out.println(m1);

        Movable m2 = new MovableCircle(5,5,2,2,5);
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);

        Movable m3 = new MovableRectangle(1,1,5,5,2,2);
        System.out.println(m3);
        m3.moveRight();
        System.out.println(m3);
    }
}