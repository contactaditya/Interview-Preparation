import java.io.*;
import java.util.*;

  public class SmallestRangeII {
	  
	public static int smallestRangeII(int[] array, int K) {  
	  Arrays.sort(array);
	  int n = array.length, max = array[n - 1], min = array[0], result = max - min;
	  for (int i = 0; i < array.length - 1; i++) {
		max = Math.max(max, array[i] + 2 * K);  
		min = Math.min(array[i + 1], array[0] + 2 * K);
		result = Math.min(result, max - min);
	  }
	  return result;
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
	  
	  int result = smallestRangeII(array, K); 
	  System.out.println();
	  System.out.println("The smallest possible difference between the maximum value of some array B and the minimum value of B some array is: " + result);
      input.close();	
	}
  }
