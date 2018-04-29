import java.util.*;
import java.io.*;

  public class ExpressiveWords {
	  
    public static int expressiveWords(String string, String[] words) {
      int result = 0;
      for (String word : words) {
    	if (check(string, word)) {
    	  result++;
    	}
      }
		
      return result;      
    }

    private static boolean check(String string, String word) {
      int i = 0, j = 0, n = string.length(), m = word.length();	
      while (i < n && j < m) {
        while (i < n && j < m && string.charAt(i) == word.charAt(j)) { 
          i++; 
          j++;
        }
        while (i > 0 && i < n && string.charAt(i) == string.charAt(i - 1)) {
          i++;
        }
        if (i < 3 || string.charAt(i - 1) != string.charAt(i - 2) || string.charAt(i - 2) != string.charAt(i - 3)) {
          break;
        }
      }
	   
      return i == n && j == m;
    }

    public static void main(String[] args) { 
      Scanner input = new Scanner(System.in);
      String string = new String();	
      System.out.print("Enter the string: ");
      string = input.nextLine();  
      System.out.println();
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      String words[] = new String[numbers];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual values in the array: ");
      System.out.println();
      for (int i = 0; i < numbers; i++) {
	words[i] = input.nextLine(); 
      }
	  
      int result = expressiveWords(string, words);
      System.out.println();
      System.out.print("The number of words that are stretchy are: " + result);
    }
  }
