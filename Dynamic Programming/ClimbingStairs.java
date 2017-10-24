import java.util.*;
import java.io.*;

  public class ClimbingStairs {
	  
	public static int climbStairs(int numberOfSteps) {	
	   if (numberOfSteps == 1) {
	     return 1;
	   }
	   
	   int first = 1;
       int second = 2;
       for (int i = 3; i <= numberOfSteps; i++) {
         int third = first + second;
         first = second;
         second = third;
       }
       
       return second;
    }  	  
	
	public static int climbStairs1(int numberOfSteps) {	
	   if (numberOfSteps == 1) {
         return 1;
       }
       int[] dp = new int[numberOfSteps + 1];
       dp[1] = 1;
       dp[2] = 2;
       for (int i = 3; i <= numberOfSteps; i++) {
         dp[i] = dp[i - 1] + dp[i - 2];
       }
       
       return dp[numberOfSteps];	
	}  

	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int numberOfSteps = input.nextInt();  
		    
	   int smallestPossibleSubArrayLength = climbStairs(numberOfSteps);
	   System.out.println();	
	   System.out.print("The number of distinct ways can you climb to the top of the stairs is: " + smallestPossibleSubArrayLength);	
	}
  }
