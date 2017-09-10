import java.io.*;
import java.util.*;

 public class ReverseOrderOfCharactersInEachWordWithinASentence {  
	 
  public static String reverseWords(String string) {  
     if (string == null || string.length() == 0) {
        return "";
     }
	 
     // Split different words by space
     String[] array = string.split(" ");
     StringBuffer sb = new StringBuffer();
     for (String s : array) { 
	StringBuffer temp = new StringBuffer(s);  
	sb.append(temp.reverse());
        sb.append(" ");
     }
     sb.setLength(sb.length()-1);
     return sb.toString().trim();
  }

  public static void main(String[] args) { 
     String string = new String();	  	
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the string: ");
     string = input.nextLine(); 
	  
     String reverse = reverseWords(string);
     System.out.println();
     System.out.println("The string in reverse order of characters in each word within a sentence is: " + reverse);
  } 
}
