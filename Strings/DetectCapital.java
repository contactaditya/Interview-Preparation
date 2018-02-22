import java.util.*;
import java.io.*;

  public class DetectCapital {
	  
    public static boolean detectCapitalUse(String word) {
      int count = 0;
      for(char c: word.toCharArray()) {
	if('Z' - c >= 0) {
	  count++;
	}
      }
      return ((count == 0 || count == word.length()) || (count == 1 && 'Z' - word.charAt(0) >= 0));     
    }  

    public static void main(String[] args) {    
      String word = new String();	   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the word: ");
      word = input.nextLine();  
	    
      boolean detectCapitalUse = detectCapitalUse(word);
      System.out.println();
      if(detectCapitalUse) {
	System.out.println("The usage of capitals in the word is right.");  
      }
      else {
	System.out.println("The usage of capitals in the word is not right.");  
      }
    }
  }
