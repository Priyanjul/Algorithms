import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        int prod, carry, i, len, j;
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for(i=2;i<=n;i++){
            carry = 0;
            len = res.size();
            for(j=0;j<len;j++){
                prod = i*res.get(j);
                prod=prod+carry;
                res.set(j, prod%10);
                carry = (prod-prod%10)/10;
            }
            if(carry != 0){
                if(carry<10)
                    res.add(carry);
                else{
                    res.add(carry%10);
                    res.add(carry/10);
                }
            }
        }

        Collections.reverse(res);
        for(Integer k : res){
            System.out.print(k);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
