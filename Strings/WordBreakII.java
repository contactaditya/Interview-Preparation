import java.util.*;
import java.io.*;

  public class WordBreakII {
	
    public static List<String> wordBreak(String string, List<String> wordDictionary) {
       return DFS(string, wordDictionary, new HashMap<String, List<String>>());    
    }  

    private static List<String> DFS(String string, List<String> wordDictionary, HashMap<String, List<String>> hashMap) {
       if (hashMap.containsKey(string)) {
	 return hashMap.get(string);
       }
	    
       List<String> result = new ArrayList<String>();     
       if (string.length() == 0) {
	 result.add("");
	 return result;
       }
       for (String word : wordDictionary) {
	 if (string.startsWith(word)) {
	   List<String>sublist = DFS(string.substring(word.length()), wordDictionary, hashMap);
	   for (String sub : sublist) {
	     result.add(word + (sub.isEmpty() ? "" : " ") + sub); 
	   }
	 }  
       }       
       hashMap.put(string, result);
       return result;
    }

    public static void main(String[] args) { 	  
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the number of words in the dictionary: ");
       int numberOfWords = input.nextInt();
       System.out.println();
       input.nextLine();
       System.out.println("Please enter the actual words in the dictionary: ");
       ArrayList<String> dictionary = new ArrayList<String>();
       for (int i = 0; i < numberOfWords; i++) {
	 dictionary.add(input.nextLine());
       }		 
       System.out.println();
       String string = new String();	
       System.out.print("Enter a non empty string: ");
       string = input.nextLine();  
       List<String> result = new ArrayList<String>();
       result = wordBreak(string, dictionary); 
       System.out.println();
       System.out.println("The sentence where every word is a valid word is: " + result);
    }
 }
