import java.util.*;
import java.io.*;

  public class ActiveAndInactiveCellsAfterGivenNumberOfDays { 
	 
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static List<Integer> cellCompete(int[] states, int days) {
	  List<Integer> result = new ArrayList<Integer>();    
	  // copy states[] array into temp [] array
	  int temp[] = new int[states.length];
	  for (int i = 0; i < states.length; i++) {
	    temp[i] = states[i];
	  }
	        
	  // Iterate for k days
	  while (days-- > 0) {
	    // Finding next values for corner cells
	    if(states[1] == 0) {
	      temp[0] = 0;    
	    } else {
	      temp[0] = 1;     
	    }
	          
	    if(states[states.length - 2] == 0) {
	      temp[states.length - 1] = 0;    
	    } else {
	      temp[states.length - 1] = 1;     
	    }

	    for (int j = 1; j <= states.length - 2; j++) {
	      if((states[j - 1] == 0 && states[j + 1] == 0) || (states[j - 1] == 1 && states[j + 1] == 1)) {    
	        temp[j] = 0;
	      }
	      else {
	        temp[j] = 1;  
	      }
	    }
	          
	    // Copy temp[] to cells[] for next iteration
	    for (int k = 0; k < states.length; k++) {
	      states[k] = temp[k];
	    }
	  }
	        
	  for (int i = 0; i < states.length; i++) {
	    result.add(states[i]);
	  }
	        
	  return result;
	}
	       
	// METHOD SIGNATURE ENDS
	  
	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of houses in the colony: ");
	  int numbers = input.nextInt();   
	  int states[] = new int[numbers];
					    
	  System.out.println();
	  System.out.print("Please enter the current states of the cells in the houses: ");
	  for (int i = 0; i < numbers; i++) {
		states[i] = input.nextInt(); 
	  }
	  
	  System.out.println();
	  System.out.print("Enter the number of days: ");
	  int days = input.nextInt();   
	  
	  List<Integer> result = new ArrayList<Integer>();    
	 
	  result = cellCompete(states, days);

	  System.out.println();	
	  System.out.print("The state of the cells after the given number of days is: " + result);
	}
  }
