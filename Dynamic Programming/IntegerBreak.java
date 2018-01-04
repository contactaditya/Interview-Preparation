import java.util.*;
import java.io.*;

  public class IntegerBreak {
	  
	public static int integerBreak(int number) {
	  int[] dp = new int[number + 1];
	  dp[1] = 1;
	  for(int i = 2; i <= number; i ++) {
	    for(int j = 1; j < i; j ++) {
	      dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
	    }
	  }
	  return dp[number];  
	}	  
	
	public static int integerBreak1(int number) {
      if(number == 2 || number == 3) {
    	return number - 1;
      }
      if (number == 4) {
    	return 4;
      }
	  int product = 1;
	  while(number > 4) {
		number = number - 3;  
	    product = product * 3;
	  }
	  product = product * number;
	        
	  return product;
	}
	

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();  
	  System.out.println();	

	  int maxProduct = integerBreak(number);
	  System.out.println();	
	  System.out.print("The maximum of the product of the integers found after breaking the original number into sum of at least two positive integers is: " + maxProduct);
	}
  }
