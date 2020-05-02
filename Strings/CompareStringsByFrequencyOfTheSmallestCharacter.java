import java.util.*;
import java.io.*;

  public class CompareStringsByFrequencyOfTheSmallestCharacter {
	  
	public static int[] numSmallerByFrequency(String queries[], String words[]) {
	  int[] wordsFrequency = new int[11];
	  
	  for(String str : words) {
		int frequency = getFrequency(str);

		for(int i = 1; i < frequency; i++) {
		  wordsFrequency[i]++;
		}
	  }
	  
      int result[] = new int[queries.length];
      int i = 0;
      for(String string : queries) {
		int frequency = getFrequency(string);
		result[i] = wordsFrequency[frequency];
		i++;
	  }
    		
	  return result;      
    }

	private static int getFrequency(String word) {
	  char minC = 'z';
      int count = 0;
      for (char ch : word.toCharArray()) {
        if (ch < minC) {
          minC = ch;
          count = 1;
        } else if (ch == minC) {
          count++;
        }
      }
      
	  return count;
	}

	public static void main(String[] args) {      
	  Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbersA = input.nextInt();   
      String queries[] = new String[numbersA];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual values in the array: ");
      System.out.println();
      for (int i = 0; i < numbersA; i++) {
	    queries[i] = input.nextLine(); 
      }
    
      System.out.println();
      System.out.print("Enter number of elements in the array: ");
      int numbersB = input.nextInt();   
      String words[] = new String[numbersB];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual values in the array: ");
      System.out.println();
      for (int i = 0; i < numbersB; i++) {
    	words[i] = input.nextLine(); 
      }
    
      int result[] = numSmallerByFrequency(queries, words);
      System.out.println();
      System.out.print("The number of words such that f(queries[i]) < f(words) are: ");
      System.out.print("[");	
      for (int word : result) {
    	System.out.print(word + ", ");	   
      }
      System.out.print("]");
      input.close();
	}
  }
