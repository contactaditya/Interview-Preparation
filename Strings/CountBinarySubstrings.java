import java.util.*;
import java.io.*;

  public class CountBinarySubstrings {
	  
	public static int countBinarySubstrings(String string) {
      int count = 0, previous = 0, current = 1;	
	  for (int i = 1; i < string.length(); i++) {
		if (string.charAt(i-1) != string.charAt(i)) {
		  count += Math.min(previous, current);
          previous = current;
          current = 1;  
		} else {
		  current++;
		}
	  }
		
	  return count + Math.min(previous, current);       
	} 

	public static void main(String[] args) {    
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine();  
		  
	  int countBinarySubstrings = countBinarySubstrings(string);
	  System.out.println();
	  System.out.println("The number of non-empty (contiguous) substrings that have the same number of 0's and 1's are: " + countBinarySubstrings);  
	}
  }
