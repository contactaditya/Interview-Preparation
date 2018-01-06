import java.util.*;
import java.io.*;

  public class PermCheck {
	  
	public static int isAPermutation(int array[], int N) {
	   boolean seen[] = new boolean[array.length + 1];
	   for (int i = 0; i < array.length; i++) {
	     if(array[i] < 1 || array[i] > array.length) {
	       return 0;
	     }
		 if(seen[array[i]] == true) {
		   return 0;
		 }
		 else {
		   seen[array[i]] = true;
		 }
	   }
	   
	   return 1;  
	}

	public static void main(String[] args) { 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];
					    
	  System.out.println();	
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt(); 
	  }
	  
	  int isAPermutation = isAPermutation(array, array.length);
	  System.out.println();	
	  if(isAPermutation == 1) {
	    System.out.print("The array is a permutation.");
	  } else {
		System.out.print("The array is not a permutation.");  
	  }
	}
  }
