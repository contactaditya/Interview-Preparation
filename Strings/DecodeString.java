import java.util.*;
import java.io.*;

  public class DecodeString {
	  
    public static String decodeString(String string) {
      String result = new String();	
      java.util.Stack<Integer> countStack = new java.util.Stack<Integer>();
      java.util.Stack<String> resultStack = new java.util.Stack<String>();
      int index = 0;
      while (index < string.length()) {
	if (Character.isDigit(string.charAt(index))) {
          int count = 0;
          while (Character.isDigit(string.charAt(index))) {
            count = 10 * count + (string.charAt(index) - '0');
            index++;
          }
          countStack.push(count);
        }  
	else if (string.charAt(index) == '[') {
          resultStack.push(result);
          result = "";
          index++;
        }
	else if (string.charAt(index) == ']') {
	  StringBuilder temp = new StringBuilder(resultStack.pop());
          int repeatTimes = countStack.pop();
          for (int i = 0; i < repeatTimes; i++) {
            temp.append(result);
          }
          result = temp.toString();
          index++;
	}
	else {
	  result += string.charAt(index++);
	}
      }
		
      return result;      
    }

    public static void main(String[] args) {
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.nextLine();  
      String result = decodeString(string);
      System.out.println();	
      System.out.println("The decoded string is: " + result);	
    }
  }
