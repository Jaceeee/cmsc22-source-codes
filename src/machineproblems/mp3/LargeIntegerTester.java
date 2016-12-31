package machineproblems.mp3;

/**
 * Created by Juan Carlos on 12/20/2016.
 */
public class LargeIntegerTester{
    public static void main(String args[]){
        LargeInteger a = new LargeInteger("10000000000000000000000000000000000");
        LargeInteger b = new LargeInteger("10000000000000000000000000000000");
        LargeInteger tmp = new LargeInteger();

        tmp = a.divide(b);
        System.out.print(tmp.getNumber());
    }
}