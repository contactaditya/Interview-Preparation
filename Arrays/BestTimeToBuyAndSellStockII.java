import java.util.*;
import java.io.*;

 public class BestTimeToBuyAndSellStockII {
	  
     public static int maxProfit(int[] prices) {
	int total = 0;	
	for (int i=0; i< prices.length-1; i++) {
	  if (prices[i+1]>prices[i]) {
	    total += prices[i+1]-prices[i];
	  }
	}
	
        return total;     
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
