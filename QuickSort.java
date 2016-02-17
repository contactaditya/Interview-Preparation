import java.io.*;
import java.util.*;

public class QuickSort {
  
  private static int partition(int array[], int left, int right) {
	  
	// Pick a pivot point. Can be any element.
	  
	int pivot = array[(left + right) / 2];
	
    while (left <= right) {
	
    // Until we've gone through the whole array find element on left that should be on right	
    	
    while (array[left] < pivot) {
    	left++;
    }  
    
    // Until we've gone through the whole array find element on right that should be on left
    
    while (array[right] > pivot) {
    	right--;
    }  
    if (left <= right) {
     swap(array,left,right);
     left++;
     right--;
    }
  }
   return left;
 }
  
  private static void quickSort(int array[], int left, int right) {
    if(left < right) {
      int partitionindex = partition(array, left, right); /* Partitioning index */
      quickSort(array, left, partitionindex - 1 );
      quickSort(array, partitionindex, right);	  
	}
  }	
	
  private static void swap(int array[], int left, int right) {
    int temp = array[left]; 
    array[left] = array[right]; 
    array[right] = temp; 
  }	
  
	
  public static void main(String[] args) {
	  
    int array[] = {3, 7, 8, 9, 1, 4, 2, 6, 5, 10, 0};
	quickSort(array, 0, array.length - 1);
	System.out.println("The Sorted Array is: ");
	for (int i=0; i < array.length; i++) {
	  System.out.println(array[i]);
	}
  }
}