import java.io.*;
import java.util.*;

  public class SmallestRangeI {
	  
    public static int smallestRangeI(int array[], int K) {
      int min = array[0];
      int max = array[0];
	  
      for(int i = 0; i < array.length; i++) {
	min = Math.min(min, array[i]);
        max = Math.max(max, array[i]);  
      }
		
      return (min + K >= max - K) ? 0 : (max - K) - (min + K);      
    }	  
	  
    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int[] array = new int[number];
	
      System.out.println();	
      System.out.print("Please enter the elements of the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
      System.out.println();
      System.out.print("Enter a number K: ");
      int K = input.nextInt();   
	  
      int result = smallestRangeI(array, K); 
      System.out.println();
      System.out.println("The smallest possible difference between the maximum value of some array B and the minimum value of B some array is: " + result);
      input.close();	
    }
  }
