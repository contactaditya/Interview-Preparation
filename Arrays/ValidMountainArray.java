import java.util.*;
import java.io.*;

  public class ValidMountainArray {
	  
    public static boolean validMountainArray(int[] array) {
      if (array == null || array.length < 3) {
	return false;
      }	
      int i = 0;
      while (i < array.length - 1 && array[i + 1] > array[i]) {
        i++;
      }
      int j = array.length - 1;
      while (j > 0 && array[j - 1] > array[j]) {
        j--;
      }
	  
      return i > 0 && j < array.length - 1 && i == j;      
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
	
      System.out.println();	
      boolean isAValidMountainArray = validMountainArray(array);
      if(isAValidMountainArray) {
	System.out.println("This array is a valid mountain array.");  
      }
      else {
	System.out.println("This array is not a valid mountain array.");  
      }
      input.close();
    }
  }
