import java.util.*;
import java.io.*;

  public class GlobalAndLocalInversions {
	  
    public static boolean isIdealPermutation(int[] array) {
      for (int i = 0; i < array.length; i++) {
	if (array[i] < i - 1 || array[i] > i + 1) {  
	  return false;
	}
      }
		
		
      return true;      
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

      boolean result = isIdealPermutation(array);

      System.out.println();	
      if(result) {
	System.out.print("The number of global inversions is equal to the number of local inversions.");
      }
      else {
	System.out.print("The number of global inversions is not equal to the number of local inversions.");  
      }
    }
  }
