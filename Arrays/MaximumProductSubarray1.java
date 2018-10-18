import java.io.*;
import java.util.*;

  public class MaximumProductSubarray1 {
	  
    public static int maxSubArrayProduct(int[] array) {    
      int max[] = new int[array.length];
      int min[] = new int[array.length];
      
      max[0] = min[0] = array[0];
      int result = array[0];  
      
      for(int i = 1; i < array.length; i++) {
        if(array[i] > 0){ 
          max[i] = Math.max(array[i], max[i-1] * array[i]);
          min[i] = Math.min(array[i], min[i-1] * array[i]);
        }
        else {
          max[i] = Math.max(array[i], min[i-1] * array[i]);
          min[i] = Math.min(array[i], max[i-1] * array[i]);  
        } 
        result = Math.max(result, max[i]);  
      }
      return result; 
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
			
      int max = maxSubArrayProduct(array);
      System.out.println();			    
      System.out.println("The maximum value of the product of the contiguous subarray within the array is: " + max);
    }
  }
