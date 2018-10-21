import java.io.*;
import java.util.*;

  public class ReverseOnlyLetters {
	  
    public static String reverseOnlyLetters(String string) {
      StringBuilder answer = new StringBuilder();
      int j = string.length() - 1;
      for (int i = 0; i < string.length(); i++) {
        if (Character.isLetter(string.charAt(i))) {  
	  while(!Character.isLetter(string.charAt(j))) {
	    j--; 
	  }
	  answer.append(string.charAt(j--));
	} else {
	  answer.append(string.charAt(i));
	}
      }
		
      return answer.toString();      
    }	  

    public static String reverseOnlyLetters1(String string) {
      java.util.Stack<Character> letters = new java.util.Stack<Character>();
      for (char c : string.toCharArray()) {
        if (Character.isLetter(c)) {
          letters.push(c);
        }
      }
      StringBuilder answer = new StringBuilder();
      for (char c : string.toCharArray()) {
	if (Character.isLetter(c)) {	
	  answer.append(letters.pop());
	} else {
	  answer.append(c);	
	}
      }
      return answer.toString();      
    }	  
	
    public static void main(String[] args) {  
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.nextLine();
		  
      String result = reverseOnlyLetters(string);
      System.out.println();
      System.out.println("The reversed string where all characters that are not a letter stay in the same place, and all letters reverse their positions is: " + result);
      input.close();
    }
  }
