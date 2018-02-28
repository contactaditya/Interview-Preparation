import java.util.*;
import java.io.*;

  public class MaximumAverageSubarrayI {
	
    public static double findMaxAverage(int[] array, int k) {
      double sum = 0;
      for(int i = 0; i < k; i++) {
        sum += array[i];
      }
      double maxSum = sum;
      for(int i = k; i < array.length; i++) {
        sum += array[i] - array[i-k];
        maxSum = Math.max(maxSum,sum);
      }
      
      return maxSum/k; 
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
	  
      System.out.println();	
      System.out.print("Enter the length of the contiguous subarray: ");
      int k = input.nextInt();  
			
      double maxAverage = findMaxAverage(array, k);
      System.out.println();	
      System.out.println("The maximum average value in the the contiguous subarray of given length " + k + " is: " + maxAverage);
    }
  }
