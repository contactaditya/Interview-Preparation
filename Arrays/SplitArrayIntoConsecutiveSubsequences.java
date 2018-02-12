import java.util.*;
import java.util.Queue;
import java.io.*;

  public class SplitArrayIntoConsecutiveSubsequences {
	  
	public static boolean isPossible(int[] array) {
	  if (array.length < 3) {
		return false;
	  }
	  int previousNumber = Integer.MIN_VALUE, previous1 = 0, previous2 = 0, previous3 = 0;
	  int currentNumber = array[0], current1 = 0, current2 = 0, current3 = 0;
	  for (int i = 0; i < array.length; i++) {
        int count = 1;
        while (i < array.length - 1 && array[i] == array[i + 1]) {
           i++;
           count++;
        }
        previousNumber = currentNumber;
        previous1 = current1;
        previous2 = current2;
        previous3 = current3;
        
        currentNumber = array[i];
        if (currentNumber == previousNumber + 1) {
          if (count < previous1 + previous2) {
            return false;
          }
          current1 = Math.max(count - previous1 - previous2 - previous3, 0);
          current2 = previous1;
          current3 = previous2 + Math.min(previous3, count - previous2 - previous1);
        } else {
          if (previous1 != 0 || previous2 != 0) {
        	return false;
          }
          current1 = count;
          current3 = 0;
        }
	  }
		
	  return current1 == 0 && current2 == 0;
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

	  boolean isPossible = isPossible(array);
	  System.out.println();	
	  if(isPossible) {
		System.out.println("Yes the array can be split into several subsequences, where each subsequences consist of at least 3 consecutive integers.");  
	  }
	  else {
		System.out.println("No the array cannot be split into several subsequences, where each subsequences consist of at least 3 consecutive integers.");  
	  }

	}
  }
