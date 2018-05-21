import java.util.*;
import java.io.*;

  public class BulbSwitcher {
	  
	public static int bulbSwitch(int numberOfBulbs) {
	  return (int) Math.sqrt(numberOfBulbs);   
    }	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of bulbs: ");
      int numberOfBulbs = input.nextInt();  
		    
      int result = bulbSwitch(numberOfBulbs);
      System.out.println();
      System.out.println("The number of bulbs that are on after " + numberOfBulbs + " rounds are: " + result); 
	}
  }
