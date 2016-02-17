import java.io.*;
import java.util.*;

public class MergeSort {
	
  public static void mergesort(int[] array) {
	int[] helper = new int[array.length];
    mergesort(array, helper, 0, array.length - 1);
  }	
	
  public static void mergesort(int[] array, int[] helper, int low, int high) {
	if (low < high) {
	int middle = (low + high) / 2;
	// Sort left half
	mergesort(array, helper, low, middle); 
	// Sort right half
	mergesort(array, helper, middle+1, high); 
	// Merge them
	merge(array, helper, low, middle, high); 
	}
  }
	
  public static void merge(int[] array, int[] helper, int low, int middle, int high) {
	// Copy both halves into the helper array
	for (int i = low; i <= high; i++) {
	  helper[i] = array[i];
	}
	
	int helperLeft = low;
	int helperRight = middle + 1;
	int current = low;
    
	// Iterate through helper array.Compare the left and right half, copying back the smaller element from the two halves into the original array. 
	
    while (helperLeft <= middle && helperRight <= high) {
	if (helper[helperLeft] <= helper[helperRight]) {
	  array[current] = helper[helperLeft];
	  helperLeft++;
    } else {    
   // If right element is smaller than left element	
    array[current] = helper[helperRight];
	helperRight++;
	}
    current++;
	}
   // Copy the rest of the left side of the array into the target array 
   int remaining = middle - helperLeft;
	for (int i = 0; i <= remaining; i++) {
	 array[current + i] = helper[helperLeft + i];
	}
  }
		
  public static void main(String[] args) {	  
   int array[] = {3, 7, 8, 9, 1, 4, 2, 6, 5, 10, 0};
   mergesort(array);
   System.out.println("The Sorted Array is: ");
   for (int i=0; i < array.length; i++) {
	System.out.println(array[i]);
   }
  }
}