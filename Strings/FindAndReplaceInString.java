import java.util.*;
import java.io.*;

  public class FindAndReplaceInString {
	  
	public static String findReplaceString(String string, int[] indexes, String[] sources, String[] targets) {
	  StringBuilder ans = new StringBuilder(string);
      int[] match = new int[string.length()];
      Arrays.fill(match, -1);
      
      for(int i = 0; i < indexes.length; ++i) {
        match[indexes[i]] = i;
      }
      
      for(int i = string.length() - 1; i >= 0; --i) {
        int j = match[i];
        if (j < 0) {
          continue; 
        }
        if (string.substring(indexes[j]).startsWith(sources[j])) {
          ans.replace(indexes[j], indexes[j] + sources[j].length(), targets[j]);
        }
      } 
		
	  return ans.toString();       
	}	  

	public static void main(String[] args) { 	 
	  Scanner input = new Scanner(System.in);
	  String string = new String();	
	  System.out.print("Enter a string: ");
	  string = input.nextLine();  
	  
	  System.out.println();	
      System.out.print("Enter number of elements in the indexes: ");
      int number = input.nextInt();  
      int indexes[] = new int[number];
      
      System.out.println();	
      System.out.print("Please enter the actual indexes: ");
      for (int i = 0; i < indexes.length; i++) {
    	indexes[i] = input.nextInt();
      }
	  
      String sources[] = new String[number];
		    
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual sources: ");
      System.out.println();
      for (int i = 0; i < number; i++) {
	    sources[i] = input.nextLine(); 
      }
      
      String targets[] = new String[number];
      
      System.out.println();
      input.nextLine();
      System.out.print("Please enter the actual targets: ");
      System.out.println();
      for (int i = 0; i < number; i++) {
        targets[i] = input.nextLine(); 
      }
	
	  String result = findReplaceString(string, indexes, sources, targets); 
	  System.out.println();
	  System.out.println("The string after replacement is: " + result);
	}
  }
