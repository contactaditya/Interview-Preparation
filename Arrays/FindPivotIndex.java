import java.util.*;
import java.io.*;

 public class FindPivotIndex {
	 
    public static int pivotIndex(int[] array) {
      int sum = 0, leftsum = 0;
      for (int x: array) {
    	sum += x;
      }
      for (int i = 0; i < array.length; i++) {
        if (leftsum == sum - leftsum - array[i]) {
    	  return i;
        }
        leftsum += array[i];
      }
      return -1;   
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
					
       int pivotIndex = pivotIndex(array);
       System.out.println(); 
       System.out.println("The pivot index of the array is: " + pivotIndex);
    }
 }
