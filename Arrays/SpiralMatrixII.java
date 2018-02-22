import java.util.*;
import java.io.*;

  public class SpiralMatrixII {
	  
     public static int[][] generateMatrix(int n) { 	  
       int matrix[][] = new int[n][n];	
       if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	 return matrix;
       }
       int rowMin = 0, colMin = 0, rowMax = matrix.length - 1, colMax = matrix[0].length - 1;
	  
       int number = 1;
	  
       while(rowMin <= rowMax && colMin <= colMax) {
	 for(int i = colMin; i <= colMax; i++) {
	   matrix[rowMin][i] = number++; 
         }
	 rowMin++;  
	    
	 for(int i = rowMin; i <= rowMax; i++) {
	   matrix[i][colMax] = number++; 
	 }
	 colMax--;
	    
	 if(rowMin > rowMax || colMin > colMax) {
	   break;
	 }
	    
	 for(int i = colMax; i >= colMin; i--) {
	   matrix[rowMax][i] = number++;
	 }
	 rowMax--;  
		
         for(int i = rowMax; i >= rowMin; i--) {
    	  matrix[i][colMin] = number++;
         }
         colMin++;
       }
		
       return matrix;     
     }	  

     public static void main(String[] args) { 	  
       Scanner input = new Scanner(System.in);
       System.out.print("Please enter the integer: ");
       int n = input.nextInt();  
	  
       int matrix[][] = new int[n][n];
       matrix = generateMatrix(n); 
       System.out.println();
       System.out.println("A square matrix filled with elements from 1 to n^2 in spiral order is: " );
       for(int i = 0; i < n; i++) {
	 for(int j = 0; j < n; j++) {
	    System.out.print(matrix[i][j] + " "); 
	 }
       }
     }
  }
