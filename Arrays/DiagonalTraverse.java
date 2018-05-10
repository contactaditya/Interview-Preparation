import java.util.*;
import java.io.*;

  public class DiagonalTraverse {
	  
	public static int[] findDiagonalOrder(int[][] matrix) {
      if (matrix.length == 0) {
    	return new int[0];
      }
      int row = 0, column = 0, m = matrix.length, n = matrix[0].length, array[] = new int[m * n];
      for (int i = 0; i < array.length; i++) {
        array[i] = matrix[row][column];	  
    	if((row + column) % 2 == 0) {
    	  // moving up
          if(column == n - 1) { 
        	row++; 
          } else if(row == 0) {
        	column++; 
          }
          else {
        	row--;
        	column++;
          }
    	} else {
          if(row == m - 1) { 
            column++; 
          } else if(column == 0) {
            row++; 
          } else {
            row++;
            column--;
          }
    	}
      }
		
	  return array;      
    }	  
	
	private static void printMatrix(int[] array) {
	  System.out.println();
	  System.out.print("All elements of the matrix in diagonal order are: "); 
      for (int i = 0; i < array.length; i++) {
		System.out.print(array[i] + " ");	
	  }	
	}	

	public static void main(String[] args) { 	 
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
        for(int j=0; j < y; j++) {
          matrix[i][j] = input.nextInt();
        }
      }
	  
	  int result[] = findDiagonalOrder(matrix); 
	  printMatrix(result);
	}
  }
