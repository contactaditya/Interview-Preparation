import java.util.*;
import java.io.*;

  public class TopKFrequentWords1 {
	  
    public static  String[] topKFrequent(String string, int k) {     
      // Check validity of the input and return an empty string array if input is invalid
      if(k < 0) {
	System.out.println("This is not a valid input. The number of words cannot be negative.");
	return new String[] {};
      }
	    
      // Remove Punctuations and convert the whole string into lower case
      String words[] = string.toLowerCase().trim().replaceAll("[^a-z]+", " ").split(" ");
      Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
	    
      // Count Frequency for each element 
      for(String word: words) {
        if(frequencyMap.containsKey(word)) {
	  frequencyMap.put(word, frequencyMap.get(word)+1);
        } else {
	  frequencyMap.put(word, 1);
	}
      }
	       
      List<String> candidates = new ArrayList<String>(frequencyMap.keySet());
      Collections.sort(candidates, (w1, w2) -> frequencyMap.get(w1) != frequencyMap.get(w2) ? frequencyMap.get(w2) - frequencyMap.get(w1) : w1.compareTo(w2));
	  
      String[] result = new String[k];
      result = candidates.subList(0, k).toArray(result);
	    
      return result;
    }  	  
	  
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String string = new String();	
      System.out.print("Enter the string: ");
      string = input.nextLine();  
      System.out.println();
      System.out.print("Enter the number of most frequent elements that you want the program to return: ");
      int k = input.nextInt();  
      String topKFrequent[] = topKFrequent(string, k);
      System.out.println();
      System.out.print("The solution set is: ");
      for (int i = 0; i < topKFrequent.length; i++) {
	System.out.print(topKFrequent[i] + " ");
      }
    }
  }
