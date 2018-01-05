import java.util.*;
import java.io.*;

  public class PermMissingElement {
	  
	public static int getMissingElement(int array[], int N) {
	  int i = 0;
	  int sum = 0;
		   	   
	  sum = (N + 1) * (N + 2)/2;
	  for (i = 0; i < N; i++) {
	    sum =  sum - array[i];
	  }
	  return sum;
	}
	
	public static int getMissingElement1(int array[], int N) { 
	  int i = 0;
      int x1 = array[0];
      int x2 = 1;
	   
      // For xor of all the elements in array */	   	   
      for (i = 1; i < array.length; i++) {
	    x1 = x1 ^ array[i];
      }
	   
      // For xor of all the elements from 1 to n+1 in array */
      for (i = 2; i <= array.length + 1; i++) {
        x2 = x2 ^ i;
      }
	   
      return (x1^x2);
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
	  
	  int getMissingElement = getMissingElement1(array, array.length);
	  System.out.println();	
	  System.out.print("The value of the missing element from the array is: " + getMissingElement);
	
	}
  }
