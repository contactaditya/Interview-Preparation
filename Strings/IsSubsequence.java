import java.util.*;
import java.io.*;

 public class IsSubsequence {
	 
   public static boolean isSubsequence(String s, String t) {
      if (s.length() == 0) {
	 return true; 
      }
      int indexS = 0, indexT = 0;
      while (indexT < t.length()) {
        if (t.charAt(indexT) == s.charAt(indexS)) {
          indexS++;
          if (indexS == s.length()) {
            return true;
          }
        }
        indexT++;
      }

      return false;     
   }  

   public static void main(String[] args) { 
      String s = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first string: ");
      s = input.next();  
      System.out.println();	
      String t = new String();	  
      System.out.print("Enter the second string: ");
      t = input.next();
	  
      boolean result = isSubsequence(s, t);

      System.out.println();
      if(result) {
	System.out.print("The string " + s + " is subsequence of " + t);	
      }
      else {
	System.out.print("The string " + s + " is not a subsequence of " + t);	
      } 
   }
 }
