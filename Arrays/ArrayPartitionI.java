import java.util.*;
import java.io.*;

  public class ArrayPartitionI {
	 
     public static int arrayPairSum(int[] array) {
	 Arrays.sort(array);
	 int result = 0;
	 for (int i = 0; i < array.length; i += 2) {
            result += array[i];
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
	   
	int sum = arrayPairSum(array);
	System.out.println();
	System.out.print("The value of n is " + numbers/2 + ", and the maximum sum of pairs is: " + sum);

     }
  }
