import java.util.*;
import java.io.*;

  public class SimilarStringGroups {
	  
    public static int numSimilarGroups(String[] array) {  
      if(array == null || array.length == 0) {
        return 0;
      }
      int result = 0;
      for(int i=0; i < array.length; i++){
        if(array[i] == null) {
          continue;
        }
        String string = array[i];
        array[i] = null;
        result++;
        dfs(array, string);
      }
		
      return result;      
    }	  
	
    private static void dfs(String[] array, String string) {
      for(int i=0; i < array.length; i++) {
        if(array[i] == null) {
          continue;
        }
        if(helper(string, array[i])) { // both string str and array[i] belong in same group
          String s = array[i];
          array[i] = null;
          dfs(array,s);
        }
      }	
    }
	
    private static boolean helper(String s, String t) {
      int result = 0, i = 0;
      while(result <= 2 && i < s.length()) {
        if(s.charAt(i) != t.charAt(i)) {
	  result++;
	}
	i++;
      }
	        
      return result == 2;
    }

    public static void main(String[] args) {       
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the array: ");
      int numbers = input.nextInt();   
      String array[] = new String[numbers];
	    
      System.out.println();
      System.out.print("Please enter the actual values in the array: ");
      for (int i = 0; i < numbers; i++) {
        array[i] = input.next(); 
      }
	   
      int result = numSimilarGroups(array);
	   
      System.out.println();
      System.out.print("The number of groups in the list of unique strings are: " + result);	
    }
  }
