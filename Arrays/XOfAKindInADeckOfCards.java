import java.util.*;
import java.io.*;

  public class XOfAKindInADeckOfCards {
	  
	public static boolean hasGroupsSizeX(int[] deck) {
	  Map<Integer, Integer> count = new HashMap<Integer, Integer>();
      int result = 0;
      for (int i : deck) {
    	count.put(i, count.getOrDefault(i, 0) + 1);
      }
      for (int i : count.values()) {
    	result = gcd(i, result);
      }
      return result > 1;  
	}
	
	public static int gcd(int x, int y) {
	  return y > 0 ? gcd(y, x % y) : x;  
	}

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  int deck[] = new int[numbers];
					    
	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
		deck[i] = input.nextInt(); 
	  }
	  boolean result = hasGroupsSizeX(deck);
	  System.out.println();
	  if(result) {
	    System.out.println("It is possible to split the entire deck.");
	  }
	  else {
	 	System.out.println("It is not possible to split the entire deck.");  
	  }
	  input.close();
	}
  }
