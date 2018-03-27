import java.util.*;
import java.io.*;

  public class MinimumSwapsToMakeSequencesIncreasing {
	  
	public static int minSwap(int[] A, int[] B) {
	  int swapRecord = 1, fixRecord = 0;	
	  for (int i = 1; i < A.length; i++) {
        if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
          swapRecord++;	
        } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
          int temp = swapRecord;
          swapRecord = fixRecord + 1;
          fixRecord = temp;
        } else {
          int min = Math.min(swapRecord, fixRecord);
          swapRecord = min + 1;
          fixRecord = min;	
        }
	  }
	  
	  return Math.min(swapRecord, fixRecord);
	}	  

	public static void main(String[] args) {     
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the first array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		  
      System.out.println();	
      System.out.print("Please enter number: ");
      for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
      }
		    
      System.out.println();	
      System.out.print("Enter number of elements in the second array: ");
      int number1 = input.nextInt();  
      int array1[] = new int[number1];
		 
      System.out.println();	
      System.out.print("Please enter number: ");
      for (int i = 0; i < array1.length; i++) {
	    array1[i] = input.nextInt();
      }
		    
      int minimumNumberOfSwaps = minSwap(array, array1);
      System.out.println();	
      System.out.print("The minimum number of swaps to make both sequences strictly increasing are: " + minimumNumberOfSwaps);
	}
  }
