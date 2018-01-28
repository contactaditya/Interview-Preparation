import java.util.*;
import java.io.*;

  public class ArrayNesting {
	  
    public static int arrayNesting(int[] array) {  
      boolean[] visited = new boolean[array.length];	
      int result = 0;	
      for (int i = 0; i < array.length; i++) {
	if(array[i] != Integer.MAX_VALUE) {
          int start = array[i], count = 0;
	  while (array[start] != Integer.MAX_VALUE) {
	    int temp = start;
            start = array[start];
            count++;
            array[temp] = Integer.MAX_VALUE;
          }
          result = Math.max(result, count);	
	}
      }
        
      return result;     
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
	  
      int longestLength = arrayNesting(array);
	  
      System.out.println();
      System.out.print("The longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } is: " + longestLength);
	 
    }
  }
