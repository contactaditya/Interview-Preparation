import java.util.*;
import java.io.*;

  public class KthSmallestElementInASortedMatrix {
	  
	public static int kthSmallest(int[][] matrix, int k) {
	  int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
	  while(low < high) {
        int mid = low + (high - low) / 2;
        int count = 0,  j = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++) {
          while(j >= 0 && matrix[i][j] > mid) {
        	j--;
          }
          count += (j + 1);
        }
        if(count < k) {
          low = mid + 1;
        }
        else {
          high = mid;
        }
      }
	  return low;      
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
	  System.out.print("Please enter the kth smallest element in the matrix: ");
	  int k = input.nextInt();
	  
	  int kthSmallestElement = kthSmallest(matrix, k);
	  
	  System.out.println();	
	  System.out.println("The kth smallest element in the matrix is: " + kthSmallestElement);  
      
	}
  }
