import java.util.*;
import java.io.*;

  public class MaximumGap {
	  
    public static int maximumGap(int[] array) {
      if (array == null || array.length < 2) {
	return 0;  
      }
      // Get the max and min value of the array
      int min = array[0];
      int max = array[0];
      for (int i : array) {
	min = Math.min(min, i);
	max = Math.max(max, i);
      }	
      // The minimum possible gap, ceiling of the integer division
      int gap = (int) Math.ceil((double)(max - min)/(array.length - 1));
      int[] bucketsMIN = new int[array.length - 1]; // store the min value in that bucket
      int[] bucketsMAX = new int[array.length - 1]; // store the max value in that bucket
      Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
      Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
      // Put numbers into buckets
      for (int i : array) {
        if (i == min || i == max) {
          continue;
        }
        int index = (i - min) / gap; // index of the right position in the buckets
        bucketsMIN[index] = Math.min(i, bucketsMIN[index]);
        bucketsMAX[index] = Math.max(i, bucketsMAX[index]);
      }
      // Scan the buckets for the max gap
      int maxGap = Integer.MIN_VALUE;
      int previous = min;
      for (int i = 0; i < array.length - 1; i++) {
        if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) {
          continue; // empty bucket
        }
        // Min value minus the previous value is the current gap
        maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
        // Update previous bucket value
        previous = bucketsMAX[i];
      }
      
      maxGap = Math.max(maxGap, max - previous); // update the final max value gap
      return maxGap;      
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
			
      int getMaximumGap = maximumGap(array);
      System.out.println();	
      System.out.println("The maximum difference between the successive elements in its sorted form is: " + getMaximumGap);
      input.close();
    }
  }
