import java.util.*;
import java.io.*;

  public class UniqueMorseCodeWords {
	  
	public static int uniqueMorseRepresentations(String[] words) {
	  String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                                    "....","..",".---","-.-",".-..","--","-.",
                                    "---",".--.","--.-",".-.","...","-","..-",
                                    "...-",".--","-..-","-.--","--.."};     
	  
	  Set<String> seen = new HashSet<String>();
	  for (String word : words) {
        StringBuilder code = new StringBuilder();
        for (char c : word.toCharArray()) {
          code.append(MORSE[c - 'a']);
        }
        seen.add(code.toString());
      }
	  
	  return seen.size();
	}  

	public static void main(String[] args) { 	   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  String words[] = new String[numbers];
		    
	  System.out.println();
	  input.nextLine();
	  System.out.print("Please enter the actual values in the array: ");
	  System.out.println();
	  for (int i = 0; i < numbers; i++) {
		words[i] = input.nextLine(); 
	  }
	   
	  int result = uniqueMorseRepresentations(words);
	  System.out.println();
	  System.out.print("The number of different transformations among all words we have are: " + result);
	}
  }
