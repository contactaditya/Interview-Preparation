import java.util.*;
import java.io.*;

  public class NimGame {
	  
	public static boolean canWinNim(int number) {
	  if(number % 4 == 0) {
		return false;   
	  }	
	  
	  return true;      
	}

	public static void main(String[] args) {    
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of the stones in the heap: ");
      int number = input.nextInt();   
      boolean canWinNim = canWinNim(number);
      System.out.println();
      if(canWinNim) {
	    System.out.println("Yes you can win the game.");  
      }
      else {
	    System.out.println("No you can not win the game.");  
      }
	}
  }
