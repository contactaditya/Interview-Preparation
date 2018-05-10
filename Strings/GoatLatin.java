import java.util.*;
import java.io.*;

  public class GoatLatin {
	  
	public static String toGoatLatin(String string) {   
	  Set<Character> vowel = new HashSet<Character>();
      for (char c: new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}) {
        vowel.add(c);
      }
      int t = 1;
      StringBuilder answer = new StringBuilder();
      for (String word : string.split(" ")) {
    	char first = word.charAt(0);
    	if (vowel.contains(first)) {
          answer.append(word);
        } else {
          answer.append(word.substring(1));
          answer.append(word.substring(0, 1));	
        } 
    	answer.append("ma");
    	for (int i = 0; i < t; i++) {
          answer.append("a");
    	}
    	t++;
    	answer.append(" ");
      }
		
      answer.deleteCharAt(answer.length() - 1);
      return answer.toString();
    }	  

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  String string = new String();	
	  System.out.print("Enter the sentence: ");
	  string = input.nextLine();  
	  
	  String result = toGoatLatin(string);
	  System.out.println();
	  System.out.print("The final sentence representing the conversion from " + string + " to Goat Latin is: " + result);
	}
  }
