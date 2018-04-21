import java.util.*;
import java.io.*;

  public class SortCharactersByFrequencyInAString {
	
    public static String frequencySort(String string) {
      if(string == null || string.length() <= 1) {
        return string;	
      }
      Map<Character, Integer> map = new HashMap<>();
      for (char c : string.toCharArray()) {
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
      }
      List<Character> bucket[] = new List[string.length() + 1];
      for (char key : map.keySet()) {
        int frequency = map.get(key);
        if (bucket[frequency] == null) {
          bucket[frequency] = new ArrayList<>();
        }
        bucket[frequency].add(key);
      }
      StringBuilder sb = new StringBuilder();
      for (int position = bucket.length - 1; position >=0; position--) {
    	if (bucket[position] != null) { 
          for (char num : bucket[position]) {
            for (int i = 0; i < map.get(num); i++) { 
               sb.append(num);	
            }
          }
    	}
      }
    	
      return sb.toString();      
    }	 

    public static void main(String[] args) {   
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.nextLine(); 
      String result = frequencySort(string);
      System.out.println();
      System.out.println("The string in decreasing order based on the frequency of characters is: " + result);
    }
  }
