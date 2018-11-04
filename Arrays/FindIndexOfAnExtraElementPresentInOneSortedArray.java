import java.util.*;
import java.io.*;

  public class FindIndexOfAnExtraElementPresentInOneSortedArray {
	  
    private static int findExtra(int[] array1, int[] array2, int k) {
      int index = k;	
      int left = 0, right = k - 1; 
	  
      while (left <= right) {
	int mid = left + (right - left)/2;
        if (array2[mid] == array1[mid]) {
          left = mid + 1; 
	} else {
	  index = mid; 
          right = mid - 1; 
        }		  
      }
		
      return index;
    }

    public static void main(String[] args) { 	
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the first array: ");
      int number = input.nextInt();  
      int array1[] = new int[number];
			  
      System.out.println();	
      System.out.print("Please enter the actual numbers in the first array: ");
      for (int i = 0; i < array1.length; i++) {
	array1[i] = input.nextInt();
      }
			    
      Arrays.sort(array1);
      int array2[] = new int[number - 1];
			  
      System.out.println();	
      System.out.print("Please enter the actual numbers in the second array: ");
      for(int i = 0; i < array2.length; i++) {
	array2[i] = input.nextInt();
      } 
	  
      Arrays.sort(array2);
	  	   
      int result = findExtra(array1, array2, array2.length);
      System.out.println();
      System.out.print("The index of the extra element present in one sorted array is: " + result);
      input.close();
    }
  }
