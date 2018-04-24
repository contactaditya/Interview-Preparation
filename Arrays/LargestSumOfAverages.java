import java.util.*;
import java.io.*;

  public class LargestSumOfAverages {
	  
	public static double largestSumOfAverages(int[] array, int K) {
      int N = array.length;
      double[] P = new double[N+1];	
      for (int i = 0; i < N; i++) {
        P[i+1] = P[i] + array[i];
      }
      double[] dp = new double[N];
      for (int i = 0; i < N; i++) {
        dp[i] = (P[N] - P[i]) / (N - i);
      }
      
      for (int k = 0; k < K-1; k++) {
        for (int i = 0; i < N; i++) {
          for (int j = i+1; j < N; j++) {
        	dp[i] = Math.max(dp[i], (P[j]-P[i]) / (j-i) + dp[j]);  
          }
        }
      }
		
	  return dp[0];      
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
	  System.out.print("Enter the number of counters: ");
	  int K = input.nextInt();   
		
	  double largestSumOfAverages = largestSumOfAverages(array, K); 
	  System.out.println();	
	  System.out.print("The largest score that can be achieved in " + K + " adjacent (non-empty) groups is: " + largestSumOfAverages);
	}
  }
