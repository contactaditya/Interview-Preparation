import java.util.*;
import java.io.*;

 public class BestTimeToBuyAndSellStockIII {

   public static int maxProfit(int[] prices) {
      int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE;
      int firstSell = 0, secondSell = 0;
      for(int i:prices) {                      
	secondSell = Math.max(secondSell, secondBuy+i); // The max profit after you buy first stock
	secondBuy = Math.max(secondBuy, firstSell-i);  // The max profit after you sell it
	firstSell = Math.max(firstSell, firstBuy+i);  // The max profit after you buy the second stock
	firstBuy = Math.max(firstBuy, -i);  // The max profit after you sell the second stock
      }
      return secondSell; // secondSell will be the max profit after passing the prices      
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
