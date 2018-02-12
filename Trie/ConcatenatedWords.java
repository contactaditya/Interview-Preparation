import java.util.*;
import java.io.*;

  class TrieNode4 {
    TrieNode4[] next;
    boolean isWord;
    public final static int ALPHABET_SIZE = 26;

    public TrieNode4() {
      isWord = false;
    }

    public TrieNode4 getNext(int index) {
      if(next == null) {
        next = new TrieNode4[ALPHABET_SIZE];
      }
      if(next[index] == null) {
        next[index] = new TrieNode4();
      }
      return next[index];
    }

    public boolean hasNext(int index) {
      return next != null && next[index] != null;
    }
  }

  public class ConcatenatedWords {
	
	public static List<String> findAllConcatenatedWordsInADictionary(String[] words) {
	  List<String> result = new ArrayList<String>();
      if(words == null || words.length == 0) {
         return result;
      }	
      List<List<String>> list = new ArrayList<>();
      for(String word : words) {
       int length = word.length();
         if(length >= list.size()) {
           for(int i = list.size(); i <= length; i++) {
             list.add(new LinkedList<String>());
           }
         }
         list.get(length).add(word);
      }
      TrieNode4 root = new TrieNode4();
      for(int i = 1; i < list.size(); i++) {
       List<String> subList = list.get(i);
        for(String word : subList) {
          if(isConcatenated(word, root, 0)) {
            result.add(word);
          } else {
            addToTrie(word, root);
          }
        }
      }
		
	  return result;  
	}

	private static void addToTrie(String word, TrieNode4 root) {
	  TrieNode4 node = root;
	  for(int i = 0; i < word.length(); i++) {
        node = node.getNext(word.charAt(i) - 'a');
      }
	  node.isWord = true;
	}

	private static boolean isConcatenated(String word, TrieNode4 root, int start) {
      if(start >= word.length()) {
	    return true;
	  }	
      TrieNode4 node = root;
      for(int i = start; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        if(node.hasNext(index)) {
          node = node.getNext(index);
          if(node.isWord && isConcatenated(word, root, i + 1)) {
            return true;
          }
        } else {
          break;
        }
      }
     
	  return false;
	}

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of words in the list: ");
	  int numbersOfWords = input.nextInt();   
	  String words[] = new String[numbersOfWords];
			    
      System.out.println();
	  input.nextLine();
	  System.out.print("Please enter the actual values in the array: ");
	  System.out.println();
      for (int i = 0; i < numbersOfWords; i++) {
		words[i] = input.nextLine(); 
	  }
	   
	  List<String> result = new ArrayList<String>();
	  result = findAllConcatenatedWordsInADictionary(words);
	  System.out.println();
	  System.out.print("The solution set is: " + result);

	}
  }
