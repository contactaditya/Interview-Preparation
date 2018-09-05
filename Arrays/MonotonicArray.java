import java.util.*;
import java.io.*;

  public class MonotonicArray {
	  
     public static boolean isMonotonic(int[] array) { 
       return isIncreasing(array) || isDecreasing(array);
     }  
	 
     public static boolean isIncreasing(int[] array) { 
       for(int i = 0; i < array.length - 1; i++) {
	 if(array[i] > array[i+1]) {
	   return false;
	 }
       }
       return true;
     }
	 
     public static boolean isDecreasing(int[] array) { 
       for(int i = 0; i < array.length - 1; i++) {
	 if(array[i] < array[i+1]) {
	   return false;
	 }
       }
       return true;
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
       boolean result = isMonotonic(array); 
       System.out.println();
       if(result) {
	 System.out.println("Yes the given array A is monotonic.");  
       }
       else {
	 System.out.println("No the given array A is not monotonic.");  
       }
     }
   }
