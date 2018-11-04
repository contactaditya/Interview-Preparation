import java.util.*;
import java.io.*;

  public class PrintAllAnagramsTogetherInAnArray {
	  
    private static void printAnagrams(String words[]) {
      Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();   
      for (int i = 0; i < words.length; i++) { 
	// Convert to char array, sort and then re-convert to string 
        String word = words[i]; 
        char[] letters = word.toCharArray(); 
        Arrays.sort(letters); 
        String newWord = new String(letters);   
        // Calculate hashcode of string after sorting  
        int n = newWord.hashCode(); 
        if (map.containsKey(n)) { 
          List<String> list = map.get(n); 
          list.add(word); 
          map.put(n, list); 
        } else {
          List<String> list = new ArrayList<String>(); 
          list.add(word); 
          map.put(n, list); 
        }
      }
      System.out.println();
      System.out.print("All the anagrams together are: "); 
      for (Integer i : map.keySet()) { 
        List<String> values = map.get(i); 
        if (values.size() > 1) {
          System.out.print(values); 
        } 
      } 
    }

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);	  
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      String words[] = new String[numbers];
		    
      System.out.println();
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
	words[i] = input.next(); 
      }
	    
      printAnagrams(words); 
      input.close();
    }
  }
