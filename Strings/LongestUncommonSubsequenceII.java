import java.util.*;
import java.io.*;

  public class LongestUncommonSubsequenceII {
	  
	public static int findLUSlength(String[] string) { 
	  int max = -1;
	  for(int i = 0; i < string.length; i++) {
        int j;
        for(j = 0; j < string.length; j++) {
          if(i != j && isSubsequence(string[i], string[j])) {
            break;
          }
        }	
        if (j == string.length) {
          max = Math.max(max, string[i].length());
        } 
	  }

      return max;      
	}	
	
	public static boolean isSubsequence(String a, String b) {
	  int i = 0;
	  for (int j = 0; j < b.length() && i < a.length(); j++) {
	    if(a.charAt(i) == b.charAt(j)) {
	       i++;
	    }
	  }
	  return i == a.length();
    }
	
	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter number of elements in the dictionary: ");
	  int numbers = input.nextInt();   
	  String string[] = new String[numbers];
		    
	  System.out.println();
	  input.nextLine();
	  System.out.print("Please enter the actual values in the dictionary: ");
	  System.out.println();
	  for (int i = 0; i < numbers; i++) {
		string[i] = input.nextLine(); 
	  }
	  
	  int longestUncommonSubsequence = findLUSlength(string);
	  
      System.out.println();	
      System.out.println("The longest uncommon subsequence of this group of strings is: " + longestUncommonSubsequence);	
	}
  }
