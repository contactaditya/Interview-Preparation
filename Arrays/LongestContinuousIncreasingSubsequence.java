import java.util.*;
import java.io.*;

  public class LongestContinuousIncreasingSubsequence {
	 
	public static int findLengthOfLCIS(int[] array) { 
	   if(array.length == 0 || array == null) {
	     return 0;  
	   }
	   
	   int max = 1;
       int count = 1;
       for(int i=1; i<array.length; i++) {
         if(array[i] > array[i-1]) {
           count = count + 1;
         }
         else {
           count = 1;
         }
         max = Math.max(count, max);
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
       for(int i = 0; i < numbers; i++) {
         array[i] = input.nextInt(); 
       }
 
       findLengthOfLCIS(array);
	}
  }
