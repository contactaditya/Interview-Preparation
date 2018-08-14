import java.util.*;
import java.io.*;

  public class ShortestSubarrayWithSumAtLeastK {
	
	public static int shortestSubarray(int[] array, int K) {
	  int n = array.length;	
      int s[] = new int[n + 1]; 
      for (int i = 0; i < n; i++) {
        s[i + 1] = s[i] + array[i];
      }
      int[] d = new int[n + 1];
      int left = 0; 
      int right = 0;
      int result = n + 1;
      for (int i = 1; i <= n; i++) {
        while (left <= right && s[i] - s[d[left]] >= K) {
          result = Math.min(result, i - d[left]);
          left++;
        }
        while (left <= right && s[i] <= s[d[right]]) {
          right--;
        }
        d[++right] = i;
      }
 
      return result <= n ? result : -1;
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
	  System.out.print("Enter the sum of the subarray: ");
	  int k = input.nextInt();  
			
      int result = shortestSubarray(array, k);
      System.out.println();	
   	  System.out.print("The length of the shortest, non-empty, contiguous subarray of array with sum at least " + k + " is: " + result);
	}
  }
