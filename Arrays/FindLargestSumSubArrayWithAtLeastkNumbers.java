import java.util.*;
import java.io.*;

  public class FindLargestSumSubArrayWithAtLeastkNumbers {
	 
	public static int maxSumWithK(int[] array, int n, int k) {
	   int maxSum[] = new int [n];
	   maxSum[0] = array[0];
	   
	   // We use Kadane's algorithm to fill maxSum[]
	   
	   int currentMax = array[0];
	   for (int i = 1; i < n; i++) {
		 currentMax = Math.max(array[i], currentMax + array[i]);
         maxSum[i] = currentMax;
       }
	   
	   // Sum of the first k elements
	   int sum = 0;
       for (int i = 0; i < k; i++) {
         sum += array[i];
       }
       // Use the concept of sliding window
       int result = sum;
       for (int i = k; i < n; i++) {
    	 // Compute sum of k elements ending with array[i].  
         sum = sum + array[i] - array[i-k];
         // Update result if required
         result = Math.max(result, sum);
         // Include maximum sum till [i-k] also if it increases overall max.
         result = Math.max(result, sum + maxSum[i-k]);
       }
              
	   return result;
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
	  System.out.println();	
	  System.out.print("Enter the size of the subarray of k elements: ");
	  int k = input.nextInt(); 
	  		  
	  int result = maxSumWithK(array, array.length, k);
		    
	  System.out.println();	
	  System.out.print("The largest sum subarray with at least " + k + " numbers is: " + result);

	}
  }
