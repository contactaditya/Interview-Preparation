import java.util.*;
import java.io.*;

  public class FindMinimumInRotatedSortedArray {
	
    public static int findMinimum(int[] array) {
      if (array == null || array.length == 0) {
        return 0;
      }
      int low = 0, high = array.length - 1;
      while (low < high) {
	int mid = low + (high - low) / 2;
	if (array[mid] > array[high]) {
	  low = mid + 1;
	}
	else {
	  high = mid;
	}
      }
      return array[low];
    }
	
    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int lengthOfArray = input.nextInt();  
      int array[] = new int[lengthOfArray];
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for(int i=0; i<lengthOfArray; i++) {  
        array[i] = input.nextInt();
      }
      Arrays.sort(array);
      System.out.println();	
      System.out.print("Enter the number of rotations in the array: ");
      int k = input.nextInt();
      if(k > array.length) {
 	k = k % array.length;
      }
      int[] result = new int[array.length];   
 		    
      for(int i=0; i<array.length; i++) {
 	result[(i + array.length - k) % array.length] = array[i];  
      }
      System.out.println();	
      System.out.print("The contents of the array after rotation are: ");
	    
      for(int i=0; i<array.length; i++) {
        System.out.print(result[i] + " "); 
      } 
      System.out.println();	
      int findMinimum = findMinimum(result);
      System.out.println();	
      System.out.print("The minimum element in the array sorted in ascending order and rotated at some unknown pivot is: " + findMinimum);  
    }
  }
