import java.util.*;
import java.io.*;

  public class KDiffPairsInAnArray {
	
    public static int findPairs(int[] array, int k) {
      if (array == null || array.length == 0 || k < 0) {
	 return 0;	
      }
      Arrays.sort(array);
      int count = 0, i = 0, j = 1;
      while (i < array.length && j < array.length) {
        if(i > 0 && array[i-1] == array[i] || array[i] + k < array[j]) {
           i++;
        }
        else if (i == j || array[i] + k > array[j]) {
           j++;
        }
        else {
           count++;
           i++; 
           j++;
        }
      }
	  
      return count;     
    }	

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		
      System.out.println();	
      System.out.print("Please enter the elements of the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
      System.out.println();	
      System.out.print("Enter the integer: ");
      int k = input.nextInt();  
	  
      int missingNumber = findPairs(array, k);

      System.out.println();	
      System.out.print("The number of unique k-diff pairs in the array is: " + missingNumber);

    }
  }
