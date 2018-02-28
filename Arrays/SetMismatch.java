import java.util.*;
import java.io.*;

  public class SetMismatch {
	  
	public static int[] findErrorNums(int[] array) {
	  Arrays.sort(array);	
	  int duplicate = -1, missing = 1;
	  for (int i = 1; i < array.length; i++) {
	    if (array[i] == array[i - 1]) {
	      duplicate = array[i];
	    }
	    else if (array[i] > array[i - 1] + 1) {
	      missing = array[i - 1] + 1;
	    }
	  }

	  return new int[] {duplicate, array[array.length - 1] != array.length ? array.length : missing};
    }	  
	
	public static int[] findErrorNums1(int[] array) {
	  int[] result = new int[2];
	  int[] array1 = new int[array.length + 1];
	  for (int i = 0; i < array.length; i++) {
	    if (array1[array[i]] == 1) {
	      result[0] = array[i];
	    } else {
	      array1[array[i]] = 1;
	    }
	  }
	  
	  for (int i = 1; i <= array.length; i++) {
        if (array1[i] == 0) {
          result[1] = i;
          break;
        }
      }
		  
	  return result;
	}	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
	  int array[] = new int[number];
			  
	  System.out.println();	
	  System.out.print("Please enter the actual numbers in the array: ");
	  for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
	  }
	   
	  int ErrorNums[] = findErrorNums(array);	
	  System.out.println();	
      System.out.print("The number that occurs twice and then the number that is missing are: ");  
	  for (int i=0; i < ErrorNums.length; i++) {
		System.out.print(ErrorNums[i] + " ");
	  }	  
	}
  }
