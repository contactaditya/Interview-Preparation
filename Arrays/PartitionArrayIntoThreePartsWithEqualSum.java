import java.util.*;
import java.io.*;

  public class PartitionArrayIntoThreePartsWithEqualSum {
	  
	public static boolean canThreePartsEqualSum(int[] array) { 
	  int sum = 0;
	  for (int number : array) {
		sum += number;
      }
	  int average = sum/3;
	  int count = 0;
	  int part = 0;
	  
	  for (int a : array) {
        part += a;
        if (part == average) { 
          count++; // find an average, increase the counter.
          part = 0; // reset part.
        }
      }
		
	  return count >= 3 && sum % 3 == 0;  
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
	  boolean canThreePartsEqualSum = canThreePartsEqualSum(array);
	  System.out.println();	
	  if(canThreePartsEqualSum) {
		System.out.println("Yes we can partition the array into three non-empty parts with equal sums.");  
	  }
	  else {
		System.out.println("No we cannot partition the array into three non-empty parts with equal sums.");  
	  }  
	  input.close();
	}
  }
