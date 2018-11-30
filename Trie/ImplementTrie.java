import java.util.*;
import java.io.*;

 class TrieNode2 {
   public static int NUMBER_OF_CHARACTERS = 26;
   TrieNode2[] children = new TrieNode2[NUMBER_OF_CHARACTERS];
   int size = 0;
   private boolean isEnd;
		    
   public TrieNode2() {
     children = new TrieNode2[NUMBER_OF_CHARACTERS];	 
   }
   
   public boolean containsKey(char c) {
     return children[c -'a'] != null;
   }
   
   public TrieNode2 get(char c) {
     return children[c -'a'];  
   }
     
   public void put(char c, TrieNode2 node) {
     children[c -'a'] = node;  
   }
   
   public void setEnd() {
     isEnd = true;
   }
   
   public boolean isEnd() {
     return isEnd;
   }
 }  

 public class ImplementTrie {
   TrieNode2 root;
		
   public ImplementTrie() {
     root = new TrieNode2();
   }   
	 
   /** Inserts a word into the trie. */
   public void insert(String word) {
     TrieNode2 node = root;
     for (int i = 0; i < word.length(); i++) {
       char currentCharacter = word.charAt(i);
       if (!node.containsKey(currentCharacter)) {
         node.put(currentCharacter, new TrieNode2());
       }
       node = node.get(currentCharacter);
     }
     node.setEnd();      
   }
	    
   /** Returns if the word is in the trie. */
   public boolean search(String word) {
     TrieNode2 node = searchPrefix(word);
     return node != null && node.isEnd();	
   }
 	    
   private TrieNode2 searchPrefix(String word) {
     TrieNode2 node = root;
     for (int i = 0; i < word.length(); i++) {
       char currentLetter = word.charAt(i);
       if (node.containsKey(currentLetter)) {
	 node = node.get(currentLetter);
       } else {
	 return null;
       }
     }
     return node;
   }

   /** Returns if there is any word in the trie that starts with the given prefix. */
   public boolean startsWith(String prefix) {
     TrieNode2 node = searchPrefix(prefix);
     return node != null;
   }	 

   public static void main(String[] args) {
     ImplementTrie trie = new ImplementTrie();
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
       trie.insert(string);
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
     System.out.println();
     String prefix = new String();	
     System.out.print("Enter the prefix that you want to search: ");
     prefix = input.nextLine();  
     boolean startsWith = trie.startsWith(prefix); 
     System.out.println();
     if(startsWith) {
       System.out.println("There is a word that starts with the given prefix " + prefix);  
     }
     else {
       System.out.println("There is no word that starts with the given prefix " + prefix);
     }
   }
 }
