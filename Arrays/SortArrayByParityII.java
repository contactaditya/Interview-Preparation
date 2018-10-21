import java.util.*;
import java.io.*;

  public class SortArrayByParityII {  
	  
	public static int[] sortArrayByParityII(int[] array) {
	  int j = 1;	
	  for (int i = 0; i < array.length; i += 2) {
	    if(array[i] % 2 == 1) {
	      while(array[j] % 2 == 1) {
	    	j += 2;  
	      }
	    	
	      int temp = array[i];
	      array[i] = array[j];
	      array[j] = temp;
	    }  
	  }
	  
	  return array;
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
	  int result[] = sortArrayByParityII(array); 
	  System.out.println();	
	  System.out.print("The sorted array in which if A[i] is odd, i is odd; and whenever A[i] is even, i is even is: ");
	  for (int i = 0; i < result.length; i++) {
		System.out.print(result[i] + " ");	
	  }
	}
  }
