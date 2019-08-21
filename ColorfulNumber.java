//TIME COMPLEXITY : O(N^N)
//SPACE COMPLEXITY : O(N), dependent on product of all digits of number
import java.util.*;
public class ColorfulNumber
{
    //GET MAX SIZE FOR HASH TABLE (=PRODUCT OF ALL DIGITS IN NUMBER)
    public static int getHashSize(int n){
        int prod=1;
        int r;
        
        while(n!=0){
            r = n%10;
            prod*=r;
            n/=10;
        }
        return prod;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input :");
		int n = sc.nextInt();
		
		//SIZE OF HASH ARRAY
		int hashSize = getHashSize(n);
		//BOOLEAN HASH ARRAY
		boolean hash[] = new boolean[hashSize+1];
		//LENGTH OF NUMBER
		int len = 1;
		//STORES PRODUCT OF DIGITS
		int prod;
		//RAISED(TRUE) IF NOT COLORFUL NUMBER 
	    boolean flag = false;
		 
		//CALCULATING LENGTH OF NUMBER(MAX 99999)
	    if(n>=10){ 
	        len = 2;
	        if(n>=100){
	            len = 3;
	            if(n>=1000){
	                len = 4;
	                    if(n>=10000) 
	                        len = 5;
	            }
	            
	        }
	    }
	   
	    //STORES TOKENIZED NUMBER
		int num[]=new int[len];
	    
	    //BREAKING THE NUMBER INTO ARRAY
	    for(int i=1;i<=len;i++){
	        num[i-1] = (n/(int)Math.pow(10,len-i))%10;
	    }
	   
	    
	    //CHECKING FOR COLORFUL NUMBER
	    for(int i=0; i<len; i++){
	        prod = 1;
	        for( int j=i; j<len; j++){
	            prod *= num[j];
	            if(!hash[prod])
	                hash[prod]=true;
	            else{
	                flag = true;
	                break;
	            }
	        }
	    }
	    
	    if(flag)
		    System.out.println("NOT COLORFUL!");
		else
		    System.out.println("COLORFUL!");
	}
}
