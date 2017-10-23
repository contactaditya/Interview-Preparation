import java.util.*;
import java.io.*;

 public class JumpGameInAnArray {
	
	public static boolean canJump(int[] array) {
	   int lastPosition = array.length - 1;
       for (int i = array.length - 1; i >= 0; i--) {
         if (i + array[i] >= lastPosition) {
           lastPosition = i;
         }
       }
       return lastPosition == 0;
	}

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the first array: ");
	  int number = input.nextInt();  
	  int array[] = new int[number];
		
	  System.out.println();	
	  System.out.print("Please enter the elements of the array: ");
	  for (int i = 0; i < array.length; i++) {
		array[i] = input.nextInt();
	  }
	  
      System.out.println();
	  if(canJump(array)) {
		System.out.println("Yes you can reach the last index in the array.");
	  }
	  else {
		System.out.println("No you cannot reach the last index in the array.");  
	  }
	}
 }
