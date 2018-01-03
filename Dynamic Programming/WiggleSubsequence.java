import java.util.*;
import java.io.*;

  public class WiggleSubsequence {
	  
    public static int wiggleMaxLength(int[] array) {
      if (array.length < 2) {
	return array.length;
      }  
      int down = 1, up = 1;
      for (int i = 1; i < array.length; i++) {
        if (array[i] > array[i - 1]) {
	   up = down + 1;
	}
	else if (array[i] < array[i - 1]) {
	  down = up + 1;
	}
      }
      return Math.max(down, up);	      
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

       int longestWiggleSequence = wiggleMaxLength(array);
       System.out.println();
       System.out.print("The length of the longest subsequence that is a wiggle sequence is: " + longestWiggleSequence);
	 
    }
  }
