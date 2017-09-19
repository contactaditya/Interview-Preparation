import java.util.*;
import java.io.*;

 public class WiggleSort {
	 
	public static void wiggleSort(int[] array) {
	  if (array == null || array.length <= 1) {
		 return;
	  }
	  
	  int n = array.length;
		      
	  for (int i = 1; i < n; i++) {
		if ((i%2 == 1 && array[i-1] > array[i]) || (i%2 == 0 && array[i-1] < array[i])) {
		   int temp = array[i];
		   array[i] = array[i - 1];
		   array[i - 1] = temp;
		}
	  }
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

	  wiggleSort(array);
	  System.out.println();
	  System.out.print("The array after wiggle sort is: ");
	  for (int i=0; i < array.length; i++) {
		System.out.print(array[i] + " ");
	  }
	}
 }
