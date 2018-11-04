import java.util.*;
import java.io.*;

  public class CountWordsThatAppearExactlyTwoTimesInAnArrayOfWords {
	  
	public static int countWords(String string[], int n) { 
	  HashMap<String, Integer> map = new HashMap<String, Integer>(); 
	  for (int i = 0; i < n; i++) {
	    if(map.containsKey(string[i])) { 
          int get = map.get(string[i]); 
          map.put(string[i], get + 1); 
        } else {
          map.put(string[i], 1); 
        }
	  }
	  int result = 0;
	  for (Map.Entry<String, Integer> it : map.entrySet()) { 
        if(it.getValue() == 2) { 
          result++; 
        }
      } 
	  
	  return result;  
    }

	public static void main(String[] args) {  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of words: ");
	  int numbers = input.nextInt();   
	  String words[] = new String[numbers];
		    
	  System.out.println();
	  input.nextLine();
	  System.out.print("Please enter the actual words: ");
	  System.out.println();
	  for (int i = 0; i < numbers; i++) {
		words[i] = input.nextLine(); 
	  }
	  			  
	  int result = countWords(words, words.length);
	  System.out.println();
	  System.out.println("The words that are repeated exactly twice are: " + result);
	  input.close();
	}
  }
