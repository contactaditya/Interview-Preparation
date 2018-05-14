import java.util.*;
import java.io.*;

  public class ZeroOneMatrix {
	  
    public static int[][] updateMatrix(int[][] matrix) {
      int rows = matrix.length;
      int columns = matrix[0].length;
      if (rows == 0 || matrix[0].length == 0) {
	return matrix;
      }
      
      //First pass: check for left and top
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (matrix[i][j] != 0) {	
            int up = i > 0 ? matrix[i - 1][j] : Integer.MAX_VALUE - 1;
            int left = j > 0 ? matrix[i][j - 1] : Integer.MAX_VALUE - 1;
            matrix[i][j] = Math.min(Integer.MAX_VALUE - 1, Math.min(up, left) + 1);
          }
        }
      }
      
      //Second pass: check for bottom and right
      for (int i = rows - 1; i >= 0; i--) {
        for (int j = columns - 1; j >= 0; j--) {
          if (matrix[i][j] != 0) {	
            int bottom = i + 1 < rows ? matrix[i + 1][j] : Integer.MAX_VALUE - 1;
            int right = j + 1 < columns ? matrix[i][j + 1] : Integer.MAX_VALUE - 1;
            matrix[i][j] = Math.min(matrix[i][j], Math.min(bottom, right) + 1);
          }
        }
      }
		
      return matrix;      
    }  
	   
    public static void main(String[] args) { 	
      Scanner input = new Scanner(System.in);
      System.out.print("Please enter the number of rows in the matrix: ");
      int x = input.nextInt();  
      System.out.println();
      System.out.print("Please enter the number of columns in the matrix: ");
      int y = input.nextInt();  
      int[][] array = new int[x][y];
      System.out.println();
      System.out.println("Please enter the actual values in the matrix: ");
      for(int i=0; i < x; i++) {
        for(int j=0; j < y; j++) {
         array[i][j] = input.nextInt();
        }
      }
      int result[][] = updateMatrix(array);	  
      System.out.println();
      System.out.println("The distance of the nearest 0 for each cell in the updated matrix is: ");
      for(int i = 0; i < result.length; i++) {
        for(int j = 0; j < result[i].length; j++) {
	  System.out.print(result[i][j] + " "); 
	}
        System.out.println();
      }
    }
  }
