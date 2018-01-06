import java.util.*;
import java.io.*;

  public class TapeEquilibrium {
	  
    public static int getTapeEquilibrium(int[] array) {
      int length = array.length;
      if(length == 1) {
        return Math.abs(array[0]);
      } else if(length == 2) {
        return Math.abs((array[0] - array[1]));
      }
      double rightSum = 0;
      for (int i=0; i < length; i++) {
    	rightSum += array[i];
      }
      double leftSum = 0, difference = 0, minimum = Integer.MAX_VALUE;
      for(int i=0; i < length-1; i++) {
    	rightSum = rightSum - array[i];
        leftSum = leftSum + array[i];
        difference = Math.abs(leftSum - rightSum);
          
        minimum = Math.min(difference, minimum);
      }
		
      return (int)minimum;	  
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
	  
      int getMinimalDifference = getTapeEquilibrium(array);
      System.out.println();	
      System.out.print("The minimal difference from the absolute difference between the sum of the first part and the sum of the second part that can be achieved is: " + getMinimalDifference);
    }
  }
