import java.util.*;
import java.io.*;

  public class ReshapeTheMatrix {
	  
    public static int[][] matrixReshape(int[][] array, int r, int c) {
      int m = array.length, n = array[0].length;
      if (m * n != r * c) {
    	return array;	
      }
      int[][] matrix = new int[r][c];
      int row = 0, col = 0;
      for(int i = 0; i < array.length; i++) {
	for(int j = 0; j < array[0].length; j++) {
	  matrix[row][col] = array[i][j];
	  col++;
	  if (col == c) {
            col = 0;
            row++;
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
        for(int j=0; j < y; j++){
          array[i][j] = input.nextInt();
        }
      }
	  
      System.out.println();	
      System.out.print("Enter the row number of the wanted reshaped matrix: ");
      int r = input.nextInt();  
	  
      System.out.println();	
      System.out.print("Enter the column number of the wanted reshaped matrix: ");
      int c = input.nextInt();  
	  
      int matrix[][] = new int[x][y];
      matrix = matrixReshape(array, r, c); 
      System.out.println();
      System.out.println("The new reshaped matrix will look like this: ");
      for(int i = 0; i < matrix.length; i++) {
	for(int j = 0; j < matrix[0].length; j++) {
	  System.out.print(matrix[i][j] + " "); 
	} 
      }
    }
  }
