import java.util.*;
import java.io.*;

  public class MergeSortedArray {
	 
	public static void merge(int[] array1, int m, int[] array2, int n) {
	  int i = m-1, j = n-1, k = m+n-1;
	  while(i>=0 && j>=0) {
	    if(array1[i] > array2[j]) {
		  array1[k--] = array1[i--];
		}
		else {
		  array1[k--] = array2[j--];
		}
	  }
	  while(j>=0) {
		array1[k--] = array2[j--];
	  }      
	}  

	public static void main(String[] args) { 	
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the first array: ");
      int numbers = input.nextInt();   
      int array1[] = new int[numbers];
    
      System.out.println();
	  System.out.print("Please enter the actual values in the first array: ");
	  for (int i = 0; i < numbers; i++) {
	    array1[i] = input.nextInt();
	  }
	  
	  Arrays.sort(array1);
	  
	  System.out.println();
      System.out.print("Enter number of elements in the second array: ");
      int numbers1 = input.nextInt();   
      int array2[] = new int[numbers1];
    
      System.out.print("\n");
	  System.out.print("Please enter the actual values in the second array: ");
	  for (int i = 0; i < numbers; i++) {
	    array2[i] = input.nextInt();
	  }
	  
	  Arrays.sort(array2);
	  merge(array1, array1.length, array2, array2.length);
	
	}

  }
