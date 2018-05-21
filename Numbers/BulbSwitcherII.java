import java.util.*;
import java.io.*;

  public class BulbSwitcherII { 
	  
	public static int flipLights(int numberOfBulbs, int numberOfOperations) {
	  numberOfBulbs = Math.min(numberOfBulbs, 3);
      if (numberOfOperations == 0) {
    	return 1;
      }
      if (numberOfOperations == 1) {  
    	return numberOfBulbs == 1 ? 2 : numberOfBulbs == 2 ? 3 : 4;
      }
      if (numberOfOperations == 2) {
    	return numberOfBulbs == 1 ? 2 : numberOfBulbs == 2 ? 4 : 7;	
      }
	  return numberOfBulbs == 1 ? 2 : numberOfBulbs == 2 ? 4 : 8;   
    } 	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of bulbs: ");
      int numberOfBulbs = input.nextInt();  
      
      System.out.println();
      System.out.print("Enter the number of unknown operations: ");
      int numberOfOperations = input.nextInt();  
		    
      int result = flipLights(numberOfBulbs, numberOfOperations);
      System.out.println();
      System.out.println("The number of different kinds of status of " + numberOfBulbs + " could be: " + result); 
	}
  }
