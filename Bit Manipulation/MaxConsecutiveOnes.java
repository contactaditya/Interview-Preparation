import java.util.*;
import java.io.*;

  public class MaxConsecutiveOnes {
	  
    public static int findMaxConsecutiveOnes(int[] array) {
      int result = 0;
      int count = 0;
      for (int i = 0; i < array.length; i++) {
	if (array[i] == 1) {
	  count++;
	  result = Math.max(count, result);
	}
        else {
	  count = 0;
        }
      }	
      return result;     
    }	  

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the binary array: ");
      int numbers = input.nextInt();   
      int array[] = new int[numbers];
		    
      System.out.println();
      System.out.print("Please enter the actual values in the binary array: ");
      for (int i = 0; i < numbers; i++) {
	array[i] = input.nextInt(); 
      }
		   
      System.out.println();
      int maxConsecutiveOnes = findMaxConsecutiveOnes(array);	  
      System.out.println("The maximum number of consecutive 1s in the array are: " + maxConsecutiveOnes);
    }
  }
