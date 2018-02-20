import java.util.*;
import java.io.*;

  public class TotalHammingDistance {
	    
	public static int totalHammingDistance(int[] array) {
	  int total = 0;
	  for(int j = 0; j < 32; j++) {
	    int bitCount = 0;
	    for (int i = 0; i < array.length; i++) {
	      bitCount += (array[i] >> j) & 1;
	    }
	    // If there are n integers in the array and k of them have a particular bit set and (n-k) do not, then that bit contributes k*(n-k) hamming distance to the total.
	    total += bitCount * (array.length - bitCount);
	  }
		
	  return total;      
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
		
	  int totalHammingDistance = totalHammingDistance(array);
	  System.out.println();	
	  System.out.print("The total Hamming distance between all pairs of the given numbers is: " + totalHammingDistance);
	}
  }
