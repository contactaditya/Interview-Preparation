import java.util.*;
import java.io.*;

  public class DivisorGame {
	  
	public static boolean divisorGame(int number) {
	  // According to the rules of the problems even numbers will always win. Odd numbers will give back an even number to your opponent, so odd numbers always lose.
	  return number % 2 == 0;
    }

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();   
		    	   
      boolean divisorGame = divisorGame(number); 
		   
      System.out.println();
      if(divisorGame) {
    	System.out.println("Alice has won the game.");  
      }
      else {
    	System.out.println("Bob has won the game.");    
      }
      input.close();
	}
  }
