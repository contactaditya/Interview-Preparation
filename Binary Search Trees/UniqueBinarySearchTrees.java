import java.util.*;
import java.io.*;

 public class UniqueBinarySearchTrees {
	 
   public static int numTrees(int n) {
	  int count[] = new int[n + 1];
	  count[0] = 1;
	  count[1] = 1;
	   
	  for (int i = 2; i <= n; i++) {
	   for (int j = 1; j <= i; j++) {
		 count[i] = count[i] + count[j-1] * count[i-j];
	   }
	  }
	  
	  return count[n];
	} 

	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter the number: ");
	   int n = input.nextInt();
	   int result = numTrees(n);
	   System.out.println();  
	   System.out.print("The total number of unique BST are: " + result);
	}
  }
