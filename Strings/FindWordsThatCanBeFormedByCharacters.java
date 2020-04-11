import java.util.*;
import java.io.*;

  public class FindWordsThatCanBeFormedByCharacters {
	
    public static int countCharacters(String[] words, String chars) {
      int result = 0;	
      int charSet[] = new int[26];
      for(int i = 0; i < chars.length(); i++) {
        charSet[chars.charAt(i) - 'a'] ++;
      }
      for (String word : words) {
        int copySet[] = charSet.clone();
        if(wordExist(word, copySet)) {
          result += word.length(); 
        }
      }
      return result;  
    }

	private static boolean wordExist(String word, int[] copySet) {
	  for(int i = 0; i < word.length(); i++) {
		if(copySet[(word.charAt(i) - 'a')] == 0) {
          return false;
		}
        else {
          copySet[(word.charAt(i) - 'a')]--;
        }  
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
	  
	  System.out.println();	
	  String chars = new String();	  
	  System.out.print("Enter the string containing the characters: ");
	  chars = input.next();
	  
	  int countCharacters = countCharacters(words, chars);
	  System.out.println();	
	  System.out.println("The sum of lengths of all good strings in words is: " + countCharacters);
	  
	  input.close();
	}
  }
