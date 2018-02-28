import java.util.*;
import java.io.*;

  public class ElementWithLeftSideSmallerAndRightSideGreater { 
	
	private static int findElement(int[] array) { 
	  // leftMax[i] stores maximum of arr[0..i-1]
	  int leftMax[] = new int[array.length];
	  leftMax[0] = Integer.MIN_VALUE;
	 
	  // Fill leftMax[]1..n-1]
	  for (int i = 1; i < array.length; i++) {
	    leftMax[i] = Math.max(leftMax[i-1], array[i-1]);
	  }
	  
	  // Initialize minimum from right
	  int rightMin = Integer.MAX_VALUE;
	  
	  // Traverse array from right
	  for (int i = array.length-1; i >= 0; i--) {
	    // Check if we found a required element
	    if (leftMax[i] < array[i] && rightMin > array[i]) {
	      return array[i];
	    }
	 
	    // Update right minimum
	    rightMin = Math.min(rightMin, array[i]);
	  }
	 
	  // If there was no element matching criteria
	  return -1;
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
	   
	  int element = findElement(array);
	  System.out.println();
	  System.out.print("The element before which all elements are smaller than it, and after which all are greater than it is: " + element);

	}
  }
