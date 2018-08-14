import java.util.*;
import java.io.*;

  public class MaximumSumOf3NonOverlappingSubarrays {  
	
	public static int[] maxSumOfThreeSubarrays(int[] array, int K) {
	  int sum1 = 0, sum2 = 0, sum3 = 0;
	  for (int i = 0; i < K; i++) {
	    sum1 += array[i];
	  }
	  for (int i = K; i < K*2; i++) {
	    sum2 += array[i];
	  } 
	  for (int i = K*2; i < K*3; i++) {
	    sum3 += array[i];
	  }
	  int seq1 = sum1, seq2 = sum1 + sum2, seq3 = sum1 + sum2 + sum3;
      int index1 = 0;
      int[] index2 = new int[]{0, K}, index3 = new int[]{0, K, K*2};
      
      for (int i = 1; i <= array.length - K*3; i++) {
        sum1 += array[i + K - 1] - array[i - 1];
        sum2 += array[i + K*2 - 1] - array[i + K - 1];
        sum3 += array[i + K*3 - 1] - array[i + K * 2 - 1];
        if (sum1 > seq1) {
          seq1 = sum1;
          index1 = i;
        }
        if (sum2 + seq1 > seq2) {
          seq2 = sum2 + seq1;
          index2[0] = index1;
          index2[1] = i + K;
        }
        if (sum3 + seq2 > seq3) {
          seq3 = sum3 + seq2;
          index3[0] = index2[0];
          index3[1] = index2[1];
          index3[2] = i + K*2;
        }
      }
      
      return index3;
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
	  System.out.print("Enter the size of each subarray: ");
	  int k = input.nextInt();  
			
      int result[] = maxSumOfThreeSubarrays(array, k);
      System.out.println();	
	  System.out.print("The list of indices containing the starting position of each interval (0-indexed) representing three non-overlapping subarrays with maximum sum is: ");
	  for (int i=0; i < result.length; i++) {
		System.out.print(result[i] + " ");
	  }
	}
  }
