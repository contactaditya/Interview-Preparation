import java.util.*;
import java.io.*;

  class TrieNode6 {
    TrieNode6[] children = null;
    List<Integer> list = null;
    int index;
    public TrieNode6(){
      children = new TrieNode6[26];
      list = new LinkedList<Integer>();
      index = -1;
    }
  }

  public class PalindromePairs {
	  
    public static void addWords(TrieNode6 root, String word, int index) {
      TrieNode6 current = root;
      for (int i = word.length() - 1; i >= 0; i--) {
        char c = word.charAt(i);
	if (current.children[c - 'a'] == null) {
	  current.children[c - 'a'] = new TrieNode6();
	}
	if (isPalindrome(word, 0, i)) {
	  current.list.add(index);
        }
	current = current.children[c - 'a'];
      } 
      current.list.add(index);
      current.index = index;
    }  
	  
    private static boolean isPalindrome(String word, int low, int high) {
      while (low < high) {
        if (word.charAt(low) != word.charAt(high)) {
	  return false;
	}
	low++;
	high--;
      }
	   
      return true;
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();       
	  
      TrieNode6 root = new TrieNode6();
      for (int i = 0; i < words.length; i++) {
        addWords(root, words[i], i);
      }
      
      for (int i = 0; i < words.length; i++) {
        searchWords(root, words[i], i, result);
      }
	  
      return result;
    }  
	  
    private static void searchWords(TrieNode6 root, String word, int index, List<List<Integer>> result) {
      TrieNode6 current = root;
      for (int i = 0; i < word.length(); i++) {
	if (current.index >= 0 && current.index != index && isPalindrome(word, i, word.length()-1)) {
          result.add(Arrays.asList(index, current.index));
        } 
	    
	char c = word.charAt(i);
        if (current.children[c - 'a'] == null) {
          return;
        }
        
        current = current.children[c - 'a'];
      }
	  
      for (int number: current.list) {
        if (index == number) {
          continue;
        }
          
        result.add(Arrays.asList(index, number));
      }
    }

    public static List<List<Integer>> palindromePairs1(String[] words) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();      
      if (words == null || words.length < 2) {
	return result;
      }
      Map<String, Integer> map = new HashMap<String, Integer>();
      for (int i = 0; i < words.length; i++) {
	map.put(words[i], i);
      }
      for (int i = 0; i < words.length; i++) {
	int left = 0, right = 0;
	while (left <= right) {
	  String string = words[i].substring(left, right);
	  Integer j = map.get(new StringBuilder(string).reverse().toString());	
	  if (j != null && i != j && isPalindrome(words[i].substring(left == 0 ? right : 0, left == 0 ? words[i].length() : left))) {
	    result.add(Arrays.asList(left == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));  
	  }
	  if (right < words[i].length()) {
	    right++;
	  }
          else {
            left++;
          }
	}
      }
	  
      return result;
    }	  
	
    public static boolean isPalindrome(String string) {
      for (int i = 0; i < string.length()/2; i++) {
        if(string.charAt(i) != string.charAt(string.length() - 1 - i)) {
	  return false;
	}
      }
      return true;
    }

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      String words[] = new String[numbers];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual values in the array: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	words[i] = input.nextLine(); 
      }
	
      List<List<Integer>> result = new ArrayList<List<Integer>>(); 
      result = palindromePairs(words); 
	   
      System.out.println();
      System.out.print("The palindromes are: ");
      System.out.print('[');
      for(List<Integer> innerList : result) {
        System.out.print(innerList);
      }
      System.out.println(']');
    }
  }
