import java.util.*;
import java.io.*;

  public class FindTheLongestWordInDictionaryThroughDeleting {
	  
    public static String findLongestWord(String string, List<String> dictionary) {
      String longest = "";
      for (String word : dictionary) {
        if (isSubsequence(word, string)) {
          if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)) {
             longest = word;
          }
	}
      }
      return longest;     
    }	  

    private static boolean isSubsequence(String word, String string) {
      int j = 0;
      for (int i = 0; i < string.length() && j < word.length(); i++) {
	if (word.charAt(j) == string.charAt(i)) {
	   j++;
	}
      }
      return j == word.length();
    }

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of words in the list: ");
      int numberOfWords = input.nextInt();
      System.out.println();
      input.nextLine();
      System.out.println("Please enter the actual words in the list: ");
      List<String> dictionary = new ArrayList<String>();
      for (int i = 0; i < numberOfWords; i++) {
	dictionary.add(input.nextLine());
      }		  
      System.out.println();
      String string = new String();	
      System.out.print("Enter the string: ");
      string = input.nextLine();  
      String longestWord = findLongestWord(string, dictionary);	
      System.out.println();
      System.out.println("The longest word with the smallest lexicographical order is: " + longestWord);
    }
  }
