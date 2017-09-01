import java.util.*;
import java.io.*;

 public class FindLargestSumContiguousSubarray {
	 
	public static int maxSubArraySum(int[] array) {

	   int maxSoFar = Integer.MIN_VALUE;
	   int maxEndingHere = 0;
		    
	   for(int i = 0; i < array.length; i++) {
		 maxEndingHere = maxEndingHere + array[i];
		 if (maxEndingHere < 0) {
	       maxEndingHere = 0;
		 }
		 else if (maxSoFar < maxEndingHere) {
		   maxSoFar = maxEndingHere;
		 }
	   }
	   return maxSoFar; 	
	}	 

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
			
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < number; i++) {
		array[i] = input.nextInt();
	  }
	  int maximumSum = maxSubArraySum(array);
	  System.out.println();	
	  System.out.print("The sum of the contiguous subarray within an array which has the largest sum is: " + maximumSum);
	}
 }
