import java.util.*;
import java.io.*;

  public class CombinationSumIV {
    static private int[] dp; 
	  
    public static int combinationSum4(int[] array, int target) { 
      dp = new int[target + 1];
      Arrays.fill(dp, -1);
      dp[0] = 1;
      return helper(array, target);
    }	  

    private static int helper(int[] array, int target) {
      if (dp[target] != -1) {
	return dp[target];
      } 
      int result = 0;
      for (int i = 0; i < array.length; i++) {
        if (target >= array[i]) {
	  result += helper(array, target - array[i]);
	}
      }
      dp[target] = result;
      return result;
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];
					    
      System.out.println();	
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
	array[i] = input.nextInt(); 
      } 
      System.out.println();	
      System.out.print("Enter the target sum: ");
      int target = input.nextInt();  
		  
      System.out.println();
      int result = combinationSum4(array, target); 
      System.out.println("The number of possible combinations that add up to a positive integer " + target + " are : " + result);
    }
  }
