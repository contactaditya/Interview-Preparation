import java.io.*;
import java.util.*;

 public class MaximumProductOfThreeNumbers {
	 
	public static int maximumProduct(int[] array) {
	   Arrays.sort(array); 
	   return Math.max(array[0] * array[1] * array[array.length - 1], array[array.length - 1] * array[array.length - 2] * array[array.length - 3]);
	}	 	 
	 
	public static int maximumProduct1(int[] array) {
	   int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
	   for (int i = 0; i < array.length; i++) {
		 if (array[i] > max1) {
           max3 = max2;
           max2 = max1;
           max1 = array[i];
         } else if (array[i] > max2) {
           max3 = max2;
           max2 = array[i];
         } else if (array[i] > max3) {
           max3 = array[i];
         }
         if (array[i] < min1) {
           min2 = min1;
           min1 = array[i];
         } else if (array[i] < min2) {
           min2 = array[i];
         }  
	   }
	  
	   return Math.max(max1*max2*max3, max1*min1*min2);
	}	 

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
				
	  System.out.println();	
	  System.out.print("Please enter the elements in the array: ");
	  for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
		
	  int result = maximumProduct(array);
	  System.out.println();	
	  System.out.print("The maximum product of three numbers in the array is: " + result);
	}
 }
