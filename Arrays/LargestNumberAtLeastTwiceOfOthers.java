import java.util.*;
import java.io.*;

  public class LargestNumberAtLeastTwiceOfOthers {
	  
	public static int dominantIndex(int[] array) {
	  int maxIndex = 0;
	  // Find the index of the largest number
	  for (int i = 0; i < array.length; i++) {
	    if (array[i] > array[maxIndex]) {
	       maxIndex = i;
	    }
	  }
	  for (int i = 0; i < array.length; ++i) {
	    if (maxIndex != i && array[maxIndex] < 2 * array[i]) {
	       return -1;
	    }
	  }
	  return maxIndex;
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
		   
	  
	  int largestElement = dominantIndex(array);
	  System.out.println();
	  System.out.println("The index of the largest element that is at least twice as much as every other number in the array is: " + largestElement);
	}
  }
