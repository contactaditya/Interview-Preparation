import java.util.*;
import java.io.*;

  public class TransposeMatrix {
	  
    public static int[][] transpose(int[][] array) {
      int rows = array.length;
      int columns = array[0].length;
      int answer[][] = new int[columns][rows];
      for(int i = 0; i < rows; i++) {
	for(int j = 0; j < columns; j++) {
	  answer[j][i] = array[i][j];
	}
      }	
		
      return answer;      
    }
	
    private static void printMatrix(int[][] array) {
      System.out.println();
      System.out.println("The transpose of the given matrix is: "); 
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
	  System.out.print(array[i][j] + " ");
	}
	System.out.println();
      }	
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
	  
      int result[][] = transpose(array); 
      printMatrix(result);
    }
  }
