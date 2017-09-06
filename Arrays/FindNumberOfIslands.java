import java.util.*;
import java.io.*;

 public class FindNumberOfIslands {
			 
	public static int countIslands(char array[][]) {
      if(array==null || array.length==0 || array[0].length==0) {
		return 0;
      }
	  int m = array.length;
	  int n = array[0].length;
	  int count = 0;
	  for (int i = 0; i < m; ++i) {
	   for (int j = 0; j < n; ++j) {
	     if(array[i][j] == '1') {
	       count++;
	       merge(array, i, j);
	     }
	   }
	  }  
	  return count;	
	}  
	
	public static void merge(char array[][], int i, int j) {
	  int m = array.length;
	  int n = array[0].length;
	
	  if(i<0||i>=m||j<0||j>=n||array[i][j]!='1') {
	     return;
	  }
	  
	  array[i][j] = 'X';
	  merge(array, i-1, j);
	  merge(array, i+1, j);
	  merge(array, i, j-1);
	  merge(array, i, j+1);
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
	  int count = countIslands(array);
	  System.out.println();
	  System.out.println("Number of islands is: " + count);
	}
 } 
