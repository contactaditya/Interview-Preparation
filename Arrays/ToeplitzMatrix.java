import java.util.*;
import java.io.*;

  public class ToeplitzMatrix {
	  
	public static boolean isToeplitzMatrix(int[][] matrix) {
	  for (int i = 0; i < matrix.length - 1; i++) {
	    for (int j = 0; j < matrix[0].length - 1; j++) { 	
		  if(matrix[i][j] != matrix[i + 1][j + 1]) {
			return false;  
		  } 
		}
	  }

	  return true;      
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
	  
	  boolean isToeplitzMatrix = isToeplitzMatrix(array);
	  System.out.println();
	  if(isToeplitzMatrix) {
		System.out.println("The given matrix is Toeplitz.");  
	  }
      else {
		System.out.println("The given matrix is not Toeplitz.");  
	  }
	}
  }
