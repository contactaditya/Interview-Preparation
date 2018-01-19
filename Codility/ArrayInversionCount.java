import java.util.*;
import java.io.*;

  public class ArrayInversionCount {
	  
	private static int getArrayInversionCount(int[] array) { 
      int temp[] = new int[array.length];
	  return mergeSort(array, temp, 0, array.length - 1);	 
	}	
	    
	public static int mergeSort(int array[], int temp[], int left, int right) {
	  int mid = 0;
	  int inversionCount = 0;
	  if(right > left) {
	    mid = (right + left)/2;
	    /* Inversion count will be sum of inversions in left-part, right-part and number of inversions in merging */
	    inversionCount = mergeSort(array, temp, left, mid);
	    inversionCount += mergeSort(array, temp, mid + 1, right);
	    /*Merge the two parts*/
	    inversionCount += merge(array, temp, left, mid+1, right);
	  }
	       
	  if (inversionCount > 1000000000) {
	    return -1;
	  }
	    
	  return inversionCount;	 
	}	
	    
	public static int merge(int array[], int temp[], int left, int mid, int right) {
	  int i = left; /* i is index for left subarray*/
	  int j = mid;  /* j is index for right subarray*/
	  int k = left; /* k is index for resultant merged subarray*/
	  int inversionCount = 0;
	  while((i <= mid - 1) && (j <= right)) {
	    if(array[i] <= array[j]) {
	      temp[k++] = array[i++]; 
	    }
	    else {
	      temp[k++] = array[j++]; 
	      inversionCount = inversionCount + (mid - i);	
	    }
	  }
	        
	  /* Copy the remaining elements of left subarray (if there are any) to temp*/
	  while((i <= mid - 1)) {
	    temp[k++] = array[i++]; 		
	  }
	        
	  /* Copy the remaining elements of right subarray (if there are any) to temp*/
	  while(j <= right) {
	    temp[k++] = array[j++]; 		
	  }
	        
	  /* Copy back the merged elements to original array*/
	  for (i=left; i <= right; i++) {
	    array[i] = temp[i];	
	  }
	             
	  return inversionCount;	 
	}	    

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
		
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
	  }
			
      int getInversionCount = getArrayInversionCount(array);
      System.out.println();	
      System.out.println("Number of inversions are: " + getInversionCount);
	}
  }
