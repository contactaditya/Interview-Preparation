import java.util.*;
import java.io.*;
  
  class TrieNodeNew {
    TrieNodeNew[] children;
    int weight;
    public TrieNodeNew() {
      children = new TrieNodeNew[27];
      weight = 0;
    }
  }

  public class WordFilter {
	TrieNodeNew trie;
	  
	public WordFilter(String[] words) {
	  trie = new TrieNodeNew();
	  for (int weight = 0; weight < words.length; weight++) {
	    String word = words[weight] + "{"; 
	    for (int i = 0; i < word.length(); i++) {
	      TrieNodeNew current = trie;
          current.weight = weight;
          for (int j = i; j < 2 * word.length() - 1; j++) {
            int k = word.charAt(j % word.length()) - 'a';
            if (current.children[k] == null) {
              current.children[k] = new TrieNodeNew();
            }
            current = current.children[k];
            current.weight = weight;
          }
	    }
	  }     
    }
	    
	public int f(String prefix, String suffix) {
	  TrieNodeNew current = trie;
	  for (char letter : (suffix + '{' + prefix).toCharArray()) {
	    if (current.children[letter - 'a'] == null) {
	      return -1;
	    }
	    current = current.children[letter - 'a'];
	  }
	  return current.weight;
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
	  
	  System.out.println();
	  String prefix = new String();	  
      System.out.print("Enter the prefix: ");
	  prefix = input.nextLine();  
	  System.out.println();	
	  String suffix = new String();	  
	  System.out.print("Enter the suffix: ");
	  suffix = input.nextLine();
	  
	  WordFilter object = new WordFilter(words);
	  int result = object.f(prefix,suffix);
	  System.out.println();
	  System.out.println("The word with given prefix and suffix with maximum weight is: " + result);
	}
  }
