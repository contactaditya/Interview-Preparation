import java.util.*;
import java.io.*;

  public class MoveAllZeroesToTheEndOfTheArray { 
	
   public static void moveZeroes(int[] array) {
     int max = array.length;
     for (int i = 0, j = 0; j < max; j++) {
       if (array[j] != 0) {
	 if (i < j) {
	   swap(array, i, j);
	 }
	 i++;
       }
     }
   }	

   private static void swap(int[] array, int i, int j) {
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
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
		  
      moveZeroes(array);
      System.out.println();	
      System.out.print("Array after moving all the zeroes to the back: ");
      for (int i = 0; i < array.length; i++) {
	System.out.print(array[i] + " ");
      }
   }
  }
