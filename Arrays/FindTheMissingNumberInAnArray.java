import java.util.*;
import java.io.*;

 public class FindTheMissingNumberInAnArray {
	
	public static int findMissingNumber(int[] array) {
	   int i = 0;
	   int sum = 0;
	   	   
	   sum = (array.length + 1) * (array.length + 2)/2;
	   for (i = 0; i < array.length; i++) {
		  sum =  sum - array[i];
	   }
	   return sum;
	}
	
	public static int findMissingNumber1(int[] array) {
	   int i = 0;
	   int x1 = array[0];
	   int x2 = 1;
	   
	   // For xor of all the elements in array */	   	   
	   for (i = 1; i < array.length; i++) {
	      x1 = x1 ^ array[i];
	   }
	   
	   // For xor of all the elements from 1 to n+1 in array */
	   for (i = 2; i <= array.length + 1; i++) {
		  x2 = x2 ^ i;
	   }
	   
	    
	   return (x1^x2);
	}	 

	public static void main(String[] args) {   
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int numbers = input.nextInt();   
	   int array[] = new int[numbers];
	    
	   System.out.print("\n");
	   System.out.print("Please enter consecutive elements in the array with exactly only one element missing: ");
	   for (int i = 0; i < numbers; i++) {
		 array[i] = input.nextInt(); 
	   }
	   int missingNumber = findMissingNumber(array);
	   int missingNumber1 = findMissingNumber1(array);
	   System.out.println();	
	   System.out.print("The missing number in the array is: " + missingNumber);
	   System.out.println();	
	   System.out.println();	
	   System.out.print("The missing number in the array is: " + missingNumber1);

	}
 }
