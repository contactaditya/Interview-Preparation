import java.util.*;
import java.io.*;

  public class Ladder {
	  
	public static int[] numberOfDifferentWaysToTopOfTheLadder(int[] A, int[] B) {
	  int L = A.length;
	  int fibonacci[] = new int[L + 1];
	  int result[] = new int[L];
	  fibonacci[0] = 1;
	  fibonacci[1] = 1;
	  // Make sure the fibonacci number will not exceed the max integer(prevent overflow) in java where, 2^30 == 1 << 30 
	  for (int i = 2; i < fibonacci.length; i++) {
		fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % (1 << 30);
	  }
	  
	  for(int i=0; i<L; i++){
        result[i] = fibonacci[A[i]] % (1 << B[i]); // where, "1 << B[i]" means 2^B[i]
      }

	  return result;	            	  
	}
	  
	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of rungs in the ladder: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
	  
	  System.out.println();	
	  System.out.print("Please enter the elements in the first array: ");
	  for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
	  }
	 
	  int array1[] = new int[number]; 
	  System.out.println();	
	  System.out.print("Please enter the elements in the second array: ");
	  for (int i = 0; i < array1.length; i++) {
		array1[i] = input.nextInt();
	  }
	  
	  int result[] = numberOfDifferentWaysToTopOfTheLadder(array, array1);
	  
      System.out.println();		
      System.out.print("the number of different ways of climbing to the top of the ladder are: ");   
      for(int i=0; i < result.length; i++) {     
        System.out.print(result[i] + " ");
      }	  
	}
  }
