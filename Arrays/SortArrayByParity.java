import java.util.*;
import java.io.*;

  public class SortArrayByParity {
	
	public static int[] sortArrayByParity(int[] array) {
	  int result[] = new int[array.length];
	  int j = 0;
	  for (int i = 0; i < array.length; i++) {
		if(array[i] % 2 == 0) {
		  result[j++] = array[i]; 
		} 
	  }
	  for (int k = 0; k < array.length; k++) {
		if(array[k] % 2 == 1) {
		  result[j++] = array[k]; 
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
	  
	  input.close();
	  int result[] = sortArrayByParity(array); 
	  System.out.println();	
	  System.out.print("The sorted array consisting of all the even elements of the array followed by all the odd elements of the array is: ");
	  for (int i = 0; i < result.length; i++) {
		System.out.print(result[i] + " ");	
	  }
	}
  }
