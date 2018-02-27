import java.io.*;
import java.util.*;

public class MaximumSubArray {

  public static int maxSubArraySum(int[] array) {
    int max = array[0];
    int sum[] = new int[array.length];
    sum[0] = array[0];
    
    for(int i = 1; i < array.length; i++) {
       sum[i] = Math.max(array[i], sum[i-1] + array[i]);
       max = Math.max(max, sum[i]);
    }
    return max; 	
  }	
	
  public static void main(String[] args) throws NumberFormatException, IOException {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of elements in the first array: ");
    int number = input.nextInt();  
    int array[] = new int[number];
	
    System.out.println();	
    System.out.print("Please enter number: ");
    for (int i = 0; i < array.length; i++) {
      array[i] = input.nextInt();
    }
		
    int max = maxSubArraySum(array);
    System.out.print("\n");
	    
    System.out.println("The value of the sum of the maximum contiguous subarray within an array is: " + max);
  }     
}
