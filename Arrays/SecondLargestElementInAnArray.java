import java.util.*;
import java.io.*;

 public class SecondLargestElementInAnArray { 	
	 
    public static void printSecondLargest(int[] array) {
       int n = array.length;  
       int first = 0;
       int second = 0;
	   
       if (n < 2) {
	 System.out.print("Invalid size of the array.");   
       }
	   
       first = second = Integer.MIN_VALUE;
	    
       for (int i = 0; i < n; i++) {
	 if(array[i] > first) {
	   second = first;
	   first = array[i]; 
	 }
		
	 else if (array[i] > second && array[i] != first) {
	   second = array[i];	
	 }
       }
	  
       if (second == Integer.MIN_VALUE) {
	 System.out.print("There is no second largest element in the array");     
       }
       else {
	 System.out.print("The second largest element in the array is: " + second);       
       }
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
	  
      System.out.println();
      printSecondLargest(array);
    }
 }
