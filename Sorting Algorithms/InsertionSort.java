import java.io.*;
import java.util.*;

  public class InsertionSort {
	  
	private static void insertionSort(int[] array) {
	  for (int i = 1; i < array.length; i++) {
		int key = array[i];
		int j = i - 1;
		/* Move elements of array[0..i-1], that are greater than key, to one position ahead of their current position */
		while (j >= 0 && array[j] > key) {
          array[j + 1] = array[j];
          j = j - 1;
        }
		array[j + 1] = key;
	  }
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

	  insertionSort(array);
	  System.out.println();
	  System.out.print("The array after insertion sort is: ");
	  for (int i=0; i < array.length; i++) {
		System.out.print(array[i] + " ");
	  }
	}
  }
