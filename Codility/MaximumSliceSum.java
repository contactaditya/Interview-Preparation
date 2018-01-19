import java.util.*;
import java.io.*;

  public class MaximumSliceSum {
	 
    private static int getMaxSliceSum(int[] array) { 
      int maxSliceSum = array[0];
      int sum[] = new int[array.length];
      sum[0] = array[0];
	  
      for(int i = 1; i < array.length; i++) {
	sum[i] = Math.max(array[i], sum[i-1] + array[i]);
	maxSliceSum = Math.max(maxSliceSum, sum[i]);
      }
      return maxSliceSum;
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
			
      int getMaxSliceSum = getMaxSliceSum(array);
      System.out.println();	
      System.out.println("The maximum sum of any slice of the array is: " + getMaxSliceSum);
    }
  }
