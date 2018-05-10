import java.util.*;
import java.io.*;

  public class NumberOfMatchingSubsequences {  
	static Map<String, Boolean> cache = new HashMap<String, Boolean>(); 
	
	public static int numMatchingSubsequences(String string, String[] words) {
      int count = 0;
	  for (String word : words) {
	    if (isSubSequence(string, word)) {
	      count++;
	    }
	  }
	  return count;   
    }	
	  
	private static boolean isSubSequence(String string, String word) {
	  Boolean bool = cache.get(word);
	  if (bool != null) {
	    return bool;
	  }
	  int index = -1;
	  for (char ch : word.toCharArray()) {
        index = string.indexOf(ch, index + 1);
        if (index == -1) {
          cache.put(word, false);
          return false;
        }
      }
	  cache.put(word, true);
	  return true;
	}

	public static int numMatchingSubsequences1(String string, String[] words) {
	  List<Integer>[] list = new List[128];
	  for(char ch = 'a'; ch <= 'z'; ch++) {
	    list[ch] = new ArrayList<Integer>();
	  }
	  for(int i = 0; i < string.length(); i++) {
	    list[string.charAt(i)].add(i);
	  }
	  int answer = 0;
	  outer: for(String word : words) {
	    int index = -1;
	    for(char ch : word.toCharArray()) {
	      index = find(list[ch], index);
	      if (index == -1) {
	    	continue outer;
	      }
	    }
	    answer++;    
	  }
	  
	  return answer;      
	}	  
	
	private static int find(List<Integer> list, int index) {
	  int left = 0, right = list.size();
	  while(left < right) {
		int	mid = left + ((right - left) / 2);  
	    if (list.get(mid) > index) {
	      right = mid;
	    }
	    else {
	      left = mid + 1;
	    }
	  }
	  
	  return left == list.size() ? -1 : list.get(left);
	}	

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  String string = new String();	
	  System.out.print("Enter the string: ");
	  string = input.nextLine();  
	  System.out.println();
	  System.out.print("Enter number of elements in the dictionary of words: ");
	  int numbers = input.nextInt();   
	  String words[] = new String[numbers];
		    
	  System.out.println();
	  input.nextLine();
	  System.out.print("Please enter the actual words in the dictionary: ");
	  System.out.println();
	  for (int i = 0; i < numbers; i++) {
		words[i] = input.nextLine(); 
	  }
	   
	  int result = numMatchingSubsequences(string, words);
	  System.out.println();
	  System.out.print("The number of words[i] that is a subsequence of " + string + " is: " + result);
	}
  }
