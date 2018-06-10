import java.util.*;
import java.io.*;

  public class SubstringWithConcatenationOfAllWords {
	  
	public static List<Integer> findSubstring(String string, String[] words) {
	  List<Integer> result = new ArrayList<Integer>();   
      if(words == null || words.length == 0 || string.length() == 0) {
    	return result;
      }
      int wordLength = words[0].length();
      int numWord = words.length;
      int windowLength = wordLength * numWord;
      int stringLength = string.length();
      HashMap<String, Integer> map = new HashMap<String, Integer>();
      for(String word : words) {
    	map.put(word, map.getOrDefault(word, 0) + 1);
      }
      for(int i = 0; i < wordLength; i++) {  
        HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
        for(int j = i, count = 0, start = i; j + wordLength <= stringLength; j += wordLength) {  
          // count: number of exceeded occurences in current window
          // start: start index of current window of size windowLength  
          if(start + windowLength > stringLength) {
        	break;
          }
          String word = string.substring(j, j + wordLength);
          if(!map.containsKey(word)) {
            currentMap.clear();
            count = 0;
            start = j + wordLength;
          }
          else {
            if(j == start + windowLength) { // Remove previous word of current window
              String preWord = string.substring(start, start + wordLength);
              start += wordLength;
              int value = currentMap.get(preWord);
              if(value == 1) {
            	currentMap.remove(preWord);
              }
              else {
            	currentMap.put(preWord, value - 1);
              }
              if(value - 1 >= map.get(preWord)) {
                count--;  // Reduce count of exceeded word
              }
            } 
            // Add new word
            currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
            if(currentMap.get(word) > map.get(word)) {
              count++;  // More than expected, increase count
            }
            // Check if current window valid
            if(count == 0 && start + windowLength == j + wordLength) {
              result.add(start);
            }
          }
        }
      }
    
	  return result;
	}	  

	public static void main(String[] args) {   
      String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine();  
	  System.out.println();	
		  
      System.out.print("Enter number of elements in the array: ");
	  int numbers = input.nextInt();   
	  String words[] = new String[numbers];
		    
	  System.out.println();
	  System.out.print("Please enter the actual values in the array: ");
	  for (int i = 0; i < numbers; i++) {
	    words[i] = input.next(); 
	  }
	      
	  List<Integer> result = new ArrayList<Integer>();
	  result = findSubstring(string, words); 
	  System.out.println();
	  System.out.println("The starting indices of substring(s) in " + string + " that is a concatenation of each word in words exactly once and without any intervening characters is: " + result);		   
	}
  }
