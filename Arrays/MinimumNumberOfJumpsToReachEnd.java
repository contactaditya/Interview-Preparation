import java.util.*;
import java.io.*;

  public class MinimumNumberOfJumpsToReachEnd {
	  
    public static int minimumJumps(int array[]) {
      if(array.length <= 1) {
	return 0;
      }
	  
      if (array[0] == 0) {
        return -1; 
      }
	  
      int maxReach = array[0];
      int step = array[0];
      int jump = 1;
	  
      for(int i = 1; i < array.length; i++) {
	// Check if we have reached the end of the array
	if (i == array.length - 1) {
          return jump;   
	}	
		
	maxReach = Math.max(maxReach, i + array[i]); 
	step--; // We can use a step to get to the current index 
		
	// If no further steps left
	if(step == 0) {
	  jump++; 
	
	  // Check if the current index/position or lesser index is the maximum reach point from the previous indexes 
	  if(i >= maxReach) { 
            return -1; 
	  }
	  step = maxReach - i;  
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
	  
      int minimumJumps = minimumJumps(array);
	
      System.out.println();
      System.out.print("The minimum number of moves required to reach the end of the array are: " + minimumJumps);
      input.close();
    }
  }
