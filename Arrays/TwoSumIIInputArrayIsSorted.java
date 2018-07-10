import java.util.*;
import java.io.*;

  public class TwoSumIIInputArrayIsSorted {
	  
    public static int[] twoSum(int[] array, int target) {
      if (array == null || array.length < 2) {
	return new int[2];
      }	
      
      int left = 0;
      int right = array.length - 1;
	
      while (array[left] + array[right] != target) {
	if (array[left] + array[right] > target) {
	  right--;
	}
	else {
	  left++;
	}
      }
      return new int[]{left + 1, right + 1};
    } 
		  
    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
	
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
	
      System.out.println();	
      System.out.print("Enter the sum that you want to check whether it is present in the array or not: ");
      int sum = input.nextInt();  
	  
      System.out.println();
      int[] result = twoSum(array, sum);
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
