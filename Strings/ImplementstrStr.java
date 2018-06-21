import java.util.*;
import java.io.*;

 public class ImplementstrStr {
	
    public static int strStr(String haystack, String needle) {
      int l1 = haystack.length(), l2 = needle.length();	
      if (needle.isEmpty()) {
	return 0;
      }
      if (l1 < l2) {
        return -1;
      }
	  
      int threshold = l1 - l2;
      for (int i = 0; i <= threshold; ++i) {
        if (haystack.substring(i,i+l2).equals(needle)) {
           return i;
        }
      }
		
      return -1;      
    }

    public static void main(String[] args) {
      String haystack = new String();	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the string which is a haystack: ");
      haystack = input.nextLine();   
      System.out.println();  
      String needle = new String();	  
      System.out.print("Enter the string which is a needle: ");
      needle = input.nextLine(); 
		  
      int firstIndex = strStr(haystack, needle);	
      System.out.println();  
      System.out.println("The index of the first occurrence of " + needle + " in " + haystack + " is: " + firstIndex);    
    }
  }
