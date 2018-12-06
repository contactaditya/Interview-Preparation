import java.util.*;
import java.io.*;

 public class FindAllAnagramsInAString { 	
	
    public static List<Integer> findAnagrams(String string1, String string2) {
      List<Integer> result = new ArrayList<Integer>();	
      if (string1 == null ||  string1 == null || string1.length() < string2.length()) {
	return result;		
      }
      int m = string1.length(), n = string2.length();
      for (int i = 0; i < m - n + 1; i++) {
        String current = string1.substring(i, i + n);
        if (isAnagram(current, string2)) {
          result.add(i);
        }
      }
	    
      return result;
    }	  
	
    public static boolean isAnagram(String string1, String string2) {  
      if (string1 == null || string2 == null || string1.length() != string2.length()) {
	return false;	
      }
      int[] dictionary = new int[26];
      for (int i = 0; i < string1.length(); i++) {
        char ch = string1.charAt(i);
        dictionary[ch - 'a']++;
      }
      for (int i = 0; i < string2.length(); i++) {
        char ch = string2.charAt(i);
        dictionary[ch - 'a']--;
        if (dictionary[ch - 'a'] < 0) {
          return false;
        }
      }
          
      return true; 		    
    }
	
    public static List<Integer> findAnagrams1(String string1, String string2) {
      List<Integer> result = new ArrayList<Integer>();	
      if (string1 == null ||  string1 == null || string1.length() < string2.length()) {
	return result;		
      }
      int[] letters = new int['z'-'a'+ 1];
      for (int i = 0; i < string2.length(); i++) {
	letters[string2.charAt(i) - 'a']--;
	letters[string1.charAt(i) - 'a']++;
      }
      for (int i = 0; i <= string1.length() - string2.length(); i++) {
	boolean anagram = true;
	for (int j = 0; j < letters.length; j++) {
	  if (letters[j] != 0) {
	    anagram = false;
	    break;
	  }
	}
	if (anagram) {
	  result.add(i);
	}
	if (i < string1.length()) {
	  letters[string1.charAt(i) - 'a']--;
	}
	if (i < string1.length() - string2.length()) {
	  letters[string1.charAt(i + string2.length()) - 'a']++;
	}
      }
      return result;
    }	  	

    public static void main(String[] args) {   
      String string1 = new String();	  
      Scanner input1 = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      string1 = input1.next();  
      System.out.println();	
      String string2 = new String();	  
      Scanner input2 = new Scanner(System.in);
      System.out.print("Enter the second string: ");
      string2 = input2.next();
      List<Integer> result = new ArrayList<Integer>();
      System.out.println();
      result = findAnagrams(string1, string2);
      System.out.println("All the anagrams with the starting indices are: " + result); 
    }
  }
