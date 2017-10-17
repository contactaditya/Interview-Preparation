import java.util.*;
import java.io.*;

 public class MinimumWindowSubstring {
	
    public static String minimumWindow(String s, String t) {
       if(s == null || s.length() < t.length() || s.length() == 0) {
	 return "";
       }
	
       int[] map = new int[256];
       char[] String = s.toCharArray();
       char[] checkString = t.toCharArray();
       for(char c : checkString) {
    	 map[c]++;
       }
       int start = 0, end = 0, counter = checkString.length;
       int minimumStart = 0, minimumLength = Integer.MAX_VALUE;
       while(end < String.length) {
    	 if(map[String[end]] > 0) {
           counter--;
    	 }
         map[String[end++]]--;  
         while(counter == 0) {
           if(end-start < minimumLength) {
        	 minimumStart = start;
             minimumLength = end - start;
           }
           map[String[start]]++;
           if(map[String[start]] > 0) {
             counter++;
           }
           start++;
         }
       }
  
       return minimumLength == Integer.MAX_VALUE ? "" : s.substring(minimumStart, minimumStart+minimumLength);     
    }	 

    public static void main(String[] args) { 	 
       String s = new String();	  
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the string: ");
       s = input.next();  
	  
       System.out.println();	
       String t = new String();	  
       System.out.print("Enter the string which you want to check is present in the first string: ");
       t = input.next();
	  
       String result = minimumWindow(s, t);
       System.out.println();	
       System.out.println("The minimum window in "+ s + " which will contain all the characters in " + t + " is: " + result);
	 
    }
 }
