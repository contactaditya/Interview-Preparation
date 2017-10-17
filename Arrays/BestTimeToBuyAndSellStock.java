import java.util.*;
import java.io.*;

  public class BestTimeToBuyAndSellStock {
	  
    private static int maxProfit(int[] prices) {
      int maxCurrent = 0, maxSoFar = 0;
      for(int i = 1; i < prices.length; i++) {
	 maxCurrent = Math.max(0, maxCurrent += prices[i] - prices[i-1]);
	 maxSoFar = Math.max(maxCurrent, maxSoFar);
      }
      return maxSoFar;
    }	  
	
    public int maxProfit1(int[] prices) {
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
      return maxprofit;
    }

    public static void main(String[] args) { 	  
       Scanner input = new Scanner(System.in);
       System.out.print("Enter number of elements in the stock price: ");
       int numberOfStocks = input.nextInt();   
       int price[] = new int[numberOfStocks];
	    
       System.out.print("\n");
       System.out.print("Please enter the actual values of the cost of the stock: ");
       for (int i = 0; i < numberOfStocks; i++) {
	 price[i] = input.nextInt(); 
       }
	 
       int maximumProfit = maxProfit(price);
       System.out.print("\n");
       System.out.print("The maximum profit that can be accomplished by buying and selling stocks of ith element on day i is: " + maximumProfit);
    }
  }
