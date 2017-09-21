import java.util.*;
import java.io.*;

 public class ImplementMagicDictionary1 {
     HashSet<String> dictionarySet;
	 
      /** Initialize your data structure here. */
     public ImplementMagicDictionary1() {
	dictionarySet = new HashSet<>();   
     }
		    
      /** Build a dictionary through a list of words */
     public void buildDictionary(String[] dictionary) {
	dictionarySet = new HashSet<String>();
	for(String word : dictionary) {
	   dictionarySet.add(word);	
        }
     }	
		        
      /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
     public boolean search(String word) {
        char[] chars = word.toCharArray();
	for(int i = 0; i < chars.length; i++) {
	  char ch = chars[i];
	  for(char c = 'a'; c <= 'z'; c++) {
	    if (c != ch) {
	      chars[i] = c;
	      if (dictionarySet.contains(new String(chars))) {
	        return true;
	      }
	    }
	  }
	chars[i] = ch;
       }
        return false;
     }	 

     public static void main(String[] args) {
        ImplementMagicDictionary1 trie = new ImplementMagicDictionary1();
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the number of words in the list: ");
	int numberOfWords = input.nextInt();
	System.out.println();
	input.nextLine();
	System.out.println("Please enter the actual words in the list: ");
	String[] string = new String[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
	  string[i] = input.nextLine();
	}	  
	trie.buildDictionary(string);
        System.out.println();
        String search = new String();	
	System.out.print("Enter the word that you want to search: ");
	search = input.nextLine();  
	boolean searchResult = trie.search(search); 
	System.out.println();
	if(searchResult) {
	  System.out.println("The word " + search + " is present in the trie.");
	}
	else {
	  System.out.println("The word " + search + " is not present in the trie.");
        }
    }
 }
