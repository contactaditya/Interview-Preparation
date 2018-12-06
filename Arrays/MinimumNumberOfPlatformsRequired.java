import java.util.*;
import java.io.*;

  public class MinimumNumberOfPlatformsRequired {
	  
    private static int minimumNumberOfPlatforms(int[] arrival, int[] departure) {
      Arrays.sort(arrival); 
      Arrays.sort(departure); 
      int numberOfPlatformsNeeded = 1, result = 1; 
      int i = 1, j = 0; 
      int n = arrival.length;
      while (i < n && j < n) {
        // If next event in sorted order is arrival, increment count of platforms needed   
        if (arrival[i] <= departure[j]) {    
	  numberOfPlatformsNeeded++; 
	  i++;  
	  if (numberOfPlatformsNeeded > result) { 
            result = numberOfPlatformsNeeded; 
	  } 
        } else { 
	  numberOfPlatformsNeeded--; 
	  j++; 
	} 
      }   
	  
      return result;
    }	  

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of trains: ");
      int number = input.nextInt();  
      int arrival[] = new int[number];
		  
      System.out.println();	
      System.out.print("Please enter the arrival times of the trains: ");
      for (int i = 0; i < arrival.length; i++) {
	arrival[i] = input.nextInt();
      }
		    
      int departure[] = new int[number];
      System.out.println();	
      System.out.print("Please enter the departure times of the trains: ");
      for (int i = 0; i < departure.length; i++) {
    	departure[i] = input.nextInt();
      }
		    
      int minimumNumberOfPlatforms = minimumNumberOfPlatforms(arrival, departure);
      System.out.println();	
      System.out.print("The minimum number of platforms required for the railway station so that no train waits are: " + minimumNumberOfPlatforms);
      input.close();
    }
  }
