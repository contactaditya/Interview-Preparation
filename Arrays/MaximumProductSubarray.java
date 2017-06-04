import java.io.*;
import java.util.*;

 public class MaximumProductSubarray {
	 
  public static int maxSubArrayProduct(int[] array) {

      int max_ending_here = 1; // max positive product ending at the current position
      int min_ending_here = 1; // min negative product ending at the current position
      int max_so_far = 1; // Initialize overall max product
		    
      for(int i = 0; i < array.length; i++) {
	 if(array[i] > 0) {
	    max_ending_here = max_ending_here * array[i];
            min_ending_here = Math.min(min_ending_here * array[i], 1);		
	 }		
	 else if(array[i] == 0) {
	    max_ending_here = 1;
	    min_ending_here = 1;		
	 }
	 else {
            int temp = max_ending_here;
            max_ending_here = Math.max(min_ending_here * array[i], 1);
            min_ending_here = temp * array[i];
	 }
		
	 if (max_so_far <  max_ending_here) {
	    max_so_far  =  max_ending_here;
	 }
       }
    return max_so_far; 	
  }	 

  public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the first array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		
      System.out.println();	
      System.out.print("Please enter number: ");
      for (int i = 0; i < array.length; i++) {
	 array[i] = input.nextInt();
      }
			
      int max = maxSubArrayProduct(array);
      System.out.print("\n");
		    
      System.out.println("The value of the product of the maximum product subarray within an array is: " + max);
   }
 }
