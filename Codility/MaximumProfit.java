import java.util.*;
import java.io.*;

  public class MaximumProfit {
	  
    private static int maxProfit(int[] prices) {
      int maxCurrent = 0, maxSoFar = 0; 
      for(int i = 1; i < prices.length; i++) {
	maxCurrent = Math.max(0, maxCurrent += prices[i] - prices[i-1]);
	maxSoFar = Math.max(maxCurrent, maxSoFar);
      }
      if(maxSoFar <= 0) {
	return 0;   
      }
      return maxSoFar;	
    }	
	
    private static int maxProfit1(int[] prices) {
      int minprice = Integer.MAX_VALUE;
      int maxprofit = 0;
      for (int i = 0; i < prices.length; i++) {
	if (prices[i] < minprice) {
	  minprice = prices[i];
	}
	else if (prices[i] - minprice > maxprofit) {
	  maxprofit = prices[i] - minprice;
	}
      }
      if(maxprofit <= 0) {
	return 0;
      }        
	      
      return maxprofit;
    }
	  
    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		
      System.out.println();	
      System.out.print("Please enter the elements of the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
			
      int maxProfit = maxProfit(array);
      System.out.println();	
      System.out.println("The maximum possible profit from one transaction during this period is: " + maxProfit);

    }
  }
