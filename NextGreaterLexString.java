import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        int len = w.length();
        int i = len-1;
        //locate pivot
        while(i>0 && w.charAt(i-1)>=w.charAt(i))
        i--;

        System.out.println("Pivot is : " + w.charAt(i));
        //if pivot is at end i.e. no pivot
        if(i==0)
            return "no answer";
        
        char x = w.charAt(i-1);
        int j = len -1;

        //swap pre-pivot element with next largest to pivot in the suffix 
        while(w.charAt(j)<=x)
        j--;

         System.out.println("Suffix Element to be swapped is : " + w.charAt(j) + " at : " + j);

        //swap these elements
        w = swap(w, i-1, j);
        System.out.println("Afetr Swap : " + w);

        //reverse the suffix
        return reverse(w, i);

    }

    private static String swap(String w, int i, int j){
        char ch[] = w.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    private static String reverse(String w, int i){
        String w_rev = "";
        for(int a=w.length()-1; a>=i ; a--)
            w_rev += w.charAt(a);

        return w.substring(0,i) + w_rev; 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
