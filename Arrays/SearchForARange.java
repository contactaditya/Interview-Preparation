import java.io.*;
import java.util.*;

 public class SearchForARange {

   public static int[] searchRange(int[] array, int target) {
      if(array == null || array.length == 0) {
	 return new int[]{-1, -1};
      }	
      int start = firstGreaterEqual(array, target);
      if (start == array.length || array[start] != target) {
	 return new int[]{-1, -1};
      }
      return new int[]{start, firstGreaterEqual(array, target+1) - 1};
   }

   private static int firstGreaterEqual(int[] array, int target) {
      int low = 0, high = array.length; 
      int mid;
      while (low < high) {
        mid = low + ((high - low)/2);  
	if (array[mid] < target) {
	  low = mid + 1;
	} else {
	  high = mid;
	} 
      }   
      return low;
   }

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
					
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
      System.out.println();
      System.out.print("Please enter the target value that needs to searched in the array: ");
      int target = input.nextInt();  
      System.out.println();
      int result[] = searchRange(array, target);
      if(result != null) {
	System.out.print("The index of the array which have the sum: ");  
	for (int i=0; i < result.length; i++) {
	  System.out.print(result[i] + " ");
	}	  
      }
      else {
	 System.out.print("There is no pair in the array with the required sum.");  
      }
   }
 }
