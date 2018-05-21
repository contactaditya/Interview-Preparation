import java.util.*;
import java.io.*;

  public class KeyboardRow {
	 
	public static String[] findWords(String[] words) {
      String[] string = new String[] {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
      Map<Character, Integer> map = new HashMap<Character, Integer>();	
      for (int i = 0; i < 3; i++) {
        for(char c : string[i].toCharArray()) {
          map.put(c, i);
        }
      }
      List<String> result = new ArrayList<String>();
      for (String word : words) {
        int c1 = map.get(Character.toUpperCase(word.charAt(0)));
        for (char c : word.toUpperCase().toCharArray()) {
          if (map.get(c) != c1) {
            c1 = -1;
            break;
          }	
        }
        if (c1 != -1) {
          result.add(word);
        }
      }
      
      String[] ans = new String[result.size()];
      for (int i = 0; i < result.size(); i++) {
        ans[i] = result.get(i);
      }
	
	  return ans;      
	}	  

	public static void main(String[] args) { 
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the total number of words: ");
	  int numberOfWords = input.nextInt();   
	  String[] words = new String[numberOfWords];
	    
	  System.out.println(); 
	  System.out.print("Please enter the actual words: ");
	  for(int i = 0; i < numberOfWords; i++) {
		words[i] = input.next(); 
	  }

	  String result[] = findWords(words); 
	  System.out.println(); 
	  System.out.print("The words that can be typed using letters of alphabet on only one row's of American keyboard are: ");
	  for(int i = 0; i < result.length; i++) {
		System.out.print(result[i] + " ");
	  }
	}
  } 
