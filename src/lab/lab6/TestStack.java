package lab.lab6;

/**
 * Created by Juan Carlos on 12/17/2016.
 */

public class TestStack{
    public static void main(String[] args){
        Stack myStack=new Stack();
        myStack.push("potatoes");
        myStack.push("tomatoes");
        myStack.push("cabbage");
        System.out.println(myStack);
        System.out.println(myStack.pop(2));
        myStack.push("tomatoessss");
        myStack.push("cabbagessss");
        myStack.push("carrotssss");
        myStack.push("lettucesss");
        myStack.push("flowers");
        myStack.push("ketchuo");
        System.out.println(myStack);
        System.out.println(myStack.peek());
    }
}