import java.util.*;
import java.io.*;

  public class TargetSum {
	  
	public static int findTargetSumWays(int[] array, int targetSum) {
	  int sum = 0; 
      for(int i: array) {
    	 sum+=i;
      }
      if(targetSum>sum || targetSum<-sum) {
    	 return 0;
      }
      int[] dp = new int[2*sum+1];
      dp[0+sum] = 1;
      for(int i = 0; i<array.length; i++) {
        int[] next = new int[2*sum+1];
        for(int k = 0; k<2*sum+1; k++) {
          if(dp[k]!=0) {
            next[k + array[i]] += dp[k];
            next[k - array[i]] += dp[k];
          }
        }
        dp = next;
      }
      return dp[sum+targetSum];        
	}	  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];
			    
	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt(); 
	  }
	  System.out.println();
	  System.out.print("Enter the target sum: ");
	  int sum = input.nextInt();   

	  int result = findTargetSumWays(array, sum);
	  System.out.println();
	  System.out.print("The number of ways to assign symbols to make sum of integers equal to target " + sum + " is: " + result);	
	  
	}
  }
