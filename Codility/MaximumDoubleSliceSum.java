import java.util.*;
import java.io.*;

  public class MaximumDoubleSliceSum {
	  
    private static int getMaxDoubleSliceSum(int[] array) { 
      int maxEnding = 0;
      int maxSlice = 0;
      int maxSliceLeft[] = new int[array.length];
      int maxSliceRight[] = new int[array.length];
      int maxDoubleSlice = 0;
	  
      // This stores the sum value of max slice of A[1] A[2] ... A[i] in maxSliceLeft[i]
			  
      for(int i = 1; i < array.length-1; i++) {
	 maxEnding = Math.max(0, maxEnding + array[i]);
	 maxSliceLeft[i] = maxEnding;
      }
	  
      // This stores the sum value of max slice of A[N-2] A[N-1] ... A[i] in maxSliceRight[i]
	  
      maxEnding = 0;
      for(int i = array.length-2; i >= 1; i--) {
         maxEnding = Math.max(0, maxEnding + array[i]);
         maxSliceRight[i] = maxEnding;
      }
	  
      // Calculate the max double slice from Y == 1 to Y == N-2
	  
      for (int i = 1; i < array.length-1; i++) {
        maxDoubleSlice = Math.max(maxDoubleSlice, maxSliceLeft[i-1] + maxSliceRight[i+1]);
      }
	  
      return maxDoubleSlice;
    }		  	  

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		
      System.out.println();	
      System.out.print("Please enter the elements of the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
			
      int getMaxDoubleSliceSum = getMaxDoubleSliceSum(array);
      System.out.println();	
      System.out.println("The maximum sum of any double slice of the array is: " + getMaxDoubleSliceSum);

    }
  }
