import java.util.*;
import java.io.*;

  public class RabbitsInForest {
	  
	public static int numRabbits(int[] answers) {
	  int scores[] = new int[1000], count = 0;
	  // Count the number of rabbits with the same colour in order to know how many "rabbits" with the same color are missing
      for(int num : answers) {
        if(scores[num] == 0 || scores[num] >= num + 1) {
          scores[num] = 1;
          count += num + 1;
        } else {
          scores[num]++;	
        }
      }
      
      return count;   
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

	  int minimumNumberOfRabbits = numRabbits(array);
	  System.out.println();
	  System.out.print("The minimum number of rabbits that could be in the forest are: " + minimumNumberOfRabbits);
	}
  }
