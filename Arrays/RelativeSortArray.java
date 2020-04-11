import java.util.*;
import java.io.*;

  public class RelativeSortArray {
	  
    public static int[] relativeSortArray(int[] array1, int[] array2) {
      int count[] = new int[1001];
      int k = 0;
      int result[] = new int[array1.length];
      // Count each number in array1
      for(int i : array1) {
    	count[i]++;
      }
      // Sort the common numbers in both arrays by the order of array2
      for(int i : array2) {
        while(count[i]-- > 0) {
          result[k++] = i;
        }
      }
      // Sort the numbers only in array1
      for(int i = 0; i < 1001; i++) {
        while(count[i]-- > 0) {
          result[k++] = i;
        }
      }
     
      return result;
    }	  

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the first array: ");
      int number = input.nextInt();  
      int array1[] = new int[number];
		  
      System.out.println();	
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < array1.length; i++) {
        array1[i] = input.nextInt();
      }
		    
      System.out.println();	
      System.out.print("Enter number of elements in the second array: ");
      int number1 = input.nextInt();  
      int array2[] = new int[number1];
		  
      System.out.println();	
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < array2.length; i++) {
	array2[i] = input.nextInt();
      }
		  
      int result[] = new int[array1.length];
		  
      result = relativeSortArray(array1, array2);
      System.out.println();	
      System.out.print("The relative ordering of the items in array1 according to the items in the array2 is: ");
      for(int i = 0; i < result.length; i++) {
	System.out.print(result[i] + " ");
      }
      input.close();
    }
  }
