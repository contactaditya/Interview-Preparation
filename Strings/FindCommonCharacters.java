import java.util.*;
import java.io.*;

public class FindCommonCharacters {

	public static List<String> commonChars(String[] array) {
	  List<String> result = new ArrayList<String>(); 
	  int[] count = new int[26], temp = new int[26];
	  Arrays.fill(count, Integer.MAX_VALUE);
	  for (int i = 0; i < array.length; i++) {
	    for (char c : array[i].toCharArray()) {
		  temp[c - 'a']++;    
	    }
	    // store the minimum character frequency in the count array
	    for(int j = 0; j < 26; j++) {
	      count[j] = Math.min(count[j], temp[j]);
	    }
        Arrays.fill(temp, 0);
	  }
	  
	  for (char c = 'a'; c <= 'z'; ++c) {
	    while (count[c - 'a']-- > 0) {
	      result.add("" + c);
	    } 
	  }
		
	  return result;  
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
	  
      List<String> result = new ArrayList<String>(); 
      result = commonChars(words);
      System.out.println();
      System.out.println("All strings in words which are substring of another word in any order are: " + result);	
      input.close();
	}
  }
