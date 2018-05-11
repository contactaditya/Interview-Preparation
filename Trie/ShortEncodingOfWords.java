import java.util.*;
import java.io.*;

  class TrieNode5 {
    TrieNode5[] children;
    int count;
    TrieNode5() {
      children = new TrieNode5[26];
      count = 0;
    }
    public TrieNode5 get(char c) {
      if (children[c-'a'] == null) {
        children[c-'a'] = new TrieNode5();
        count++;
      }
      
      return children[c - 'a'];
    }
  }

  public class ShortEncodingOfWords {
	  
    public static int minimumLengthEncoding(String[] words) {   
      TrieNode5 trie = new TrieNode5();
      Map<TrieNode5, Integer> nodes = new HashMap<TrieNode5, Integer>();
      for (int i = 0; i < words.length; i++) {
        String word = words[i];
        TrieNode5 current = trie;
        for (int j = word.length() - 1; j >= 0; j--) {
          current = current.get(word.charAt(j));
        }
        nodes.put(current, i);
      }
      
      int answer = 0;
      for (TrieNode5 node : nodes.keySet()) {
        if (node.count == 0) {
          answer += words[nodes.get(node)].length() + 1;
        }
      }
      
      return answer;
    }	  

    public static void main(String[] args) { 	 
      Scanner input = new Scanner(System.in); 
      System.out.print("Enter number of words in the list: ");
      int numbers = input.nextInt();   
      String words[] = new String[numbers];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual words: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	words[i] = input.nextLine(); 
      }
      int lengthOfShortestReferenceString = minimumLengthEncoding(words); 
      System.out.println();
      System.out.println("The length of the shortest reference string possible that encodes the given words is: " + lengthOfShortestReferenceString);
    }
  }
