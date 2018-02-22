import java.util.*;
import java.io.*;
 
  public class SpiralMatrix {
	  
    public static List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> result = new ArrayList<Integer>();	
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	return result;
      }
      int rowMin = 0, colMin = 0, rowMax = matrix.length - 1, colMax = matrix[0].length - 1;
	  
      while(rowMin <= rowMax && colMin <= colMax) {
	for(int i = colMin; i <= colMax; i++) {
	  result.add(matrix[rowMin][i]);
	}
	rowMin++;  
	    
	for(int i = rowMin; i <= rowMax; i++) {
	  result.add(matrix[i][colMax]);
	}
	colMax--;
		
	if(rowMin > rowMax || colMin > colMax) {
	  break;
	}
		
        for(int i = colMax; i >= colMin; i--) {
	  result.add(matrix[rowMax][i]);
	}
	rowMax--;  
		
        for(int i=rowMax; i >=rowMin ; i--) {
          result.add(matrix[i][colMin]);
        }
        colMin++;
      }
		
      return result;      
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
	  
      List<Integer> result = new ArrayList<Integer>();
      result = spiralOrder(matrix); 
      System.out.println();
      System.out.println("All elements of the matrix in spiral order are: " + result);
    }
  }
