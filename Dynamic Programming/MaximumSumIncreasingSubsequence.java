import java.util.*;
import java.io.*;

 public class MaximumSumIncreasingSubsequence { 	
	 
   public static int maxSumIncreasingSubsequence(int[] array) {
     int max = 0;	
     int msis[] = new int[array.length];
	   
     /* Initialize msis values for all indexes */
     for (int i = 0; i < array.length; i++) {
       msis[i] = array[i];
     }
       
     /* Compute maximum sum values in bottom up manner */
     for (int i = 1; i < array.length; i++) {
       for (int j = 0; j < i; j++) {
    	 if (array[i] > array[j] && msis[i] < msis[j] + array[i]) {
    	   msis[i] = msis[j] + array[i];	 
    	 }   
       }
     }
       
     /* Pick maximum of all msis values */
     for (int i = 0; i < array.length; i++) {
       if (max < msis[i]) {
         max = msis[i]; 
       }
     }
           
     return max;
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
	   
     int maxSumIS = maxSumIncreasingSubsequence(array);
	   
     System.out.println();
     System.out.println("Sum of maximum sum increasing" + " subsequence is " + maxSumIS);
   }
 }
