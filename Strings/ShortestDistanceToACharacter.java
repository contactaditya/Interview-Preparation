import java.util.*;
import java.io.*;

  public class ShortestDistanceToACharacter {
	
	public static int[] shortestToChar(String S, char C) {
	  int length = S.length();
	  int answer[] = new int[length];
	  int previous = Integer.MIN_VALUE/2;
	  // Find shortest distant to character on left.
	  for (int i = 0; i < length; i++) {
        if (S.charAt(i) == C) {
          previous = i;
        }
        answer[i] = i - previous;
      }
	  // Find shortest distant to character on right.
	  previous = Integer.MAX_VALUE/2;
      for (int i = length-1; i >= 0; i--) {
        if (S.charAt(i) == C) {
          previous = i;
        }
        answer[i] = Math.min(answer[i], previous - i);
      }
      
	  return answer;  
    }

	public static void main(String[] args) {   
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  System.out.println();
	  System.out.print("Enter the character: ");
	  char C = input.next().charAt(0); 
	  
	  int result[] = shortestToChar(string, C);
	  System.out.println();
	  System.out.println("The array of integers representing the shortest distance from the character C in the string is: ");  
	  for (int i = 0; i < result.length; i++) {
		System.out.print(result[i] + " ");
	  }
	}
  }
