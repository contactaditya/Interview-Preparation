import java.util.*;
import java.io.*;
  
  class TrieNode {
    Character c;
    int frequency;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    	   
    public TrieNode(Character c) {
       this.c = c;
       frequency = 1;
    }
	
    public TrieNode() {
		 
    }
  }  
	  
  public class ShortestUniquePrefixToRepresentEachWord {
    TrieNode root;
	
    public ShortestUniquePrefixToRepresentEachWord() {
      root = new TrieNode();
    }  
	    
    public void insertWord(String word) {
      HashMap<Character, TrieNode> children = root.children;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        TrieNode t;
        if (children.containsKey(c)) {
          t = children.get(c);
          t.frequency++;
        }
        else {
          t = new TrieNode(c);
          children.put(c, t);
        }
        children = t.children;
      }
    }
	
    public String findPrefix(String word) {
       if (word == null || word.length() <= 0) {
	 return null;
       }
       StringBuilder prefix = new StringBuilder();
       HashMap<Character, TrieNode> children = root.children;
       for (int i = 0; i < word.length(); i++) {
         char c = word.charAt(i);
         TrieNode t;
         if (children.containsKey(c)) {
           t = children.get(c);
           children = t.children;
           prefix.append(c);
           if (t.frequency == 1) {
             return prefix.toString();
           }
         }
         else {
           return null;
         }
       } 	 	
       return prefix.toString();
    }	  
	 
    public static ArrayList<String> prefix(ArrayList<String> a) {
       if (a == null || a.size() <= 0) {
    	  return null;    
       }	
       ArrayList<String> result = new ArrayList<>();
       ShortestUniquePrefixToRepresentEachWord trie = new ShortestUniquePrefixToRepresentEachWord();
       for (String word : a) {
          trie.insertWord(word);
       }
       for (String word : a) {
          String prefix = trie.findPrefix(word);
          result.add(prefix);
       }
       return result;
    }	  

    public static void main(String[] args) {  
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
       List<String> result = new ArrayList<String>();
       result = prefix(X);
       System.out.println();
       System.out.println("The solution set with unique prefix is: " + result);
    }
  }
