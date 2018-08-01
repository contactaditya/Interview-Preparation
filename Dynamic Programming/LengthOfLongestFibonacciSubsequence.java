import java.util.*;
import java.io.*;

  public class LengthOfLongestFibonacciSubsequence {
	  
    public static int lenLongestFibSubseq(int[] array) {
      int result = 0;
      if (array == null || array.length == 0) {
        return 0;
      }
      int dp[][] = new int[array.length][array.length];
      for(int i = 2; i < array.length; i++) {
        int low = 0, high = i-1;
        while(low < high) {
          int sum = array[low] + array[high];
          if(sum < array[i]) {
            low++;
          }
          else if(sum > array[i]) {
            high--;
          }
          else{
            dp[high][i] = Math.max(dp[high][i], dp[low][high] == 0 ? 3 : dp[low][high] + 1);
            result = Math.max(result, dp[high][i]);
            low++;
          }
        }
      }
    	
      return result;      
	}

	public static void main(String[] args) {     
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for (int i = 0; i < array.length; i++) {
        array[i] = input.nextInt();
      }
      int result = lenLongestFibSubseq(array);
      
      System.out.println();	
      System.out.print("The length of the longest fibonacci-like subsequence of the array is: " + result);
	}
  }
