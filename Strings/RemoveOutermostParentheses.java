import java.util.*;
import java.io.*;

  public class RemoveOutermostParentheses {     
	
	public static String removeOuterParentheses(String string) {
	  StringBuilder result = new StringBuilder();
	  int open = 0, close = 0, start = 0;
	  for(int i = 0; i < string.length(); i++) {
		if(string.charAt(i) == '(') {
		  open++;	
		} else if (string.charAt(i) == ')') {
		  close++;	
		}
		if(open == close) {
		  result.append(string.substring(start + 1, i));
          start = i + 1;	
		}
	  }
	  return result.toString();
    }

	public static void main(String[] args) {     
	  Scanner input = new Scanner(System.in);
      String string = new String();	
      System.out.print("Please enter an string with only these characters (): ");
      string = input.next();  
	  
      String result = removeOuterParentheses(string);
      System.out.println();
      System.out.println("The final string after removing the outermost parentheses of every primitive string in the primitive decomposition of the string is: " + result);
	}
  }
