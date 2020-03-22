import java.util.*;
import java.io.*;

  public class RemoveAllAdjacentDuplicatesInString {
	  
    public static String removeDuplicates(String string) {        
      int i = 0, n = string.length();
      char[] result = string.toCharArray();
      for (int j = 0; j < n; ++j, ++i) {
        result[i] = result[j];
        // If the string contains adjacent duplicates
        if (i > 0 && result[i - 1] == result[i]) { 
          i -= 2;
        }
      }
      return new String(result, 0, i);
    }	  
	  
    public static String removeDuplicates1(String string) {        
      java.util.Stack<Character> stack = new java.util.Stack<Character>();
      for(char s : string.toCharArray()) {
        if(!stack.isEmpty() && stack.peek() == s) {
           stack.pop();
        }
        else {
           stack.push(s);
        }
      }
      StringBuilder sb = new StringBuilder();
      for(char s : stack) {
        sb.append(s); 
      }
     
      return sb.toString(); 
    }

    public static void main(String[] args) { 	  
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.nextLine();  
      String result = removeDuplicates(string);
      System.out.println();
      System.out.println("The new string after removing all adjacent duplicates is: " + result);  
      input.close();
    }
  }
