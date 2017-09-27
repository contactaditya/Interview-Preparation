import java.util.*;
import java.io.*;

 public class FindElementsThatAppearsOnlyOnceInTheArrayWhereEveryElementAppearsThrice {
	
	public static int singleNumber(int[] array) {
	  int ones = 0; 
	  int twos = 0; 
	  int threes = 0; 
	  for (int i = 0; i < array.length; i++) {
	    twos |= ones & array[i];
	    ones ^= array[i];
	    threes = ones & twos;
	    ones &= ~threes;
	    twos &= ~threes;
	  }	
	  return ones;	      
	} 
	
	public static int singleNumber1(int[] array) {
	  int result = 0;
      int x, sum;
	  for (int i = 0; i < 32; i++) {
		// Find sum of set bits at ith position in all array elements  
		sum = 0;
		x = (1 << i);
		for(int j=0; j < array.length; j++) {
          if((array[j] & x) == 0) {
        	sum++; 
          }
        }

        // The bits with sum not multiple of 3, are the bits of element with single occurrence.
		if ((sum % 3) == 0) {
          result |= x;
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
	   
	  Arrays.sort(array);
	   
	  int onceElement = singleNumber(array);
	  System.out.println(); 
	  if (!(onceElement == 0)) {
	 	System.out.println("The element that appears once in the array is " + onceElement);
	  } else {
		System.out.println("There is no element that only appers once in the array.");
	  }	
	}
 }
