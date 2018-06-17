import java.util.*;
import java.io.*;

  public class PeakIndexInAMountainArray {
	  
	public static int peakIndexInMountainArray(int[] array) {
      int low = 0, high = array.length;	
      while (low < high) {
        int mid = low + (high - low) / 2;  
        if (array[mid] < array[mid + 1]) {
          low = mid + 1;
        } else {
          high = mid;
        }
      }
		
	  return low;      
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

	  int peakIndex = peakIndexInMountainArray(array);
	  System.out.println();
	  System.out.print("The peak index in the mountain array is: " + peakIndex);

	}
  }
