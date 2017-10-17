import java.util.*;
import java.io.*;

 public class BestTimeToBuyAndSellStockIV {
	 
	public static int maxProfit(int k, int[] prices) {
	  if(k>=prices.length/2) {
	    int maxProfit = 0;
		for(int i=1; i<prices.length; i++) {
		  if(prices[i]>prices[i-1]) {
		    maxProfit += prices[i]-prices[i-1];
		  }
		}
	    return maxProfit;
      }
		    
	  int[] maxProfit = new int[k+1];
	  int[] lowPrice = new int[k+1];
	  for(int i=0; i<lowPrice.length; i++) {
		lowPrice[i] = Integer.MAX_VALUE;
	  }
	  for(int p : prices) {
	   for(int i=k; i>=1; i--) {
		 maxProfit[i] = Math.max(maxProfit[i],p-lowPrice[i]);
	     lowPrice[i] = Math.min(lowPrice[i],p-maxProfit[i-1]);
	   } 
	  }
	  return maxProfit[k];
    }	 

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the stock price: ");
	  int numberOfStocks = input.nextInt();   
	  int price[] = new int[numberOfStocks];
		    
	  System.out.println();
	  System.out.print("Please enter the actual values of the cost of the stock: ");
	  for (int i = 0; i < numberOfStocks; i++) {
		price[i] = input.nextInt(); 
	  }
	  
	  System.out.println();
	  System.out.print("Enter the number of transactions: ");
	  int k = input.nextInt();   
		 
	  int maximumProfit = maxProfit(k, price);
	  System.out.println();
	  System.out.print("The maximum profit that can be accomplished by buying and selling stocks of ith element on day i is: " + maximumProfit);	

	}
 }
