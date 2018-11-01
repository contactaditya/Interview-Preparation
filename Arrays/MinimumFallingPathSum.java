import java.util.*;
import java.io.*;

  public class MinimumFallingPathSum {
	  
    public static int minFallingPathSum(int[][] array) {
      int rows = array.length;
      int columns = array[0].length;
      for(int i = 1; i < rows; i++) {
        for(int j = 0; j < columns; j++) {
	  int dp = array[i - 1][j];  
	  if (j > 0) {
            dp = Math.min(dp, array[i - 1][j - 1]);
          } 
          if (j + 1 < columns) {
            dp = Math.min(dp, array[i - 1][j + 1]);
          }
          array[i][j] += dp;
	}
      }
	  
      int min = Integer.MAX_VALUE;
      for (int j = 0, i = rows - 1; j < columns; j++) {
	min = Math.min(min, array[i][j]); 
      }
	  
      return min;
    }

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of rows in the square array: ");
      int x = input.nextInt();  
      System.out.println();
      System.out.print("Please enter the number of columns in the square array: ");
      int y = input.nextInt();  
      int[][] array = new int[x][y];
      System.out.println();
      System.out.println("Please enter the actual values in the square array: ");
      for(int i=0; i < x; i++) {
        for(int j=0; j < y; j++){
          array[i][j] = input.nextInt();
        }
      }
	  
      int result = minFallingPathSum(array); 
      System.out.println();
      System.out.println("The minimum sum of the falling path through the array is: " + result);	
      input.close();
    }
  }
