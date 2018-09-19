import java.util.*;
import java.io.*;

  public class PrintAllGPTriplets { 	
	  
    public static void printAllGPTriplets(int array[]) {
	  Arrays.sort(array);
	  if(array.length < 3) {
		return;  
	  }
  	  System.out.println();
  	  System.out.println("All the triplets that form the GP are: ");	
	  for (int j = 1; j < array.length - 1; j++) {
	    int i = j - 1, k = j + 1; 
	    
	    while(true) {
	      while(i >= 0 && k <= array.length - 1 && (array[j] % array[i] == 0) && (array[k] % array[j] == 0) && (array[j]/array[i] == array[k]/array[j])) {
	    	System.out.println(array[i] + " " + array[j] + " " + array[k]);	
		    k++;
		    i--;  
	      }

	      if (i < 0 || k >= array.length) {
	    	break;
	      }
	      
	      if (array[j] % array[i] == 0 && array[k] % array[j] == 0) {
	    	if(array[j] / array[i] < array[k] / array[j]) {
	  	      i--;  
	  	    }
	  	    else {
	  	      k++;  
	  	    }
	      }
	      
	      else if(array[j] % array[i] == 0) {
	    	k++;  
	      }
	      else {
	    	i--;  
	      }
	    }
      }
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
	  
	  input.close();
	  printAllGPTriplets(array); 
	}
  }
