import java.util.*;
import java.io.*;

  public class MostProfitAssigningWork {
	  
	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
	  Map<Integer, Integer> map = new HashMap<>();
	  for (int i = 0; i < profit.length; i++) {
	    map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));
	  }
	  int max = Integer.MIN_VALUE;
	  for (int n : worker) {
	    max = Math.max(max, n);
	  }
	  int[] dp = new int[max + 1];
	  for (int i = 1; i < dp.length; i++) {
	    dp[i] = Math.max(dp[i - 1], map.getOrDefault(i, 0));
	  }
	  int result = 0;
	  for (int n : worker) {
	    result += dp[n];
	  }
	  return result;       
	}	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the difficulty array: ");
      int number = input.nextInt();  
      int difficulty[] = new int[number];
	 
      System.out.println();	
      System.out.print("Please enter the actual difficulty in the ith job: ");
      for (int i = 0; i < difficulty.length; i++) {
    	difficulty[i] = input.nextInt();
      }
      
      int profit[] = new int[number];
	 
      System.out.println();	
      System.out.print("Please enter the actual profit in the ith job: ");
      for (int i = 0; i < profit.length; i++) {
    	profit[i] = input.nextInt();
      }
      
	  System.out.print("Enter number of elements in the worker array: ");
      int number1 = input.nextInt();  
      int worker[] = new int[number1];
	 
      System.out.println();	
      System.out.print("Please enter the actual worker in the ith job: ");
      for (int i = 0; i < worker.length; i++) {
    	worker[i] = input.nextInt();
      }
      
	  int mostProfit = maxProfitAssignment(difficulty, profit, worker);   
	  System.out.println();	
      System.out.print("The most profit that can be made is: " + mostProfit);

	}
  }
