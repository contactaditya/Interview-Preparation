import java.util.*;
import java.io.*;

  public class RemoveDuplicatesFromSortedArray2 { 
	
    public static int removeDuplicates(int array[]) {
      if (array == null || array.length == 0) {
	return 0;
      }
      int count = 1;
      int j = 1;
      int length = array.length; 
      for (int i = 1; i < array.length; i++) {
	if(array[i]==array[i-1]) {
	  count++;
	  if(count <= 2) {
	    array[++j] = array[i];  
	  }
	  else {
	    length--;  
	  }
	}
	else {
	  array[j++] = array[i];
          count = 1;
	}
      }  
      return length;  
    }	  

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];

      System.out.print("\n");
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
        array[i] = input.nextInt();
      }
		  
      Arrays.sort(array);
		  
      int length = removeDuplicates(array); 
      System.out.println();	
      System.out.print("The new length of the array where any duplicates are allowed only twice is: " + length);
    }
  }
