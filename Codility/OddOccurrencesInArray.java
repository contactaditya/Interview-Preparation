import java.util.*;
import java.io.*;

  public class OddOccurrencesInArray {
	  
	public static int getOddOccurrence(int array[]) {
	   int result = array[0];
	   for (int i = 1; i < array.length; i++) {
		 result = result ^ array[i];
	   }
	   return result;  
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

	  int getOddOccurrence = getOddOccurrence(array);
	  System.out.println();	
	  System.out.print("The one number that occurs odd number of times is: " + getOddOccurrence);
    }
  }
