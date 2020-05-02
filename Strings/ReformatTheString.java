import java.util.*;
import java.io.*;

  public class ReformatTheString {
	  
    public static String reformat(String string) {
      List<Character> digit = new ArrayList<Character>();
      List<Character> letter = new ArrayList<Character>();
      
      for (char c: string.toCharArray()) {
        if (Character.isDigit(c)) {
          digit.add(c);
        }
        if (Character.isLetter(c)) {
          letter.add(c);
        }
      }
      
      StringBuilder result = new StringBuilder();
      
      if (digit.size() - letter.size() == 1) {
        for (int i = 0; i < letter.size(); i++) {
          result.append(digit.get(i));
          result.append(letter.get(i));
        }
        result.append(digit.get(digit.size() - 1));
      }   
      else if (letter.size() - digit.size() == 1) {
        for (int i = 0; i < digit.size(); i++) {
          result.append(letter.get(i));
          result.append(digit.get(i));
        }
        result.append(letter.get(letter.size() - 1));
      }
      else if (digit.size() == letter.size()) {
    	for (int i = 0; i < digit.size(); i++) {
          result.append(letter.get(i));
          result.append(digit.get(i));
        }  
      }
		
      return result.toString();	        
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the alphanumeric string: ");
      String string = input.nextLine();  
			  
      String reformattedString = reformat(string); 
      System.out.println();
      System.out.println("The reformatted string is: " + reformattedString);
      input.close();
    }
  }
