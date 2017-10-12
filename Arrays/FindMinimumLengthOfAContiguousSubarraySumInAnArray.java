import java.util.*;
import java.io.*;

 public class FindMinimumLengthOfAContiguousSubarraySumInAnArray {
	
    public static int minimumSubArrayLength(int s, int[] array) {
       if (array == null || array.length == 0) {
    	 return 0;
       }
       int start=0, end=0, sum=0, minimumLength=Integer.MAX_VALUE;
       while(end < array.length) {
          sum += array[end];
       
         //optimize the array
         while(sum >= s) {
           minimumLength = Math.min(minimumLength, end-start+1);
           sum -= array[start++];
         }
         end++;
       } 
  
       return minimumLength == Integer.MAX_VALUE ? 0 : minimumLength;        
    }	 

	public static void main(String[] args) { 	
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
			
	  System.out.println();	
	  System.out.print("Please enter the elements in the array: ");
	  for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
			
	  System.out.println();	
	  System.out.print("Enter the sum that you want to check whether it is present in the continuos subarray or not: ");
	  int s = input.nextInt();  
		
	  int minimumLength = minimumSubArrayLength(s, array);
	  System.out.println(); 
	  System.out.println("The minimal length of a contiguous subarray of which the sum is: " + minimumLength);
	}
 }
