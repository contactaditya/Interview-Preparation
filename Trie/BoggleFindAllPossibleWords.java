import java.util.*;
import java.io.*;
 
 class TrieNode1 {
   public TrieNode1[] children = new TrieNode1[26];
   public String word = "";
 }
  
 class Trie {
   public TrieNode1 root = new TrieNode1();	
	
   public void insert(String word) {
     TrieNode1 node = root;
     for(char c: word.toCharArray()) {
       if(node.children[c-'A'] == null) {
	 node.children[c-'A'] = new TrieNode1();
       }
      node = node.children[c-'A'];
     }
     node.word = word;
   }
	
   public boolean search(String word) {
     TrieNode1 node = root;
     for(char c: word.toCharArray()) {
       if(node.children[c-'A'] == null) {
	 return false;
       }
       node = node.children[c-'A']; 
     }
     if(node.word.equals(word)) {
       return true;
     } else {
       return false;
     }
   }
	
   public boolean startsWith(String prefix) {
     TrieNode1 node = root;
     for(char c: prefix.toCharArray()) {
       if(node.children[c-'A'] == null) {
         return false;  
       }
       node = node.children[c-'A'];
     }
     return true;
   }	
 }

 public class BoggleFindAllPossibleWords {
    Set<String> result = new HashSet<String>(); 	
	  
    public List<String> findWords(char boggle[][], String[] words) {
       Trie trie = new Trie();
       for(String word: words) {
         trie.insert(word);
       }
	   
       int m = boggle.length;
       int n = boggle[0].length;
	 
       boolean[][] visited = new boolean[m][n];
	 
       // Consider every character and look for all words starting with this character  
       for (int i=0; i<m; i++) {
	 for (int j=0; j<n; j++) {
	   dfs(boggle, visited, "", i, j, trie);
	 }
       }
       return new ArrayList<String>(result);
    }
	
    public void dfs(char[][] boggle, boolean[][] visited, String string, int i, int j, Trie trie) {
      int m = boggle.length;
      int n = boggle[0].length; 	
      
      if(i < 0 || j < 0 || i >= m || j >= n) {
         return;
      }
      
      if(visited[i][j]) {
         return;
      }
      
      string = string + boggle[i][j];
      
      if(!trie.startsWith(string)) {
        return;
      }
      
      if(trie.search(string)){
        result.add(string);
      }
      
      visited[i][j] = true;
      dfs(boggle, visited, string, i-1, j, trie);
      dfs(boggle, visited, string, i+1, j, trie);
      dfs(boggle, visited, string, i, j-1, trie);
      dfs(boggle, visited, string, i, j+1, trie);
      visited[i][j] = false;     
    }
	
    public static void main(String[] args) { 
      String dictionary[] = {"OATH", "PEA", "EAT", "RAIN"};	
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of rows in the board: ");
      int rows = input.nextInt();  
      System.out.println();	
      System.out.print("Enter number of columns in the board: ");
      int columns = input.nextInt();  
	 
      char boggle[][] = new char[rows][columns];
				
      System.out.println();	
      System.out.println("Please enter the elements in the boggle array: ");
      for (int i = 0; i < rows; i++) {
	for (int j = 0; j < columns; j++) {
	  boggle[i][j] = input.next().charAt(0);
	}
      }
	  
      List<String> result = new ArrayList<String>();	
      BoggleFindAllPossibleWords words = new BoggleFindAllPossibleWords(); 
	  
      result = words.findWords(boggle, dictionary);
      System.out.println();
      System.out.println("All the possible words that can be formed by a sequence of adjacent characters are: " + result);
    }
  }
