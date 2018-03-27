import java.util.*;
import java.io.*;

  public class CoinChange {
	static int total = Integer.MAX_VALUE;    
	  
	public static int coinChange(int[] coins, int amount) {
	  if(amount < 0) {
		return 0;  
	  }
	  int max = amount + 1;
	  int dp[] = new int[amount + 1];
	  Arrays.fill(dp, max);  
	  dp[0] = 0;
	
	  for(int i = 1; i <= amount; i++) {
	    for(int j = 0; j < coins.length; j++) {
	      if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          }  
		}
	  }
	  
	  return dp[amount] > amount ? -1 : dp[amount];      
	}
	
	public static int coinChange1(int[] coins, int amount) {
	  if (amount == 0) {
		return 0;
	  }
	  Arrays.sort(coins);
	  count(amount, coins.length-1, coins, 0);
	  return total == Integer.MAX_VALUE ? -1 : total;
	}
 
	private static void count(int amount, int index, int[] coins, int count) {
	  if (index<0 || count>=total-1) {
		return;
	  }
	  int number = amount/coins[index];
	  for (int i = number; i >= 0; i--) {
		int newCount = count + i;
		int remaining = amount - i * coins[index];
		if (remaining > 0 && newCount < total) {
		  count(remaining, index-1, coins, newCount);
		} else if (newCount < total) {
	      total = newCount;
	    } else if (newCount >= total - 1) {
		  break;
	    }
	  }
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
		 
	  int fewestNumberOfCoins = coinChange1(coins, amount);
	  System.out.println();
	  System.out.print("The fewest number of coins that you need to make up the " + amount + " are: " + fewestNumberOfCoins);	

	}

  }
