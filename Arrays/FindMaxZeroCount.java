import java.util.*;
import java.io.*;

 public class FindMaxZeroCount {
	
	public static int findMaxZeroCount(int[] array) {
	   int n = array.length;  
	   int originalZeroCount = 0;
	   int maxDifference = 0;
	   int currentMax = 0;
	   
	   for(int i=0; i<n; i++) {
		   
		 // Count of zeros in original array 
		 if (array[i] == 0) {
		   originalZeroCount++;  
		 }
		 
	     // Value to be considered for finding maximum sum
	     int value = (array[i] == 1) ? 1 : -1;
	     
	     // Update current max and max_diff
	     currentMax = Math.max(value, currentMax + value);
	     maxDifference = Math.max(maxDifference, currentMax);	   
	   }
	   maxDifference = Math.max(0, maxDifference);
		   
	   return originalZeroCount + maxDifference;
	}	 
 
	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int numbers = input.nextInt();   
	   int array[] = new int[numbers];
		    
	   System.out.print("\n");
	   System.out.print("Please enter the actual values in the array: ");
	   for (int i = 0; i < numbers; i++) {
		 array[i] = input.nextInt(); 
	   }
	 	   
	   int maxZeroes = findMaxZeroCount(array);
	   System.out.print("\n");
	   System.out.print("Maximum number zeros in an array with one flip of a subarray allowed is: " + maxZeroes);
	}
 }
