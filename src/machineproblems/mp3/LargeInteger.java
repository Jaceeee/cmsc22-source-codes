package machineproblems.mp3;

/**
 * Created by Juan Carlos on 12/20/2016.
 */

public class LargeInteger{
    private int size;
    private String number;

    LargeInteger() {
        number = "0";
        size = 1;
    }

    LargeInteger(String numString) {
        number = numString;
        size = number.length();
    }

    LargeInteger(LargeInteger numString) {
        number = numString.number;
        size = numString.size;
    }

    LargeInteger(Long number) {
        this.number = Long.toString(number);
        size = this.number.length();
    }

    private int sizearr(int a,int b){
        if(a >= b){
            return a;
        }
        else{
            return b;
        }
    }

    private int limit(char n[]){
        int i, lim;
        for (i = 0; n[i] != '\0'; i++);
        i--;
        lim = i;
        return lim;
    }

    private void errleadzer(char[] a){
        while(a[0] == '0'){
            for(int i = 1; i < a.length; i++){
                a[i-1] = a[i];
            }
        }
    }
    public LargeInteger converter(String a){
        LargeInteger temp=new LargeInteger();
        temp.number=a;
        temp.size=a.length();
        return temp;
    }
    public LargeInteger add(String a){
        LargeInteger temp1=converter(a);
        LargeInteger temp2=converter(number);
        LargeInteger ans= new LargeInteger();
        ans = temp2.add(temp1);
        return ans;
    }
    private void nonega(char a[]){
        int i;
        for(i = 1; i < a.length; i++){
            a[i-1] = a[i];
        }
        a[i-1] = '\0';
    }

    public LargeInteger add(LargeInteger a) {
        if((number.charAt(0) == '-' && a.number.charAt(0) == '-') || (number.charAt(0) != '-' && a.number.charAt(0) != '-')){
            char[] temp1 = new char[size];
            char[] temp2 = new char[a.size];
            temp1 = number.toCharArray();
            temp2 = a.number.toCharArray();
            int arrsize1 = getSize();
            int arrsize2 = a.getSize();
            if(number.charAt(0) == '-' && a.number.charAt(0) == '-'){
                nonega(temp1);
                nonega(temp2);
                arrsize1--;
                arrsize2--;
            }
            String c = new String(temp1);
            String d = new String(temp2);
            int[] result = new int[sizearr(arrsize1,arrsize2) + 1];
            plus(result,c,arrsize1);
            plus(result,d,arrsize2);
            char tmp[] = new char[result.length];
            for(int i = 0; i < tmp.length; i++){
                tmp[i] = (char)(result[i] + 48);
            }
            errleadzer(tmp);
            if(result[0] == 0){
                tmp[tmp.length - 1] = '\0';
            }
            String tmp2 = new String(tmp);
            LargeInteger ans = new LargeInteger();

            if(number.charAt(0) == '-' && a.number.charAt(0) == '-'){
                ans.number = "-" + tmp2;
                ans.size = tmp2.length();
            }
            else{
                tmp2 = new String(tmp);
                ans.number = tmp2;
                if(result[0] == 0){
                    ans.size = tmp2.length() - 1;
                }
                else{
                    ans.size = tmp2.length();
                }
            }
            return ans;
        }
        else{
            LargeInteger ans = new LargeInteger();
            if(number.charAt(0) != '-' && a.number.charAt(0) == '-'){
                char[] n2 = new char[a.size];
                n2 = a.number.toCharArray();
                n2[0] = '0';
                String c = new String(n2);
                LargeInteger neww = new LargeInteger();
                neww.number = c;
                neww.size = c.length();
                ans = subtract(neww);
            }
            else{
                ans = subtract(a);
            }
            return ans;
        }
    }
    //no negatives yet
    private void plus(int[] result, String a,int getsize){
        int len = getsize - 1;
        int resultlen = result.length - 1;
        int carry = 0,num1 = 0;
        while(len >= 0){
            num1 = Character.getNumericValue(a.charAt(len));
            // System.out.println(num1 + " mao ni si num1");
            num1 += carry;
            carry = 0;
            if(result[resultlen] + num1 > 9){
                carry = 1;
                num1 = (num1 + result[resultlen]) % 10;
                result[resultlen] = num1;
            }
            else{
                result[resultlen] += num1;
            }
            len--;
            resultlen--;
        }
        if(carry == 1){
            num1 = (result[resultlen] + carry) % 10;
            if(result[resultlen] == 9){
                result[resultlen-1] = 1;
            }
            result[resultlen] = num1;
        }
    }
    public LargeInteger subtract(String a){
        LargeInteger temp1=converter(a);
        LargeInteger temp2=converter(number);
        LargeInteger ans= new LargeInteger();
        ans = temp2.subtract(temp1);
        return ans;
    }
    public LargeInteger subtract(LargeInteger a){
        if((number.charAt(0) != '-' && a.number.charAt(0) != '-') || (number.charAt(0) == '-' && a.number.charAt(0) != '-')){
            int limit = (size > a.size) ? size : a.size;

            char[] n1 = new char[limit+1];
            char[] n2 = new char[limit+1];
            int i,j,z,sum,k;
            char[] ans = new char[limit+1];
            char temp;
            boolean change = false;
            boolean flag = false;
            //n1 = number.toCharArray();
            for(i = 0; i<limit; i++){
                if(i < number.length()){
                    n1[i] = number.charAt(i);
                }
                else{
                    n1[i] = '\0';
                }
            }

            for(i = 0; i<limit; i++){
                if(i < a.number.length()){
                    n2[i] = a.number.charAt(i);
                }
                else{
                    n2[i] = '\0';
                }
            }

            if(number.charAt(0) == '-'){
                n1[0] = '0';
                for(i = 1; i < n1.length; i++){
                    if(n1[i] < n2[i-1]){
                        flag = true;
                        break;
                    }
                }
            }

            int lim1=limit(n1), lim2=limit(n2), lim3;
            int carry;
            if(lim1 == lim2){//if both were the same size this determines which is bigger by comparing the values from first to last until deemed the same
                if(n1[0] == n2[0]){
                    for(i = 0; i <= lim1; i++){
                        if(n1[i] < n2[i]){
                            change = true;
                            break;
                        }
                    }
                }
                if(n1[0] < n2[0]){
                    change = true;
                }
            }
            if(lim2 > lim1 || change == true){//if the second one was bigger which means the outcome was a negative, i had to interchange them and then set a flag that would display a negative answer
                flag = true;
                //System.out.println(n1.length + " " + n2.length);
                for(i = 0; i<limit; i++){
                    ans[i] = n1[i];
                    n1[i] = n2[i];
                }
                for(i = 0; i<limit; i++){
                    n2[i] = ans[i];
                }
                carry=lim1; //size sa array gi swap
                lim1=lim2;
                lim2=carry;
            }
            for(i = 0; lim1 >= 0; lim1--,lim2--,i++){//subtracts the second array from the first aray
                if (lim2 < 0 && lim1 >= 0){//If the second one is shorter, just copy the first arrays remaining numbers
                    sum=(int)(n1[lim1]-48);
                }
                else{
                    if(n1[lim1] < n2[lim2]){//if the first array was less than the second
                        n1[lim1]=(char)(n1[lim1] + 10);
                        j = 1;
                        while(n1[lim1 - j] == 48){//If the one next to it where you 'borrow' is zero, automatically turn it to 9
                            n1[lim1 - j] = 57;
                            j++;
                        }
                        n1[lim1 - j]=(char)(n1[lim1 - j] - 1);// If it isn't a zero you subtract 1 from it
                    }
                    sum = (int)((n1[lim1]-48) - (n2[lim2]-48));//continue normally
                }
                ans[i] = (char)(sum + 48);//add 48 since im using a string of characters
            }
            if(i>1){//Since I stored them right to left there is a possibility that the answers will be "0001" when displayed. I cancel out leading zeroes
                while(ans[i-1]==48){
                    i--;
                    if(i==1 && ans[i-1]==48){//In case zero really is the answer
                        i=1;
                        break;
                    }
                }
            }
            ans[i]='\0';// puts a limit where it should stop
            lim3 = limit(ans);
            for(i=0; i<lim3; i++,lim3--){
                temp=ans[i];
                ans[i]= ans[lim3];
                ans[lim3]=temp;
            }


            String tmp2 = new String(ans);

            LargeInteger res = new LargeInteger();

            if(flag == true){//the display depends if the answer is a positive or a negative
                res.number = "-" + tmp2;
                res.size = tmp2.length();
            }
            else{
                res.number = tmp2;
                res.size = tmp2.length() - 1;
            }

            return res;
        }
        else{
            LargeInteger ans = new LargeInteger();

            if(number.charAt(0) != '-' && a.number.charAt(0) == '-'){
                char[] n2 = new char[a.size];
                n2 = a.number.toCharArray();
                n2[0] = '0';
                String c = new String(n2);
                LargeInteger neww = new LargeInteger();
                neww.number = c;
                neww.size = neww.number.length() + 1;
                ans = add(neww);
            }
            else{
                ans = add(a);
            }
            return ans;

        }
    }


    public LargeInteger multiply(String a){
        LargeInteger temp1=converter(a);
        LargeInteger temp2=converter(number);
        LargeInteger ans= new LargeInteger();
        ans = temp2.multiply(temp1);
        return ans;
    }
    public LargeInteger multiply(LargeInteger a){
        char[] temp1 = new char[size];
        char[] temp2 = new char[a.size];
        temp1 = number.toCharArray();
        temp2 = a.number.toCharArray();
        if(number.charAt(0) == '-'){
            temp1[0] = '0';
        }
        if(a.number.charAt(0) == '-'){
            temp2[0] = '0';
        }
        String c = new String(temp1);
        String d = new String(temp2);
        int[] result = new int[size + a.size];
        int[] anew = new int[sizearr(size,a.size) + 1];
        int carry = 0;
        for(int i = 0; i < a.size; i++){
            int j = 0;
            carry = 0;
            for(; j < size; j++){
                int num1 = Character.getNumericValue(d.charAt(a.size-i-1));
                int num2 = Character.getNumericValue(c.charAt(size-j-1));
                int prod = num1 * num2;
                prod += carry;
                carry = 0;

                if(prod > 9){
                    carry = prod / 10;
                    prod = prod % 10;
                }
                anew[anew.length-j-1] += prod;
            }
            anew[anew.length-j-1] = carry;

            int carry1 = 0;
            int k,l;
            for(k = result.length - i - 1, l = anew.length-1; l >= 0; k--,l--){
                anew[l] += carry1;
                carry1 = 0;
                if(result[k] + anew[l] > 9){
                    carry1 = 1;
                    anew[l] = (anew[l] + result[k]) % 10;
                    result[k] = anew[l];
                }
                else{
                    result[k] += anew[l];
                }
            }
            if(carry1 == 1){
                result[k] = (result[k] + carry) % 10;
                result[k-1] = 1;
            }
            for(int z = 0; z<anew.length;z++){
                anew[z] = 0;
            }
        }

        char tmp[] = new char[result.length + 1];
        for(int i = 0; i < tmp.length - 1; i++){
            tmp[i] = (char)(result[i] + 48);
        }
        tmp[tmp.length-1] = '\0';
        errleadzer(tmp);
        String tmp2 = new String(tmp);
        LargeInteger ans = new LargeInteger();

        if(number.charAt(0) == '-' || a.number.charAt(0) == '-'){
            if(number.charAt(0) == '-' && number.charAt(0) == '-'){
                ans.number = tmp2;
            }
            else{
                ans.number = "-" + tmp2;
            }
            ans.size = tmp2.length() + 1;
        }
        else{
            ans.number = tmp2;
            ans.size = tmp2.length();
        }
        return ans;
    }



    public LargeInteger divide(LargeInteger a){
        LargeInteger ans = new LargeInteger(number);
        LargeInteger tmp = new LargeInteger("0");
        LargeInteger iterator = new LargeInteger("1");
        if(a.number.charAt(0) == '0'){
            String num = "ERR";
            ans.number = "ERR";
            ans.size = ans.number.length();
            return ans;
        }
        while(ans.number.charAt(0) != '0'){
            ans = ans.subtract(a);
            //System.out.println(ans);
            tmp = tmp.add(iterator);
            if(ans.number.charAt(0) == '-'){
                return tmp;
            }
        }

        return tmp;
    }

    public LargeInteger divide(String a){
        LargeInteger ans = new LargeInteger(a);
        ans = divide(ans);
        return ans;
    }

    public LargeInteger add(long a){
        LargeInteger ans = new LargeInteger(a);
        ans = add(ans);
        return ans;
    }

    public LargeInteger subtract(long a){
        LargeInteger ans = new LargeInteger(a);
        ans = subtract(ans);
        return ans;
    }

    public LargeInteger multiply(long a){
        LargeInteger ans = new LargeInteger(a);
        ans = multiply(ans);
        return ans;
    }

    public LargeInteger divide(long a){
        LargeInteger ans = new LargeInteger(a);
        ans = divide(ans);
        return ans;
    }

    public String toString(){
        int i = 0;
        while(number.charAt(i) != '\0'){
            i++;
        }
        char[] a = new char[i];
        for(int j = 0; j < i; j++){
            a[j] = number.charAt(j);
        }
        String new1 = new String(a);
        number = new1;
        return number;
    }




    public boolean equals(LargeInteger b){
        if(number.charAt(0) == '-' && b.number.charAt(0) != '-'){
            return false;
        }
        else if(number.charAt(0) != '-' && b.number.charAt(0) == '-'){
            return true;
        }
        if(number.length() > b.number.length()){
            if(number.charAt(0) == '-')
                return false;
            else
                return true;
        }
        else if(number.length() < b.number.length()){
            if(number.charAt(0) == '-')
                return true;
            else
                return false;
        }
        else{
            char c, d;
            for(int i = 0; i < number.length(); i++){
                c = number.charAt(i);
                d = number.charAt(i);
                if(c > d){
                    if(number.charAt(0) == '-'){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
                else if(c < d){
                    if(number.charAt(0) == '-'){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public String getNumber(){ return this.number; }

    public int getSize(){ return this.size; }
}
