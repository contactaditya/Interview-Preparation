import java.util.*;
import java.io.*;

  public class MaximalSquare {
	  
    public static int maximalSquare(char[][] matrix) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	  return 0;	
       }
       int rows = matrix.length, columns = matrix[0].length;
       int[][] dp = new int[rows + 1][columns + 1];
       int maxSquareLength = 0;
       for (int i = 1; i <= rows; i++) {
         for (int j = 1; j <= columns; j++) {
           if (matrix[i-1][j-1] == '1') {
             dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
             maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
           }	 
         }
       }

       return maxSquareLength * maxSquareLength;     
    }	  
	
    public static int maximalSquare1(char[][] matrix) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	  return 0;	
       }
       int rows = matrix.length, columns = matrix[0].length;
       int[] dp = new int[columns + 1];
       int maxSquareLength = 0, previous = 0;
       for (int i = 1; i <= rows; i++) {
	 for (int j = 1; j <= columns; j++) {
	   int temp = dp[j];	
	   if (matrix[i-1][j-1] == '1') {
	     dp[j] = Math.min(Math.min(dp[j - 1], previous), dp[j]) + 1;
	     maxSquareLength = Math.max(maxSquareLength, dp[j]);
	   } else {
             dp[j] = 0;
           }	
	   previous = temp;
         }
       }

       return maxSquareLength * maxSquareLength;     
    }	  

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.print("Please enter the number of rows in the matrix: ");
       int x = input.nextInt();  
       System.out.println(); 
       System.out.print("Please enter the number of columns in the matrix: ");
       int y = input.nextInt();  
       char[][] array = new char[x][y];
       System.out.println();
       System.out.println("Please enter the actual values in the matrix: ");
       for(int i=0; i < x; i++) {
	 for(int j=0; j < y; j++){
	   array[i][j] = input.next().charAt(0);
	 }
       }
       int area = maximalSquare1(array);
       System.out.println();
       System.out.println("The area of the largest square containing only 1's is: " + area);
    }
 }
