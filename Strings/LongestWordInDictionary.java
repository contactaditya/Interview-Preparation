import java.util.*;
import java.io.*;

  public class LongestWordInDictionary {
	  
     public static String longestWord(String[] words) {
	Arrays.sort(words);
	Set<String> built = new HashSet<String>();
	String result = "";
	for (String w : words) {
	  if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
	     result = w.length() > result.length() ? w : result;
	     built.add(w);
	  }
	}
	return result;
     }	  
	
     public static String longestWord1(String[] words) {
	String answer = "";
	Set<String> wordset = new HashSet();
	for (String word: words) {
	  wordset.add(word);
	}
	for (String word: words) {
	  if (word.length() > answer.length() || word.length() == answer.length() && word.compareTo(answer) < 0) {
	    boolean good = true;
	    for (int k = 1; k < word.length(); ++k) {
	      if (!wordset.contains(word.substring(0, k))) {
	        good = false;
	        break;
	      }
	    }
	    if (good) {
	      answer = word;
	    }
	  }    
	}
	return answer;
     }	  
		
     public static void main(String[] args) { 
	Scanner input = new Scanner(System.in);
	System.out.print("Enter number of elements in the array: ");
	int numbers = input.nextInt();   
	String array[] = new String[numbers];
		    
	System.out.println();
	input.nextLine();
	System.out.print("Please enter the actual values in the array: ");
	System.out.println();
	for (int i = 0; i < numbers; i++) {
	   array[i] = input.nextLine(); 
	}
	   
	String result = longestWord(array);
	System.out.println();
	System.out.print("The longest word with the smallest lexicographical order is: " + result);
     }
  }
