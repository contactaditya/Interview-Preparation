import java.util.*;
import java.io.*;

 public class PerfectSquares {
	 
    public static int numberOfSquares(int number) {
       if (number <= 0) {
          return 0;
       }
       int dp[] = new int[number+1];
       Arrays.fill(dp, Integer.MAX_VALUE);	

       for(int i = 0; i <= number; i++) {
	 dp[i] = i;  
	 for(int j=1; j*j<=i; j++) {
           dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
         }
       }
		
       return dp[number];    
    }	 

    public static void main(String[] args) {   
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the number: ");
       int number = input.nextInt();   
       int leastNumberOfPerfectSquareNumbers = numberOfSquares(number);
       System.out.println();
       System.out.println("The least number of perfect square numbers which sum to " + number + " is: " + leastNumberOfPerfectSquareNumbers);  
    }
 }
