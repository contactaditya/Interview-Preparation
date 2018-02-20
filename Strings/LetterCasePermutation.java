import java.util.*;
import java.io.*;

  public class LetterCasePermutation {
	  
    public static List<String> letterCasePermutation(String string) {
      List<String> result = new ArrayList<String>();
      dfs(string.toCharArray(), 0, result);
      return result;    
    }  

    private static void dfs(char[] s, int start, List<String> result) {  
      result.add(new String(s));
      for (int i = start; i < s.length; i++) {
        char c = s[i];
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
          s[i] += c > 'Z' ? 'A' - 'a' : -('A' - 'a');
          dfs(s, i + 1, result);
          s[i] -= c > 'Z' ? 'A' - 'a' : -('A' - 'a');
        }
      }
    }

    public static void main(String[] args) {  
      Scanner input = new Scanner(System.in);	
      String string = new String();	
      System.out.print("Enter the string: ");
      string = input.next();  
	  
      List<String> result = new ArrayList<String>();
      result = letterCasePermutation(string); 
      System.out.println();
      System.out.println("A list of all possible strings we could create are: " + result);
    }
  }
