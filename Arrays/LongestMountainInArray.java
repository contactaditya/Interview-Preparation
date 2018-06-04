import java.util.*;
import java.io.*;

  public class LongestMountainInArray {
	
	public static int longestMountain(int[] array) {
	  int lengthOfLongestMountain = 0;
	  int up = 0;
	  int down = 0;
	  for (int i = 1; i < array.length; i++) {
	    if (down > 0 && array[i - 1] < array[i] || array[i - 1] == array[i]) {
	      up = down = 0;
	    }
	    if (array[i - 1] < array[i]) {
		  up++;
	    }
	    if (array[i - 1] > array[i]) {
		  down++;
	    }
	    if (up > 0 && down > 0 && up + down + 1 > lengthOfLongestMountain) {
	      lengthOfLongestMountain = up + down + 1;
	    }
	  }
		
	  return lengthOfLongestMountain;      
	}

	public static void main(String[] args) { 	
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int array[] = new int[numbers];
					    
	  System.out.print("\n");
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		array[i] = input.nextInt(); 
	  }

	  int result = longestMountain(array);
	  System.out.println();
	  System.out.print("The length of the longest mountain in the array is: " + result);
	}
  }
