import java.util.*;
import java.io.*;

 public class PermutationSequence {
	 
    public static String getPermutation(int n, int k) {
       StringBuilder sb = new StringBuilder();  
       // Initialize all numbers
       List<Integer> number = new LinkedList<Integer>();
       for (int i = 1; i <= n; i++) {
    	 number.add(i);
       }
       int[] factorial = new int[n];
       factorial[0] = 1;
       // Set factorial of n
       for (int i = 1; i < n; i++) {
    	 factorial[i] = factorial[i-1] * i;
       }
       // Change k to be index
       k = k-1;
       // Find Sequence
       for (int i = n; i > 0; i--) {
    	// Find the right number  
    	 int index = k/factorial[i-1];
    	 // Update k
         k = k % factorial[i-1];
         // Get number according to Current Index
         sb.append(number.get(index));
         // Remove from list
         number.remove(index);
       }
       
       return sb.toString();     
	}	 

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter a number between 1 and 9 inclusive: ");
	  int number = input.nextInt();  
	  System.out.println();	
	  System.out.print("Enter the number of permutation sequence that you want the program to return: ");
	  int k = input.nextInt();  
      String result = getPermutation(number, k);
	  System.out.println();
	  System.out.println("The permutation sequence is: " + result);
	}
 }
