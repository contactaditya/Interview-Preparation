import java.util.*;
import java.io.*;

  public class NumberOfLinesToWriteString {
	  
	public static int[] numberOfLines(int[] widths, String string) {   
	  int lines = 1, width = 0;
	  for (char c: string.toCharArray()) {
        int w = widths[c - 'a'];
        width += w;
        if (width > 100) {
          lines++;
          width = w;
        }
      }
		
	  return new int[]{lines, width};      
	}	  

	public static void main(String[] args) { 	  
	  Scanner input = new Scanner(System.in);
	  int widths[] = new int[26];
	  System.out.print("Please enter the elements in the widths array: ");
	  for (int i = 0; i < 26; i++) {
		widths[i] = input.nextInt();
	  }
	
	  String string = new String();	
	  System.out.println();	
	  System.out.print("Enter the letters of the given string: ");
	  string = input.next();  
	  
	  System.out.println();
	  int[] result = numberOfLines(widths, string);
      System.out.println("The number of lines having at least from one character from string " + string + " is: " + result[0]);	 
      System.out.println();
      System.out.println("The width used by the last such line is: " + result[1]);	 
	}
  }
