import java.util.*;
import java.io.*;

  public class UncommonWordsFromTwoSentences {
	  
    public static String[] uncommonFromSentences(String A, String B) {
      Map<String, Integer> count = new HashMap<String, Integer>();
      for (String word: A.split(" ")) {
        count.put(word, count.getOrDefault(word, 0) + 1);
      }
      for (String word: B.split(" ")) {
        count.put(word, count.getOrDefault(word, 0) + 1);
      }
      List<String> answer = new LinkedList<String>();
      for (String word: count.keySet()) {
        if (count.get(word) == 1) {
          answer.add(word);
        }
      }
		
      return answer.toArray(new String[answer.size()]);
    }

    public static void main(String[] args) { 	 
      String A = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first sentence: ");
      A = input.nextLine();  
      System.out.println();	
      String B = new String();	  
      System.out.print("Enter the second sentence: ");
      B = input.nextLine();
      String result[] = uncommonFromSentences(A, B);
      System.out.println();	
      System.out.print("A list of all uncommon words is: ");
      System.out.print("[");	
      for (String word : result) {
	System.out.print(word + " ");	   
      }
      System.out.print("]");
    }
  }
