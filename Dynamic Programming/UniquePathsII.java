import java.util.*;
import java.io.*;

  public class UniquePathsII {
	  
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int width = obstacleGrid[0].length;
      int[] dp = new int[width];
      dp[0] = 1;
      for (int[] row : obstacleGrid) {
        for (int j = 0; j < width; j++) {
	  if (row[j] == 1) {
	    dp[j] = 0;
	  }
	  else if (j > 0) {
	    dp[j] += dp[j - 1];
	  }
	}
      }
      return dp[width - 1];
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
	  
       int uniquePaths = uniquePathsWithObstacles(array); 
       System.out.println();
       System.out.println("The total number of unique paths are: " + uniquePaths);

    }
  }
