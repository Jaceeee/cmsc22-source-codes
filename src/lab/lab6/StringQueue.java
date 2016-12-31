package lab.lab6;

/**
 * Created by Juan Carlos on 12/17/2016.
 */

public class StringQueue{
    private String[] elements;
    private int count;
    public static final int DEFAULT_SIZE=2;

    public StringQueue(){
        this(DEFAULT_SIZE);
    }

    public StringQueue(int n){
        if(n<=0){
            throw new IllegalArgumentException(" Invalid");
        }
        elements=new String[n];
    }

    public void enqueue(String item){
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

    public String dequeue(){

        if(count==0){
            return "Empty";
        }

        else{
            String temp= elements[0];
            for(int i = 0 ; i< count - 1;i++){
                elements[i]=elements[i+1];
            }
            count--;
            return temp;
        }
    }

    public String dequeue(int n){
        String result="";
        if(n<=0){
            throw new IllegalArgumentException("Invalid");
        }

        else{

            for(int i=0; i < n;i++){
                result=dequeue();
            }
        }
        return result;
    }

    public String peek(){
        if(count==0){
            return "Empty";
        }
        return elements[0];
    }

    public void singit(int pos, String name){
        if(pos <= 0 || pos > count+1){
            throw new IllegalArgumentException("Invalid");
        }
        else if(count == elements.length){
            String[] temp=new String[DEFAULT_SIZE+count];
            for(int i=0;i<count;i++){
                temp[i]=elements[i];
            }
            elements=temp;
        }
        int i= count;
        for(; i >= pos;i--){
            elements[i]=elements[i-1];
        }
        elements[i]= name;
        count++;
    }
}