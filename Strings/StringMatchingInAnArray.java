import java.util.*;
import java.io.*;

  public class StringMatchingInAnArray {
	  
	public static List<String> stringMatching(String[] words) {
	  HashSet<String> set = new HashSet<String>();
      
      for(int i = 0; i < words.length - 1; i++) {
    	String currentWord = words[i];
    	for(int j = i+1; j < words.length; j++) {
    	  String nextWord = words[j];
    	  if(currentWord.contains(nextWord)) {
            set.add(nextWord);
          }
    	  if(nextWord.contains(currentWord)) {
            set.add(currentWord);
          }
    	}
      }
		
      List<String> result = new ArrayList<String>(set); 	
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
      result = stringMatching(words);
      System.out.println();
      System.out.println("All strings in words which are substring of another word in any order are: " + result);	
      input.close();
	}
  }
