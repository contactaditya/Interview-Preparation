import java.util.*;
import java.io.*;

 public class RemoveElement {
	
   public static int removeElement(int[] array, int value) {
      int m = 0;
	 	    
      for(int i = 0; i < array.length; i++) {
	if(array[i] != value) {
	  array[m++] = array[i];
	}
      }
      return m; 	
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
	  
      System.out.println();	
      System.out.print("Enter a value which remove all the instances of that place in the array: ");
      int value = input.nextInt();  
		
      int length = removeElement(array, value);
      System.out.print("\n");
      System.out.println("The new length of the array after removing all instances of " + value + " from the array is: " + length);
   }
 }
