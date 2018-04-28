import java.util.*;
import java.io.*;

  public class LexicographicalNumbers {
	  
	public static List<Integer> lexicalOrder(int number) {
      List<Integer> list = new ArrayList<Integer>();	
	  int current = 1;
	  for (int i = 1; i <= number; i++) {
	    list.add(current);
	    if (current * 10 <= number) {
          current *= 10; // Going to the left most leaf as far as possible
        } else if (current % 10 != 9 && current + 1 <= number) {
          current++; // Found the left most, doing level traversal (all children from left to right)
        } else {
          while((current/10) % 10 == 9) { // We hit the right most node on this level
      	    current /= 10; // Go back to the upper level 
          }
          current = current/10 + 1; // Preparing to do the level traversal again on upper level 
        }
	  }
		  
	  return list;           
	}  

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();   
	
	  List<Integer> result = new ArrayList<Integer>();
	  result = lexicalOrder(number);
	  System.out.println();	
      System.out.print("The integer " + number + " in lexicographical order is: " + result);
	}
  }
