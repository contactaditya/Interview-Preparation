import java.util.*;
import java.io.*;

  public class HowManyNumbersAreSmallerThanTheCurrentNumber {
	
	public static int[] smallerNumbersThanCurrent(int[] array) {
	  int count[] = new int[101];
	  int result[] = new int[array.length];

	  // We are doing the frequency count here
	  for(int i = 0; i < array.length; i++) {
	    count[array[i]]++;
	  }
	     
	  // Here we are counting the numbers in the array less than or equal to the number 
	  for (int i = 1 ; i <= 100; i++) {
	    count[i] += count[i-1];    
	  }
	      
	  for (int i = 0; i < array.length; i++) {
        if(array[i] == 0) {
		  result[i] = 0;	
		} else {
		  result[i] = count[array[i] - 1];
		}
	  }
	  return result;    
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
      int result[] = smallerNumbersThanCurrent(array);
      System.out.println();
      System.out.print("The number of numbers that are smaller than it are: ");
      for (int i = 0; i < result.length; i++) {
        System.out.print(result[i] + " ");
      }
      input.close();
	}
  }
