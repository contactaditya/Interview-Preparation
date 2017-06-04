import java.io.*;
import java.util.*;

 public class PeakElement {   
	 
   public static int findPeakElementUtil(int[] array, int low, int high, int length) {
	  int mid = low + (high - low)/2; 
	  
	  if((mid == 0 || array[mid-1] <= array[mid]) && (mid == length-1 || array[mid+1] <= array[mid])) {
		return mid; 
	  }
	  
	  else if(mid > 0 && array[mid-1] > array[mid]) {
		return findPeakElementUtil(array, low, (mid -1), length);  
	  }
	  
	  else {
		return findPeakElementUtil(array, (mid +1), high, length);  
	  }
   }		 
	 
   public static int findPeakElement(int[] array, int length) {
	   return findPeakElementUtil(array, 0, length-1, length); 	
   }	

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the first array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
		
	  System.out.println();	
	  System.out.print("Please enter number: ");
	  for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
	  }
	  
	  int length = array.length;
			
      int peak = findPeakElement(array, length);
	  System.out.print("\n");
		    
	  System.out.println("The index of the peak element of the array is: " + peak);
	}
 }
