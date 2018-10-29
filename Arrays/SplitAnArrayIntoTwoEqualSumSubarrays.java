import java.util.*;
import java.io.*;

  public class SplitAnArrayIntoTwoEqualSumSubarrays { 
	  
    private static int findSplitPoint(int[] array, int n) {
      int leftSum = 0; 
	      
      for (int i = 0; i < n; i++) { 
	leftSum += array[i]; 
      }
	  
      int rightSum = 0;
      for (int i = n-1; i >= 0; i--) { 
	// Add current element to the right sum 
	rightSum += array[i]; 
	  
	// Exclude current element to the left sum 
	leftSum -= array[i] ; 
	  
	if (rightSum == leftSum) {
	  return i; 
        }
      } 
	    
      return -1;
    }
	  
    private static void printTwoParts(int[] array, int n) { 
      int splitPoint = findSplitPoint(array, array.length); 	
      if (splitPoint == -1 || splitPoint == n) { 
        System.out.println("Not Possible"); 
        return; 
      }
      System.out.println();
      for (int i = 0; i < n; i++) {
        if(splitPoint == i) { 
          System.out.println();
          System.out.println();
        }        
        System.out.print(array[i] + " "); 
      } 
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
	  	  
      printTwoParts(array, array.length);
      input.close();
    }
  }
