import java.util.*;
import java.io.*;

 public class CountOfRangeSumInAnArray {
	
	public static int countRangeSum(int[] array, int lower, int upper) {
	   int n = array.length;
	   long sum[] = new long[n+1];
	   for (int i = 0; i < n; i++) {
		 sum[i+1] = sum[i] + array[i];
	   }
	   return countWhileMergeSort(sum, 0, n + 1, lower, upper);		
	}	 

	private static int countWhileMergeSort(long[] sum, int start, int end, int lower, int upper) {
	    if (end - start <= 1) {
	      return 0;
	    }
	    int mid = start + (end - start)/2;
		int count = countWhileMergeSort(sum, start, mid, lower, upper) + countWhileMergeSort(sum, mid, end, lower, upper);
		int j = mid, k = mid, t = mid;
	    long[] cache = new long[end-start];
	    for (int i = start, r = 0; i < mid; i++, r++) {
	      while (k < end && sum[k] - sum[i] < lower) {
	        k++;
	      }
	      while (j < end && sum[j] - sum[i] <= upper) {
	        j++;
	      }
	      while (t < end && sum[t] < sum[i]) {
	        cache[r++] = sum[t++];
	      }
	      cache[r] = sum[i];
	      count += j - k;
	    }
	    System.arraycopy(cache, 0, sum, start, t - start);
		return count;
	}

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];
	    
	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt(); 
	  }
	  
	  System.out.println();	
	  System.out.print("Enter the lower part of the range: ");
	  int lower = input.nextInt();  
	  System.out.println();	
	  System.out.print("Enter the upper part of the range: ");
	  int upper = input.nextInt();  

	  int numberOfRanges = countRangeSum(array, lower, upper);
	  System.out.println();	
	  System.out.print("The number of range sums that lie in the [" + lower + ", " + upper +"]: " + numberOfRanges);
	}
 }
