import java.util.*;
import java.io.*;

 public class ImplementMagicDictionary {
   TrieNode1 root;	  
	 
   /** Initialize your data structure here. */
   public ImplementMagicDictionary() {
     root = new TrieNode1();          
   }
	    
   /** Build a dictionary through a list of words */
   public void buildDictionary(String[] dictionary) {
     for (String string : dictionary) {	
       TrieNode1 node = root;
       for(char c: string.toCharArray()) {
	 if(node.children[c-'a'] == null) {
	   node.children[c-'a'] = new TrieNode1();
	 }
	 node = node.children[c-'a'];
       }
       node.word = string;
     }
   }	
	        
   /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
   public boolean search(String word) {
     char[] array = word.toCharArray();
     for(int i=0;i<array.length;i++) {
       char original = array[i];
       for(char c ='a'; c <= 'z'; c++) {
         if(c!=original) {
	   array[i] = c;
	   if(searchHelper(array,root)) {
	     return true;
	   }
	 }
       }         
       array[i] = original;
     }
     return false;
   }
    
   public boolean searchHelper(char[] array,TrieNode1 root) {
     TrieNode1 current = root;
     for(int i=0; i < array.length;i++) {
       char c = array[i];  
       if(current.children[c-'a'] == null) {
	 return false;  
       }
       current = current.children[c-'a'];
     }
     return current.word!=null;
   }	

   public static void main(String[] args) {
     ImplementMagicDictionary trie = new ImplementMagicDictionary();
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
