import java.util.*;
import java.io.*;

 public class SearchA2DMatrix {
	 
   public static boolean searchMatrix(int[][] matrix, int target) {
     if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	return false;
     }
     int i = 0, j = matrix[0].length - 1;
     while (i < matrix.length && j >= 0) {
       if (matrix[i][j] == target) {
	 return true;
       } else if (matrix[i][j] > target) {
	 j--;
       } else {
	 i++;
       }
     }
	            
     return false;
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
        for(int j=0; j < y; j++){
          matrix[i][j] = input.nextInt();
        }
      }
	  
      System.out.println();	
      System.out.print("Please enter a target number: ");
      int target = input.nextInt();
	  
      System.out.println();	
      if(searchMatrix(matrix, target)) {
	System.out.println("Yes " + target + " is present in the matrix.");  
      } 
      else {
	System.out.println("No " + target + " is not present in the matrix.");  
      } 
   }
 }
