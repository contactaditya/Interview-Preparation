import java.util.*;
import java.io.*;

 class TrieNode3 {
    boolean isWord = false;
    TrieNode3[] children = new TrieNode3[26];
 }

 public class ReplaceWords {   
    public TrieNode3 root = new TrieNode3();	
 
    public void insert(String word) {
  	  TrieNode3 node = root;
  	  for(char c: word.toCharArray()) {
  	    if(node.children[c-'a'] == null) {
  	      node.children[c-'a'] = new TrieNode3();
  	    }
  	    node = node.children[c-'a'];
  	  }
  	  node.isWord = true;
  	}
		
	public String search(String word) {
	  int i = 0;
	  TrieNode3 node = root;
	  for(char c: word.toCharArray()) {  
		i++;
	    if(node.children[c-'a'] == null) {
		  return null;
		}
	    else { 
	      node = node.children[c - 'a'];	
	      if (node.isWord) {
            return word.substring(0, i);
          }
	    }
	  }
	  return null;
	}	

    public String replaceWords(List<String> dictionary, String sentence) {
       ReplaceWords	trie = new ReplaceWords();
       for (String word : dictionary) {
         trie.insert(word);
       }	
       String[] words = sentence.split(" ");
       StringBuilder sb = new StringBuilder();
       for (String word : words) {
         String key = search(word);
         if (key == null){
           sb.append(word + " ");
         }
         else{
           sb.append(key + " ");
         }
       }
       return sb.toString().trim();  
	}	 

	public static void main(String[] args) {   
	  ReplaceWords trie = new ReplaceWords();
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
	  for(String string : dictionary) {
	    trie.insert(string);
	  }
	  System.out.println();
	  String sentence = new String();	
	  System.out.print("Enter the sentence: ");
	  sentence = input.nextLine();  
	  String replaceWords = trie.replaceWords(dictionary, sentence); 
	  System.out.println();
	  System.out.println("The sentence after replacing all the successors in the sentence with the root forming it is: " + replaceWords);
	
	}
 }
