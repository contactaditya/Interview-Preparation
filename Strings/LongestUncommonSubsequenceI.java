import java.util.*;
import java.io.*;

 public class LongestUncommonSubsequenceI {
	
    public static int findLUSlength(String a, String b) {
      if (a.equals(b)) {
	 return -1;
      }
      return Math.max(a.length(), b.length());  
    }	 

    public static void main(String[] args) {   
      Scanner input = new Scanner(System.in);	
      String string1 = new String();	  
      System.out.print("Enter the first string: ");
      string1 = input.next();  
	  
      System.out.println();	
      String string2 = new String();	  
      System.out.print("Enter the second string: ");
      string2 = input.next();
	  
      int longestUncommonSubsequence = findLUSlength(string1, string2);
	  
      System.out.println();	
      System.out.println("The longest uncommon subsequence of this group of two strings is: " + longestUncommonSubsequence);	

    }
 }
