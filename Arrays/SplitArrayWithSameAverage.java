import java.util.*;
import java.io.*;

  public class SplitArrayWithSameAverage {
	  
	public static boolean splitArraySameAverage(int[] array) {
	  int sum = 0;
	  for (int n : array) {
		sum += n;
	  }
	  Arrays.sort(array);
	  for(int i = 1; i < array.length; i++) {
	    if((i * sum) % array.length == 0) {
	      boolean result = check(array, i, (i * sum) / array.length, 0);
          if(result) {
            return true;
          }	
	    }  
	  }
		
	  return false;      
	}	  
	
	public static boolean check(int[] array, int num, int sum, int index) {
	  if(num == 0 && sum == 0) {
	    return true;
	  }
	  if(num < 0 || sum < 0) {
	    return false;
	  }
	  for(int i = index; i < array.length; i++) {
	    if(i > index && array[i] == array[i-1]) {
	      continue;
	    }
	    if(check(array, num - 1, sum - array[i], i + 1)) {
	      return true;
	    }
	  }
	        
	  return false;
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
	  
	  boolean isSplitArraySameAverage = splitArraySameAverage(array);
	  System.out.println();	
	  if(isSplitArraySameAverage) {
	    System.out.print("It is possible that the average value of B is equal to the average value of C, and B and C are both non-empty.");  
	  } else {
	    System.out.print("It is not possible that the average value of B is equal to the average value of C, and B and C are both non-empty.");    
	  }
	  input.close();
	}
  }
