import java.util.*;
import java.io.*;

  public class FairCandySwap {
	  
	public static int[] fairCandySwap(int[] A, int[] B) { 
	  int sumA = 0, sumB = 0;  // sum of A, B respectively
      for (int x : A) {
    	sumA += x;
      }
      for (int x : B) {
    	sumB += x;
      }
      int delta = (sumB - sumA) / 2;
      
      // If Alice gives x, she expects to receive x + delta
      Set<Integer> setB = new HashSet<Integer>();
      for (int x : B) {
    	setB.add(x);
      }
      for (int x : A) {
        if (setB.contains(x + delta)) {
          return new int[]{x, x + delta};
        }
      }
	  
      throw null;      
	}

	public static void main(String[] args) {      
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of candy bars that Alice has: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		  
      System.out.println();	
      System.out.print("Please enter the actual values of candy bars: ");
      for (int i = 0; i < array.length; i++) {
	    array[i] = input.nextInt();
      }
		    
      System.out.println();	
      System.out.print("Enter number of candy bars that Bob has: ");
      int number1 = input.nextInt();  
      int array1[] = new int[number1];
		  
      System.out.println();	
      System.out.print("Please enter the actual values of candy bars: ");
      for (int i = 0; i < array1.length; i++) {
	    array1[i] = input.nextInt();
      }
		  
      int result[] = new int[array.length + array1.length];
		  
      result = fairCandySwap(array, array1);
      System.out.println();	
      System.out.print("An integer array where array[0] is the size of the candy bar that Alice must exchange, and array[1] is the size of the candy bar that Bob must exchange is: ");
      for(int i = 0; i < result.length; i++) {
	    System.out.print(result[i] + " ");
      }
	}
  }
