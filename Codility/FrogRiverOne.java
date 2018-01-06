import java.util.*;
import java.io.*;
 
  public class FrogRiverOne {
	  
	public static int getEarliestTime(int X, int array[]) {
	  int count[] = new int[X + 1];
	  for (int i = 0; i < array.length; i++) {
	    count[array[i]] = 1;

		if (array[i] == X) {
		  boolean found = true;
		  for (int j = 1; j <= X; j++) {
		    if (count[j] == 0) {
			  found = false;
		    }
		  }

		  if (found) {
		    return i;
		  }
	    }
	  }	
		
	  return -1;  
    }
	
	public static int getEarliestTime1(int X, int[] array) {
	  Set<Integer> values = new HashSet<Integer>();
	  for (int i = 0; i < array.length; i++) {
	    if (values.add(array[i])) {
		  X--; 
	    }
	    if (X == 0) {
		  return i;
	    }
	  }
	  return -1;
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
	  
	  System.out.println();
	  System.out.print("Enter the position of the opposite bank: ");
	  int X = input.nextInt();   

	  int getearliestTime = getEarliestTime(X, array);
	  System.out.println();
	  System.out.print("The earliest time when the frog can jump to the other side of the river is: " + getearliestTime);
	}
  }
