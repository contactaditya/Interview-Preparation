import java.util.*;
import java.io.*;

  public class MinMaxDivision {
	  
	public static int getMinimalLargeSum(int K, int M, int array[]) {
	  int max = 0;
	  int sum = 0;
	   
	  for (int i = 0; i < array.length; i++) {
        sum += array[i];
        max = Math.max(max, array[i]);
      }
	  int low = max, high = sum;
	  while(low <= high) {
		int mid = low + (high-low)/2;
        int intervals = countIntervals(array, mid);
        if (intervals > K) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
	  
      return low;		
	}

	private static int countIntervals(int[] array, int target) {
	  int sum = 0, count = 0;
	  for (int i = 0; i < array.length; i++) {
	    sum += array[i];
	    if (sum > target) {
          count++;
          sum = array[i];
        }
	  }
	 
	  return count + (sum > 0 ? 1 : 0);
	}

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the maximum value of the array: ");
	  int M = input.nextInt();  
	  System.out.println();
	  System.out.print("Enter number of elements in the array: ");
	  int N = input.nextInt();   
	  int array[] = new int[N];
		    
	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < N; i++) {
		array[i] = input.nextInt(); 
	  }
	  
	  System.out.println();
	  System.out.print("Enter the number of blocks that you want to divide the array: ");
	  int K = input.nextInt();  
	  
	  int result = getMinimalLargeSum(K, M, array);
	  System.out.println();
	  System.out.print("The minimal large sum is: " + result);

	}
  }
