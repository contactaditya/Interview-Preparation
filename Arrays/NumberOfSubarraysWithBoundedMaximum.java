import java.util.*;
import java.io.*;

  public class NumberOfSubarraysWithBoundedMaximum {
	
    public static int numSubarrayBoundedMax(int[] array, int L, int R) {
      int j = 0, count = 0, result = 0;
      for(int i = 0; i < array.length; i++) {
        if(array[i] >= L && array[i] <= R) {
          result += i - j + 1;
          count = i - j + 1;
        }
        else if(array[i] < L) {
          result += count;
        }
        else {
          j = i + 1;
          count = 0;
        }
      }
		
      return result;     
    }	 

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
	
      System.out.println();	
      System.out.print("Please enter the elements in the array: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
	
      System.out.println();	
      System.out.print("Enter the element where the maximum element in the subarray will at least be: ");
      int L = input.nextInt();  
	  
      System.out.println();	
      System.out.print("Enter the element where the maximum element in the subarray will at most be: ");
      int R = input.nextInt();  
	 
      int result = numSubarrayBoundedMax(array, L, R);
      System.out.println();
      System.out.print("The number of subarrays such that the value of the maximum array element in that subarray is at least " + L + " and at most " + R + " is: " + result);  
    }
  }
