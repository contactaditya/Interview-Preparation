import java.io.*;
import java.util.*;

public class SingleNonDuplicate {  
	
  public static int singleNonDuplicate(int[] array) {

     int low = 0;
     int high = array.length - 1;
	 		
     while (low <= high) {
       int mid = low + (high - low) / 2;
       if (array[mid] != array[mid + 1] && array[mid] != array[mid-1]) {
	  return array[mid];
       } else if (array[mid] == array[mid+1] && mid % 2 == 0) {
          low = mid+1;
       } else if (array[mid] == array[mid-1] && mid % 2 == 1) {
	  low = mid+1;
       } else {
	  high = mid-1;
       }
     }
    return array[low];
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
	  
      int singleElement = singleNonDuplicate(array);
      System.out.print("\n");
		    
      System.out.println("The single element that appears only once is: " + singleElement);
  }
}
