import java.util.*;
import java.io.*;

   public class FindTheNumberOfIslands {
     static final int ROW = 5;
     static final int COLUMN = 5;
	
     public static boolean isSafe(int array[][], int row, int column, boolean visited[][]) {
       // Row Number is in range, Column Number is in range and value is 1 and not yet visited	
       return (row >= 0) && (row < ROW) && (column >= 0) && (column < COLUMN) && (array[row][column] == 1 && !visited[row][column]);
     } 

     public static void DFS(int array[][], int row, int column, boolean visited[][]) {
       int count = 0;	
       int rowNumber[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
       int columnNumber[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1}; 	
      
       // Mark this cell as visited
       visited[row][column] = true;
       for (int k = 0; k < 8; k++) {
         if (isSafe(array, row + rowNumber[k], column + columnNumber[k], visited)) {
           DFS(array, row + rowNumber[k], column + columnNumber[k], visited);  
         }
       }
     } 
	 
     public static int countIslands(int array[][]) {
       // Make a boolean array to mark visited cells. Initially all cells are unvisited.
       boolean visited[][] = new boolean[ROW][COLUMN];	
    	
       int count = 0;	
       for (int i = 0; i < ROW; ++i) {
         for (int j = 0; j < COLUMN; ++j) {
           if(array[i][j] == 1 && !visited[i][j]) {
             DFS(array, i, j, visited);
             count++;
           }
         }
       }
    
       return count;	
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
       int count = countIslands(array);
       System.out.println();
       System.out.println("Number of islands is: " + count);
     }
   }
