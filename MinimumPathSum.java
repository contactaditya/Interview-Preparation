import java.util.*;
import java.io.*;

 public class MinimumPathSum {
    
	public static int findMinimumPathSum(int[][] array) {
	    if(array == null || array.length==0) {
		   return 0;	
		}
	    
	    int m = array.length;
	    int n = array[0].length;
	    
	    int dp[][] = new int[m][n];
	    dp[0][0] = array[0][0]; 
	    
	    // update the first row
	    for(int i=1; i<n; i++) {
	      dp[0][i] = dp[0][i-1] + array[0][i];
	    }
	    
	    // update the first column
	    for(int j=1; j<m; j++) {
	      dp[j][0] = dp[j-1][0] + array[j][0];
	    }
	    
	    for (int i = 1; i < m; i++) {
          for (int j = 1; j < n; j++) {
             dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + array[i][j];
          }
        }
	 
       return dp[m-1][n-1];
	}	 

	public static void main(String[] args) { 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows in the grid: ");
	  int x = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of columns in the grid: ");
	  int y = input.nextInt();  
	  int[][] array = new int[x][y];
	  System.out.println();
	  System.out.println("Please enter the actual values in the grid: ");
	  for(int i=0; i < x; i++) {
        for(int j=0; j < y; j++){
          array[i][j] = input.nextInt();
        }
      }
	  
	  int sum = findMinimumPathSum(array); 
	  System.out.println();
	  System.out.println("The minimum sum of all numbers along its path are: " + sum);
	  
	}
 }
