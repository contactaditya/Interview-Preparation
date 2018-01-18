import java.util.*;
import java.util.Stack;
import java.io.*;

  public class Brackets {
    public static char[][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};	  
	 
    public static int isProperlyNested(String string) {
      Stack<Character> stack = new Stack<Character>();
      for(char c : string.toCharArray()) {
        if(isOpenTerm(c)) {
      	  stack.push(c);	  
      	}
      	else {
      	  if(stack.isEmpty() || !matches(stack.pop(), c)) {
      		return 0;
      	  }
      	}
      }
      return stack.empty() ? 1 : 0; 
    }

    private static boolean matches(char openTerm, char closeTerm) {
      for (char[] array: TOKENS) {
        if(array[0] == openTerm) {
	  return array[1] == closeTerm;	
	}  
      }	
      return false;
    }

    private static boolean isOpenTerm(char c) {
      for (char[] array: TOKENS) {
        if(array[0] == c) {
	  return true;	
	}  
      }	
      return false;
    }

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String expression = new String();	
      System.out.print("Please enter an expression with only these characters (){}[]: ");
      expression = input.next();  
		  
      int isProperlyNested = isProperlyNested(expression);
      System.out.println(); 
      if(isProperlyNested == 1) {
	System.out.println("The expression " + expression + " is properly nested.");
      }
      else {
	System.out.println("The expression " + expression + " is not properly nested.");	  
      }
    }
  }
