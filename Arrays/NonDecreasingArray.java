import java.util.*;
import java.io.*;

 public class NonDecreasingArray {
	 
	public static boolean checkPossibility(int[] array) {
	   int count = 0;                                                                   
	   for(int i = 0; i < array.length - 1; i++) {
	     if(array[i] > array[i+1]) {
	       count++;
	       if(i > 0 && array[i+1] < array[i-1]) {
	    	 array[i+1] = array[i];                    
	       }
	       else {
	    	 array[i] = array[i+1];                                               
	       }
	     }
	   }
	   return count<=1;  	
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
	
	  boolean result = checkPossibility(array); 
	  System.out.println();
	  if(result) {
		System.out.println("The given array can become non-decreasing by modifying at most 1 element.");  
	  }
	  else {
		System.out.println("The given array cannot become a non-decreasing by modifying at most 1 element.");  
	  }
	}
 }
