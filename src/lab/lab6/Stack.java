package lab.lab6;

/**
 * Created by Juan Carlos on 12/17/2016.
 */

public class Stack{
    private String[] elements;
    private int count;
    public static final int DEFAULT_SIZE=10;

    public Stack(){
        this(DEFAULT_SIZE);
    }

    public Stack(int n){
        if(n<=0){
            throw new IllegalArgumentException(" Invalid");
        }
        elements=new String[n];
    }

    public void push(String item){
        if(count == elements.length){
            String[] temp=new String[DEFAULT_SIZE+count];

            for(int i=0;i<count;i++){
                temp[i]=elements[i];
            }
            elements = temp;
        }
        elements[count++]=item;
    }

    public String toString(){
        String ans = "";
        if(count==0){
            return "Empty";
        }

        else{

            for(int i=0;i< count-1;i++){
                ans+=elements[i]+", ";
            }
        }

        return ans+elements[count-1];
    }

    public int getSize(){ return count; }

    public String pop(){

        if(count==0){
            return "Empty";
        }

        else{
            return elements[--count];
        }
    }

    public String pop(int n){
        String result="";
        if(n<=0){
            throw new IllegalArgumentException("Invalid");
        }

        else{

            for(int i=0;i<n;i++){
                result=pop();
            }
        }
        return result;
    }

    public String peek(){
        if(count==0){
            return "Empty";
        }
        return elements[count-1];
    }
}