import java.util.*;
import java.io.*;

  public class FindTheIndexOfFirstOneInAnInfiniteSortedArray {
	  
    public static int indexOfFirstOne(int array[], int low, int high) {
      int mid = 0;  
      while (low <= high) { 
	mid = (low + high) / 2;    
		
	if(array[mid] == 1 && (mid == 0 || array[mid - 1] == 0)) {
	  break; 
	} else if(array[mid] == 1) {
	  high = mid - 1; 
	} else {
	  low = mid + 1;
	}
      }
	  
      return mid;
    }
	  
    public static int positionOfFirstOne(int array[]) {
      int low = 0, high = 1;  
      while (array[high] == 0) {      
        // lower bound 
        low = high; 
     
        // upper bound 
        high = 2 * high; 
      } 
		  
      return indexOfFirstOne(array, low, high);
    }

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
			  
      System.out.println();	
      System.out.print("Please enter the actual numbers in the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }  
	  
      int indexOfFirstOne = positionOfFirstOne(array);
      System.out.println();	
      System.out.print("The index of first 1 in an infinite sorted array of 0s and 1s is: " + indexOfFirstOne);
      input.close();
    }
  }
