import java.util.*;
import java.io.*;

  public class SortAnArrayOfZeroesOnesandTwos {
	  
	public static void sort012(int array[]) { 
	  int low = 0;
      int high = array.length - 1;
      int mid = 0,temp = 0;
      while (mid <= high) {
    	switch (array[mid]) {
    	  case 0: temp = array[low];
          		  array[low] = array[mid];
          		  array[mid] = temp;
          		  low++;
          		  mid++;
		          break;
    	  case 1: mid++;
	          	  break;
    	  case 2: temp = array[mid];
          		  array[mid] = array[high];
          		  array[high] = temp;
          		  high--;
	          	  break;
    	}
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
		
	  sort012(array);
	  System.out.println();	
	  System.out.print("The array after sorting is: ");
	  for (int i = 0; i < numbers; i++) {
		System.out.print(array[i] + " ");	
	  }
	}
  }
