import java.util.*;
import java.io.*;

  public class MaxAreaOfIsland {
	private static int[][] array;
	private static boolean[][] seen;  
	  
	public int area(int row, int column) {       
	  if(row < 0 || row >= array.length || column < 0 || column >= array[0].length || seen[row][column] || array[row][column] == 0) {
		return 0;
      }
	  seen[row][column] = true;
      return (1 + area(row+1, column) + area(row-1, column) + area(row, column-1) + area(row, column+1));
    }	  
	
	public int maxAreaOfIsland(int[][] array) {
	  this.array = array;  	
      seen = new boolean[array.length][array[0].length];
      int answer = 0;
      for (int row = 0; row < array.length; row++) {
        for (int column = 0; column < array[0].length; column++) {
          answer = Math.max(answer, area(row, column));
        }
      }
      return answer;
    }

	public static void main(String[] args) { 	
	  MaxAreaOfIsland island = new MaxAreaOfIsland();	
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows in the matrix: ");
	  int x = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of columns in the matrix: ");
      int y = input.nextInt();  
	  int[][] matrix = new int[x][y];
	  System.out.println();
	  System.out.println("Please enter the actual values in the matrix: ");
	  for(int i=0; i < x; i++) {
	    for(int j=0; j < y; j++){
	      matrix[i][j] = input.nextInt();
	    }
	  }
	  int maxAreaOfIsland = island.maxAreaOfIsland(matrix);
	  System.out.println();
	  System.out.println("The maximum area of an island in the given array is: " + maxAreaOfIsland);

	}
  }
