import java.util.*;
import java.io.*;

  public class ArrangingCoins {
	  
	public static int arrangeCoins(int number) {
	  return (int)((-1 + Math.sqrt(1 + 8 * (long)number)) / 2);
	}	  

	public static void main(String[] args) {    
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of coins: ");
	  int number = input.nextInt();  
		    
	  int numberOfRows = arrangeCoins(number);
	  System.out.println();
	  System.out.println("The total number of full staircase rows that can be formed are: " + numberOfRows);
	}
  }
