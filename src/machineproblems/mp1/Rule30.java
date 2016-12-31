package machineproblems.mp1;

/**
 * Created by Juan Carlos on 12/20/2016.
 */
import java.util.*;

public class Rule30 {
    public static void main(String[] args) {
        int x;
        int n=0;
        Scanner input = new Scanner(System.in);
        x = input.nextInt();
        int y = x;
        int[] arr = new int[x];
        int[] pat = new int[3];

        for(int i = 0; i<x; i++)
            arr[i] = 0;

        arr[x/2] = 1;

        while(x>n){
            pat[0] = 0;
            pat[1] = arr[0];

            if(x>1)
                pat[2] = arr[1];
            else
                pat[2] = 0;


            for(int i=0; i<y; i++){
                System.out.print(arr[i]);

                arr[i] = pat[0] ^ (pat[1] | pat[2]);
                //this would be preferred to the one below commented out
//                if(pat[0]==1&&pat[1]==1&&pat[2]==1)
//                    arr[i] = 0;
//                else if(pat[0]==1&&pat[1]==1&&pat[2]==0)
//                    arr[i] = 0;
//                else if(pat[0]==1&&pat[1]==0&&pat[2]==1)
//                    arr[i] = 0;
//                else if(pat[0]==1&&pat[1]==0&&pat[2]==0)
//                    arr[i] = 1;
//                else if(pat[0]==0&&pat[1]==1&&pat[2]==1)
//                    arr[i] = 1;
//                else if(pat[0]==0&&pat[1]==1&&pat[2]==0)
//                    arr[i] = 1;
//                else if(pat[0]==0&&pat[1]==0&&pat[2]==1)
//                    arr[i] = 1;
//                else
//                    arr[i] = 0;

                pat[0] = pat[1];
                pat[1] = pat[2];

                if(i<y-2)
                    pat[2] = arr[i+2];
                else
                    pat[2] = 0;
            }
            System.out.printf("\n");
            n++;
        }
    }
}