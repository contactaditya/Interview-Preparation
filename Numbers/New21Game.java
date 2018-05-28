import java.util.*;
import java.io.*;

  public class New21Game {
	  
	public static double new21Game(int N, int K, int W) {
	  double[] dp = new double[N + W + 1];	
	  for (int k = K; k <= N; k++) {
        dp[k] = 1.0;
	  }
	  double S = Math.min(N - K + 1, W);
      for (int k = K - 1; k >= 0; k--) {
        dp[k] = S / W;
        S += dp[k] - dp[k + W];
      }
		
	  return dp[0];      
	}	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number of points: ");
	  int N = input.nextInt();  
	 
	  System.out.println();	
	  System.out.print("Enter the points after which the person stops drawing numbers: ");
	  int K = input.nextInt();  
	  
	  System.out.println();	
	  System.out.print("Enter the end point of the range from which the person gains an integer number of points randomly: ");
	  int W = input.nextInt();  
	 
	  double result = new21Game(N, K, W);
	  System.out.println();
	  System.out.print("The probability that she has " + N + " or less points is: " + result);  
	}
  }
