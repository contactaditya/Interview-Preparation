import java.util.*;
import java.io.*;

  public class WordLadder {
	  
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {   
      HashSet<String> wordDictionary = new HashSet<String>(wordList);
      if(!wordDictionary.contains(endWord)) {
    	return 0;
      }
      HashSet<String> beginSet = new HashSet<String>();
      HashSet<String> endSet = new HashSet<String>();
      HashSet<String> visited = new HashSet<String>();
      int length = 1;
      beginSet.add(beginWord);
      endSet.add(endWord);
      visited.add(beginWord);
      visited.add(endWord);
      while(!beginSet.isEmpty() && !endSet.isEmpty()) {
        if(beginSet.size() > endSet.size()) {
          HashSet<String> tempSet = beginSet;
          beginSet = endSet;
          endSet = tempSet;
        }
        HashSet<String> nextSet = new HashSet<String>();
        for(String word : beginSet) {
          for(int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            for(char c = 'a'; c <= 'z'; c++) {
              sb.setCharAt(i, c);
              String tempString = sb.toString();
              if(endSet.contains(tempString)) {
                return length + 1;
              }
              if(!visited.contains(tempString) && wordDictionary.contains(tempString)) {
                nextSet.add(tempString);
                visited.add(tempString);
              }
            }
          }
        }
        beginSet = nextSet;
        length++;
      }
      return 0; 
    }	  

    public static void main(String[] args) {       
      String beginWord = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the begin word: ");
      beginWord = input.nextLine();  
      System.out.println();	
      String endWord = new String();	  
      System.out.print("Enter the end word: ");
      endWord = input.nextLine();
      System.out.println();	
      System.out.print("Enter the number of words in the word list: ");
      int numberOfWords = input.nextInt();
      System.out.println();
      input.nextLine();
      System.out.println("Please enter the actual words in the word list: ");
      List<String> wordList = new ArrayList<String>();
      for (int i = 0; i < numberOfWords; i++) {
	wordList.add(input.nextLine());
      }		 
	  
      int lengthOfSequence = ladderLength(beginWord, endWord, wordList);
      System.out.println();
      System.out.println("The length of shortest transformation sequence from " + beginWord + " to " + endWord + " is: " + lengthOfSequence);
    }
  }
