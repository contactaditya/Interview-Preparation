import java.util.*;
import java.io.*;

  public class PartitionArrayIntoDisjointIntervals {
	  
	public static int partitionDisjoint(int[] array) {
	  int localMax = array[0], partitionIndex = 0, max = localMax;
	  for (int i = 1; i < array.length; i++) {
	    if (localMax > array[i]) {  
	      localMax = max;
	      partitionIndex = i;	
	    } else {
	      max = Math.max(max, array[i]);	
	    }
	  }
	  
	  return partitionIndex + 1;      
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
	  
	  int lengthOfLeftSubarray = partitionDisjoint(array);
	  System.out.println();
	  System.out.println("The length of left subarray after such a partitioning is: " + lengthOfLeftSubarray);  
	  input.close();
	}
  }
