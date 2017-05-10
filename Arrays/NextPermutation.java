import java.util.*;
import java.io.*;

 public class NextPermutation {
	
   public static void nextPermutation(int[] array) { 
      int i = array.length - 2;
      // Finding first decreasing element
      while (i >= 0 && array[i + 1] <= array[i]) {
         i--;
      }
      // Finding the number just larger than the first decreasing element
      if (i >= 0) {
        int j = array.length - 1;
        while (j >= 0 && array[j] <= array[i]) {
           j--;
        }
        swap(array, i, j);
      }
    reverse(array, i + 1);
   }	
	
   private static void reverse(int[] array, int start) { 
      int i = start, j = array.length - 1;
      while (i < j) {
         swap(array, i, j);
         i++;
         j--;
      }
   }	
	
   private static void swap(int[] array, int left, int right) {
       int temp = array[left]; 
       array[left] = array[right]; 
       array[right] = temp; 
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
	   
      nextPermutation(array);
	   
      System.out.print("\n");
      System.out.print("The next permutation which rearranges numbers into the lexicographically next greater permutation of numbers: ");
      for (int i = 0; i < array.length; i++) {
	 System.out.print(array[i] + " ");
      }	   
   }
 }
