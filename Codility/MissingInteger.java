import java.util.*;
import java.io.*;

  public class MissingInteger {
	  
	public static int findMissingInteger(int array[]) {	
	  Integer minPositive = null;
	  Integer maxPositive = null;
	  int positiveCount = 0;
	  for (int i = 0; i < array.length; i++) {
	    if (array[i] > 0) {
	      if (minPositive == null) {
	        minPositive = array[i];
	      }
	      else { 
	        minPositive = Math.min(array[i], minPositive);
	      }
	      if (maxPositive == null) {
	        maxPositive = array[i];
	      }
	      else {
	        maxPositive = Math.max(array[i], maxPositive);
	      }
          positiveCount++;
	    }
	  }

	  if (minPositive == null || minPositive != 1) {
	     return 1;
	  }

	  Integer[] result = new Integer[positiveCount + 1];
	  for (int i = 0; i < array.length; i++) {
	    if (array[i] <= 0 || array[i] > positiveCount) {
	       continue;
	    }
	    result[array[i] - 1] = 1;
	  }

	  for (int i = 0; i < positiveCount; i++) {
	    if (result[i] == null) {
	      return i + 1;
	    }
	  }

	  return positiveCount + 1;
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
	  
	  int missingInteger = findMissingInteger(array);
	  System.out.println();	
	  System.out.print("The smallest positive integer that does not occur in the array is: " + missingInteger);
	}
  }
