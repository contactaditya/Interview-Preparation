import java.util.*;
import java.io.*;

 public class UniquePaths {
	 
	public static int uniquePaths(int m, int n) {
        int[][] array = new int[m][n];
        
        // update the first column
	    for(int i=0; i<m; i++) {
	      array[i][0] = 1;
	    }
        	    
	    // update the first row
	    for(int j=0; j<n; j++) {
	      array[0][j] = 1;
	    }
	        
	    for (int i = 1; i < m; i++) {
          for (int j = 1; j < n; j++) {
             array[i][j] = array[i - 1][j] + array[i][j - 1];
          }
        }
	 
       return array[m-1][n-1]; 
	}	 

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows in the grid: ");
	  int m = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of columns in the grid: ");
	  int n = input.nextInt();  
	  
	  int uniquePaths = uniquePaths(m,n); 
	  System.out.println();
	  System.out.println("The total number of unique paths are: " + uniquePaths);
	  
	}
 }
