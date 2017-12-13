import java.util.*;
import java.io.*;

 public class RangeAdditionII {
	 
	public static int maxCount(int m, int n, int[][] operations) {
	  for(int k = 0; k < operations.length; k++) {
	    if(operations[k][0] < m){
          m = operations[k][0];
        }
        if(operations[k][1] < n){
          n = operations[k][1];
        }
      }
      return m * n;    
	}	

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Please enter the number of rows in the matrix: ");
	  int m = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the number of columns in the matrix: ");
	  int n = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the lower range of operations: ");
	  int a = input.nextInt();  
	  System.out.println();
	  System.out.print("Please enter the higher range of operations: ");
	  int b = input.nextInt();  
	  int[][] array = new int[a][b];
	  System.out.println();
	  System.out.println("Please enter the actual values in the matrix: ");
	  for(int i=0; i < a; i++) {
        for(int j=0; j < b; j++){
          array[i][j] = input.nextInt();
        }
      }
	  
	  int maxCount = maxCount(m, n, array);
	  System.out.println();
	  System.out.println("The number of maximum integers in the matrix after performing all the operations are: " + maxCount);	

	}
 }
