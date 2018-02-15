import java.util.*;
import java.io.*;

  public class ArithmeticSlices {
	  
	public static int numberOfArithmeticSlices(int[] array) {
	  int dp = 0;
	  int sum = 0;
	   for (int i = 2; i < array.length; i++) {
         if (array[i] - array[i - 1] == array[i - 1] - array[i - 2]) {
           dp = 1 + dp;
           sum += dp;
         } else {
           dp = 0;	 
         }
	   }
	  
	  return sum;      
	}  

	public static void main(String[] args) {    
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];
		    
	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt(); 
	  }
 
	  int numberOfArithmeticSlices = numberOfArithmeticSlices(array);
	  System.out.println();
	  System.out.print("The solution set is: " + numberOfArithmeticSlices);
	}
  }
