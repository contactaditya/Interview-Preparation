import java.util.*;
import java.io.*;

  public class IncreasingTripletSubsequence {
	
	public static boolean increasingTriplet(int[] array) {	
	  int min = Integer.MAX_VALUE;
	  int secondMin = Integer.MAX_VALUE;

	  for (int n : array) {
	    if (n <= min) {
	      min = n;
	    } else if (n <= secondMin) {
	      secondMin = n;
		} else {
		  return true;
		}
	  }
	  return false;	
	}
	  
	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		  
      System.out.println();	
      System.out.print("Please enter the actual numbers in the array: ");
      for (int i = 0; i < array.length; i++) {
        array[i] = input.nextInt();
      }
     
      boolean isIncreasingTriplet = increasingTriplet(array);  
      System.out.println();	
      if(isIncreasingTriplet) {
 		System.out.print("Yes there is atleast one increasing subsequence of length 3 that exists in the unsorted array.");  
 	  } else {
 		System.out.print("No there is not even one increasing subsequence of length 3 that exists in the unsorted array.");    
 	  }
	}
  }
