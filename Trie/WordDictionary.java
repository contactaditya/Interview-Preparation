import java.util.*;
import java.io.*;

 public class WordDictionary {
    TrieNode1 root;	 
	 
    /** Initialize your data structure here. */
    public WordDictionary() {
      root = new TrieNode1();     
    }
	    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
      TrieNode1 node = root;
      for(char c: word.toCharArray()) {
       if(node.children[c-'a'] == null) {
    	 node.children[c-'a'] = new TrieNode1();
       }
        node = node.children[c-'a'];
      }
      node.word = word;	     
    }
	    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
      return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] ch, int k, TrieNode1 node) {
      if (k == ch.length) { 
        return !node.word.equals("");   
      }
      if (ch[k] != '.') {
        return node.children[ch[k] - 'a'] != null && match(ch, k + 1, node.children[ch[k] - 'a']);
      } else {
        for (int i = 0; i < node.children.length; i++) {
         if (node.children[i] != null) {
          if (match(ch, k + 1, node.children[i])) {
             return true;
          }
         }
        }
      }
      return false;
    }
	 
    public static void main(String[] args) {   
       WordDictionary trie = new WordDictionary();
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the number of words in the list: ");
       int numberOfWords = input.nextInt();
       System.out.println();
       input.nextLine();
       System.out.println("Please enter the actual words in the list: ");
       ArrayList<String> X = new ArrayList<String>();
       for (int i = 0; i < numberOfWords; i++) {
	 X.add(input.nextLine());
       }		  
       for(String string : X) {
	 trie.addWord(string);
       }
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
