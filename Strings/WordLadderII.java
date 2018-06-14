import java.util.*;
import java.io.*;

  public class WordLadderII {
	  
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      List<List<String>> result = new ArrayList<List<String>>();  
      Set<String> dictionary = new HashSet<String>();
      dictionary.addAll(wordList);	
      if(!dictionary.contains(endWord)) {
        return result;
      }
      Set<String> left = new HashSet<String>();
      Set<String> right = new HashSet<String>();
      left.add(beginWord);
      right.add(endWord);
      Map<String,List<String>> map = new HashMap<String,List<String>>();
      if(!bfs(left, right, dictionary, map, true)) {
        return result;
      }
      List<String> temp = new ArrayList<String>();
      temp.add(beginWord);
      dfs(result, temp, map, beginWord, endWord);
		
      return result;      
    }	  

    private static void dfs(List<List<String>> result, List<String> temp, Map<String, List<String>> map, String beginWord, String endWord) {
      if(beginWord.equals(endWord)) {
	result.add(new ArrayList<String>(temp));
	return;
      }
      if(map.containsKey(beginWord)) {
        for(String string : map.get(beginWord)) { 
          temp.add(string);
          dfs(result, temp, map, string, endWord);
          temp.remove(temp.size() - 1);
        }
      }
    }

    private static boolean bfs(Set<String> left, Set<String> right, Set<String> dictionary, Map<String, List<String>> map, boolean b) {
      if(left.size() > right.size()) {
        return bfs(right, left, dictionary, map, !b);
      }
      dictionary.removeAll(left);
      dictionary.removeAll(right);
      boolean find = false;	
      Set<String> exp = new HashSet<String>();
      for(String string : left) {
    	char[] sa = string.toCharArray();
        for(int i = 0; i < sa.length; i++) {
          char co = sa[i];
          for(char c = 'a'; c <= 'z'; c++) {
            if(c == co) {
              continue;
            }
            sa[i] = c;
            String temp = new String(sa);
            if(right.contains(temp) || (!find && dictionary.contains(temp))) {
              if(right.contains(temp)) {
                find = true;
              }
              String key = b ? string : temp;
              String value = b ? temp : string;
              exp.add(temp);
              if(!map.containsKey(key)) {
            	map.put(key, new ArrayList<String>());
              }
              map.get(key).add(value);
            }
          }
          sa[i] = co;
        }  
      }
		
      if(find) {
        return true;
      } else if (!exp.isEmpty()) {
        return bfs(exp, right, dictionary, map, b);
      } else {
        return false;
      }
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
	  
      List<List<String>> result = new ArrayList<List<String>>(); 
      result = findLadders(beginWord, endWord, wordList); 
		   
      System.out.println();
      System.out.println("A solution set is: ");
      System.out.println('[');
      for(List<String> innerList : result) {
	System.out.println(" " + innerList);
      }
      System.out.println(']');
    }
  }
