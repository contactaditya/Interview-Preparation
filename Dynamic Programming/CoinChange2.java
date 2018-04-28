import java.util.*;
import java.io.*;

  public class CoinChange2 {
	 
    public static int change(int target, int[] coins) {
      int[] dp = new int[target + 1];
      dp[0] = 1;
      for (int coin : coins) {
	for (int i = coin; i <= target; i++) {
	  if (i >= coin) { 
	    dp[i] += dp[i-coin];
	  }
	}
      }
      return dp[target]; 
    } 

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);	  
      System.out.print("Enter number of coins: ");
      int numberOfCoins = input.nextInt();   
      int coins[] = new int[numberOfCoins];
		    
      System.out.println();
      System.out.print("Please enter the actual values of the coins of different denominations: ");
      for (int i = 0; i < numberOfCoins; i++) {
	coins[i] = input.nextInt(); 
      }
	  
      System.out.println();
      System.out.print("Enter the total amount of money: ");
      int amount = input.nextInt();   
		 
      int numberOfCombinations = change(amount, coins);
      System.out.println();
      System.out.print("The number of combinations that make up " + amount + " are: " +  numberOfCombinations);
    }
  }
