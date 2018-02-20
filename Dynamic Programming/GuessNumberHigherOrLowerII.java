import java.util.*;
import java.io.*;

  public class GuessNumberHigherOrLowerII {
	  
	public static int getMoneyAmount(int number) {
	  if(number <= 1) {
		return 0;	
	  }
	  int[][] dp = new int[number + 1][number + 1];	
	 
	  return helper(dp, 1, number); 	   
    }	  

	private static int helper(int[][] dp, int low, int high) {	  
	  if(dp[low][high] != 0) {
	    return dp[low][high];
	  }
	  
	  if(low >= high) {
	    return 0;
	  } else if(low >= high - 2) {
	    return high - 1;
	  }
		
	  int mid = low + (high-low)/2, min = Integer.MAX_VALUE, i;
	  
	  for(i=mid; i<high; i++) {
	    min = Math.min(min, i + Math.max(helper(dp, i + 1, high) , helper(dp, low, i - 1)));
	  }
	    
	  dp[low][high] = min;
    
      return min;
	}

	public static void main(String[] args) {       
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
			
      int amountOfMoney = getMoneyAmount(number);

      System.out.println();	
      System.out.print("The amount of money you need to have to guarantee a win is: " + amountOfMoney);
	}
  }
