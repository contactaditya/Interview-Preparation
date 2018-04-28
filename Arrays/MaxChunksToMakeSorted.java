import java.util.*;
import java.io.*;

  public class MaxChunksToMakeSorted {
	  
	public static int maxChunksToSorted(int[] array) {
      int result = 0;
      
      for (int i = 0, max = 0; i < array.length; i++) {
        max = Math.max(max, array[i]);
        if(max == i) {
          result++;
        }
      }
		
	  return result;      
	}	  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
	
	  System.out.println();	
	  System.out.print("Please enter the elements in the array: ");
	  for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
	
	  System.out.println();	
	  int maxNumberOfChunks = maxChunksToSorted(array);
	  System.out.print("The most number of chunks that we could have made are: " + maxNumberOfChunks);  
	}
  }
