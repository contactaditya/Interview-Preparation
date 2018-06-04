import java.util.*;
import java.io.*;

  public class RotateFunction {
	  
	public static int maxRotateFunction(int[] array) {
	  int sum = 0;	
	  int F = 0;
	  for (int i = 0; i < array.length; i++) {
		F += i * array[i];
		sum += array[i];
	  }
	  int max = F;
	  for (int i = array.length - 1; i >= 1; i--) {
	    F = F + sum - array.length * array[i];
		max = Math.max(F, max);
	  }
		
	  return max;      
	}  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];
					    
	  System.out.print("\n");
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt(); 
	  }

	  int result = maxRotateFunction(array);
	  System.out.println();
	  System.out.print("The maximum value of the rotate function is: " + result);
	}
  } 
