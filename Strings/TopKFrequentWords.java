import java.util.*;
import java.io.*;

  public class TopKFrequentWords {
	  
	public static List<String> topKFrequent(String[] words, int k) {
	   Map<String, Integer> count = new HashMap<String, Integer>();	
	   for (String word: words) {
         count.put(word, count.getOrDefault(word, 0) + 1);
       }
	   List<String> candidates = new ArrayList(count.keySet());
	   Collections.sort(candidates, (w1, w2) -> count.get(w1) != count.get(w2) ? count.get(w2) - count.get(w1) : w1.compareTo(w2));
	
	   return candidates.subList(0, k);
    }	  

	public static void main(String[] args) { 	  
	   Scanner input = new Scanner(System.in);
	   System.out.print("Enter number of elements in the array: ");
	   int numbers = input.nextInt();   
	   String array[] = new String[numbers];
		    
	   System.out.println();
	   input.nextLine();
	   System.out.print("Please enter the actual values in the array: ");
	   System.out.println();
	   for (int i = 0; i < numbers; i++) {
		 array[i] = input.nextLine(); 
	   }
	   System.out.println();
	   System.out.print("Enter the number of most frequent elements that you want the program to return: ");
	   int k = input.nextInt();  
	   
	   List<String> result = new ArrayList<String>();
	   result = topKFrequent(array, k);
	   System.out.println();
	   System.out.print("The solution set is: " + result);
	}

  }
