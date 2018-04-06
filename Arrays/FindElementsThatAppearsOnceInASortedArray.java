import java.util.*;
import java.io.*;

 public class FindElementsThatAppearsOnceInASortedArray { 	
	 
    public static int findElementsThatAppearsOnce(int[] array, int low, int high) {
      if (low > high) {
    	return 0;
      } 
       
      if (low == high) {
        return array[low];
      } 
       
      // Find the middle point
      int mid = low + ((high - low) / 2);
       
      // If mid is even and element next to mid is same as mid, then output element lies on right side, else on left side
       
      if(mid % 2 == 0) { 
    	if(array[mid] == array[mid + 1]) {
    	  return findElementsThatAppearsOnce(array, mid+2, high); 
    	}
    	else {
    	  return findElementsThatAppearsOnce(array, low, mid);   
    	}
      }
       
      // If mid is odd
       
      else if(mid % 2 == 1) {
        if(array[mid] == array[mid-1]) {
          return findElementsThatAppearsOnce(array, mid-2, high);
        }
        else {
          return findElementsThatAppearsOnce(array, low, mid-1);
        }
      }
      return array[low];
    }
    
    public static int findElementsThatAppearsOnce1(int[] array, int low, int high) {
      while (low < high) {
        // We want the first element of the middle pair, which should be at an even index if the left part is sorted.      	  
        int mid = low + ((high - low) / 2);
               
        if (mid % 2 == 1) {
          mid--;  
        } 
        
        // We didn't find a pair. The single element must be on the left.
        if (array[mid] != array[mid + 1]) {
          high = mid;
        }
         
        // We found a pair. The single element must be on the right.        
        else {
          low = mid + 2; 
        }
      }
      // When 'low > high', low must be the single element.
      return array[low];
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
	   
      Arrays.sort(array);
	   
      int onceElement = findElementsThatAppearsOnce1(array, 0, array.length - 1);
	   
      if (!(onceElement == 0)) {
        System.out.println(); 
	System.out.println("The element that appears once in the array is " + onceElement);
      } else {
	System.out.println();	
	System.out.println("There is no element that only appers once in the array.");
      }
    }
 }
