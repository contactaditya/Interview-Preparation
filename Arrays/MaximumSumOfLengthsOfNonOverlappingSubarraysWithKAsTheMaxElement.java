import java.util.*;
import java.io.*;

  public class MaximumSumOfLengthsOfNonOverlappingSubarraysWithKAsTheMaxElement {
	  
	public static int calculateMaxSumLength(int array[], int n, int k) { 
	  int answer = 0;
	  int count = 0;
	  int flag = 0; // variable for checking if k appeared in subarray 
	  
	  for (int i = 0; i < n;) { 
        count = 0; 
        flag = 0; 

        // count the number of elements which are less than equal to k 
        while (i < n && array[i] <= k) { 
          count++; 
          if (array[i] == k) { 
            flag = 1; 
          }
          i++; 
        } 

        // if current element appeared in current subarray add count to sumLength 
        if (flag == 1) {
          answer += count;
        }

        // Skip the array elements which are greater than k 
        while (i < n && array[i] > k) { 
          i++; 
        }
      } 
	  
	  return answer;
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
	  System.out.print("Enter the maximum element: ");
	  int k = input.nextInt();  
			
      int result = calculateMaxSumLength(array, array.length, k);
      System.out.println();	
	  System.out.print("The maximum sum of lengths of non-overlapping subarrays (contiguous elements) with " + k + " as the maximum element is: " + result);
	  input.close();
	}
  }
