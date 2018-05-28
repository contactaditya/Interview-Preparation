import java.util.*;
import java.io.*;

  public class BestTimeToBuyAndSellStockWithTransactionFee {
	  
	public static int maxProfit(int[] prices, int fee) {
	  if (prices == null || prices.length <= 1) {
	    return 0;
	  }	
	  int profit = 0;	
	  int start = prices[0];
	  int end = start + fee;
	  
	  for (int i = 1; i < prices.length; i++) {
	    int current = prices[i];	 
	    if(current > end) {
	      end = current;	
	    } else {
          if (current < end - fee) {
            profit += end - start - fee;
            start = current;
            end = start + fee;
          }
	    }
	  }
	  
	  profit += end - start - fee;
	  
	  return profit;      
    }	 	  
	  
	public static int maxProfit1(int[] prices, int fee) {
	  int cash = 0, hold =- prices[0];	
	  for (int i = 1; i < prices.length; i++) {
        cash = Math.max(cash, hold + prices[i] - fee);
        hold = Math.max(hold, cash - prices[i]);
      }
		
	  return cash;      
    }	  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int prices[] = new int[number];
		
	  System.out.println();	
	  System.out.print("Please enter the elements in the array: ");
	  for (int i = 0; i < prices.length; i++) {
		prices[i] = input.nextInt();
	  }
		
	  System.out.println();	
	  System.out.print("Enter the transaction fee for each transaction: ");
	  int fee = input.nextInt();  
		  
	  int maximumProfit = maxProfit(prices, fee); 
	  System.out.println();
	  System.out.println("The maximum profit that you can make is: " + maximumProfit);
	}
  }
