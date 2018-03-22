import java.util.*;
import java.io.*;

  public class PalindromePartitioning {
	  
    public static List<List<String>> partition(String string) {
      List<List<String>> result = new ArrayList<List<String>>();
      List<String> list = new ArrayList<String>();
      dfs(string, 0, list, result);
      return result;
    }
    
    private static void dfs(String string, int position, List<String> list, List<List<String>> result) {
      if(position == string.length()) {
    	result.add(new ArrayList<String>(list));
      } else {
    	for(int i = position; i < string.length(); i++) {  
    	  if(isPalindrome(string, position, i)) {
            list.add(string.substring(position, i+1));
            dfs(string, i+1, list, result);
            list.remove(list.size()-1);
          }
    	}
      }
    }

    public static boolean isPalindrome(String string, int left, int right) {
      if(left == right) {
    	return true;
      }
      while(left < right) {
        if(string.charAt(left) != string.charAt(right)) {
          return false;
        }
        left++;
        right--;
      }
      return true;
    }
	  
    public static void main(String[] args) {  
      String string = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string = input.next();    
	  
      System.out.println();
      List<List<String>> result = new ArrayList<List<String>>();
	   
      result = partition(string); 
      System.out.println();
      System.out.println("All possible palindrome partitioning of the string are: ");
      System.out.println('[');
      for(List<String> innerList : result) {
	System.out.println(innerList + " ");
      }
      System.out.println(']');
    }
  }  
