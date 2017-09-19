import java.util.*;
import java.io.*;

 public class ThirdMaximumNumberInAnArray {
	 
	public static int thirdMax(int[] array) {
	   if (array == null || array.length == 0) {
		  return 0;
	   }
	   
	   Integer max = null, secondMax = null, thirdMax = null;
	   for (Integer number : array) {
		 if (number.equals(max) || number.equals(secondMax) || number.equals(thirdMax)) {
		    continue;  
		 }
		 if (max == null || number > max) {
		    thirdMax = secondMax;
		    secondMax = max;
		    max = number;
         }
		 else if (secondMax == null || number > secondMax) {
			thirdMax = secondMax;
			secondMax = number;
	     }
		 else if (thirdMax == null || number > thirdMax) {
			thirdMax = number;
         } 
	   }
		
	   return thirdMax == null ? max : thirdMax;    
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

	  int result = thirdMax(array);
	  System.out.println();
	  System.out.print("The 3rd largest element in the array is: " + result);	
	}
 }
