import java.util.*;
import java.io.*;

  public class FindAndReplacePattern {
	
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
	  List<String> result = new ArrayList<String>();
	  for (String word : words) {
        if (match(word, pattern)) {
          result.add(word);
        }
	  }
       
	  return result;
	}

	private static boolean match(String word, String pattern) {
	  Map<Character, Character> map = new HashMap<Character, Character>();
	  for (int i = 0; i < word.length(); i++) {
		char w = word.charAt(i);
        char p = pattern.charAt(i);  
        if (!map.containsKey(w)) {
          map.put(w, p);  
        }
        if (map.get(w) != p) {
          return false;
        }
	  }
	  
	  boolean[] seen = new boolean[26];
	  for (char p : map.values()) {
        if (seen[p - 'a']) {
          return false;
        }
        seen[p - 'a'] = true;
      }
		
	  return true;
	}

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of words: ");
	  int numbers = input.nextInt();   
	  String words[] = new String[numbers];
		    
	  System.out.println();
	  input.nextLine();
	  System.out.print("Please enter the actual words: ");
	  System.out.println();
	  for (int i = 0; i < numbers; i++) {
		words[i] = input.nextLine(); 
	  }
	  String pattern = new String();	  	
	  System.out.println();
	  System.out.print("Enter the pattern: ");
	  pattern = input.nextLine(); 
	  
	  System.out.println();
	  
	  List<String> result = findAndReplacePattern(words, pattern);
	  System.out.println();
	  System.out.println("A list of the words in words that match the given pattern are: " + result);
	}
  }
