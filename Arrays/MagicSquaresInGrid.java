import java.util.*;
import java.io.*;

  public class MagicSquaresInGrid {
	  
    public static int numMagicSquaresInside(int[][] grid) {
      int numberOfMagicSqauresInside = 0;	
      for (int r = 0; r < grid.length-2; r++) {
        for (int c = 0; c < grid[0].length-2; c++) {
          if (magic(grid[r][c], grid[r][c+1], grid[r][c+2], grid[r+1][c], grid[r+1][c+1], grid[r+1][c+2], grid[r+2][c], grid[r+2][c+1], grid[r+2][c+2])) {
        	numberOfMagicSqauresInside++;	 
          }
        }
      }
		
      return numberOfMagicSqauresInside;      
    }	  

    private static boolean magic(int... vals) {
      int[] count = new int[16];
      for (int v : vals) {
	count[v]++;	
      }
      for (int v = 1; v <= 9; v++) {
        if (count[v] != 1) {
          return false;
        }
      }

      return (vals[0] + vals[1] + vals[2] == 15 && vals[3] + vals[4] + vals[5] == 15 && vals[6] + vals[7] + vals[8] == 15 &&
              vals[0] + vals[3] + vals[6] == 15 && vals[1] + vals[4] + vals[7] == 15 & vals[2] + vals[5] + vals[8] == 15 &&
              vals[0] + vals[4] + vals[8] == 15 && vals[2] + vals[4] + vals[6] == 15);
    }

    public static void main(String[] args) { 	
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of rows in the grid: ");
      int x = input.nextInt();  
      System.out.println();
      System.out.print("Please enter the number of columns in the grid: ");
      int y = input.nextInt();  
      int[][] grid = new int[x][y];
      System.out.println();
      System.out.println("Please enter the actual values in the grid: ");
      for(int i=0; i < x; i++) {
        for(int j=0; j < y; j++) {
          grid[i][j] = input.nextInt();
        }
      }
	   
      int result = numMagicSquaresInside(grid); 
      System.out.println();
      System.out.println("The total number of 3 x 3 magic square subgrids in the grid of integers are: " + result);
    }
  }
