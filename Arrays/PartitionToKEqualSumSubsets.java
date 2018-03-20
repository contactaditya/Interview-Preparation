import java.util.*;
import java.io.*;

 public class PartitionToKEqualSumSubsets {
	  
   public static boolean canPartitionKSubsets(int[] array, int k) {
      int sum = 0;
      // Calculate the sum of all the elements in the array
      for(int num : array) {
    	sum += num;
      }
      if(k <= 0 || sum % k != 0) {
    	return false;
      }
      int[] visited = new int[array.length];
      return canPartition(array, visited, 0, k, 0, 0, sum/k);
   }

   private static boolean canPartition(int[] array, int[] visited, int startIndex, int k, int currentSum, int currentNumber, int targetSum) {
      if(k == 1) {
	return true;
      }
      if(currentSum == targetSum && currentNumber > 0) {
	return canPartition(array, visited, 0, k-1, 0, 0, targetSum);
      }
      for(int i = startIndex; i < array.length; i++) {
	if(visited[i] == 0) {
          visited[i] = 1;
          if(canPartition(array, visited, i+1, k, currentSum + array[i], currentNumber++, targetSum)) {
            return true;
          } 
          visited[i] = 0;
        }    
      }	
      return false;
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
     System.out.print("Enter the positive integer: ");
     int k = input.nextInt();  
     boolean canPartitionKSubsets = canPartitionKSubsets(array, k);
     System.out.println();	
     if(canPartitionKSubsets) {
       System.out.println("It is possible to divide this array into " + k + " non-empty subsets whose sums are all equal.");  
     }
     else {
       System.out.println("It is not possible to divide this array into " + k + " non-empty subsets whose sums are all equal.");  
     }
   }
 }
