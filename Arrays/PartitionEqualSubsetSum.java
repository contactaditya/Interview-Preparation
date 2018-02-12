import java.util.*;
import java.io.*;

  public class PartitionEqualSubsetSum {
	  
    public static boolean canPartition(int[] array) {
      if (array == null || array.length == 0) {
        return true;
      }	
      int sum = 0;
      for (int number : array) {
	sum += number;
      }
      if (sum % 2 == 1) {
        return false;
      }
      Arrays.sort(array);
      if(array[array.length-1] > sum/2) {
	return false; 
      }
	  
      return helper(array, array.length-1, sum/2);
    }	  

    public static boolean helper(int[] array, int index, int target) {
      if(target == 0) {
	return true;
      }
      if(target < 0 || index < 0) {
	return false;
      }
		
      return helper(array, index-1, target-array[index]) || helper(array, index-1, target);
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

      boolean canPartition = canPartition(array);
      System.out.println();	
      if(canPartition) {
	System.out.println("Yes the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.");  
      }
      else {
	System.out.println("No the array cannot be partitioned into two subsets such that the sum of elements in both subsets is equal.");  
      }
    }
  }
