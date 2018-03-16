import java.util.*;
import java.io.*;

  public class CustomSortString { 	
	
	public static String customSortString(String S, String T) {
      int[] count = new int[26];
      // count each char in T.
      for (char c : T.toCharArray()) { 
    	count[c - 'a']++; 
      }  
      StringBuilder sb = new StringBuilder();
      // sort chars both in T and S by the order of S.
      for (char c : S.toCharArray()) {                            
        while (count[c - 'a']-- > 0) { 
          sb.append(c); 
        }    
      }
      // group chars in T but not in S.
      for (char c = 'a'; c <= 'z'; ++c) {
        while (count[c - 'a']-- > 0) { 
          sb.append(c); 
        }   
      }
      
      return sb.toString();      
	}	  
 
	public static void main(String[] args) { 	 
	  String S = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  S = input.nextLine();  
	  System.out.println();	
	  String T = new String();	  
	  System.out.print("Enter the string: ");
	  T = input.nextLine();
		  
	  String sortedString = customSortString(S, T);
	  System.out.println();
	  System.out.println("The string " + T + " sorted in the custom order of string " + S + " is: " + sortedString); 
	}
  }
