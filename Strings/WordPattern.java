import java.util.*;
import java.io.*;

 public class WordPattern {
	 
   public static boolean wordPattern(String pattern, String string) {
     if (pattern == null || string == null) {
       return false;
     }	
     String[] words = string.split(" ");		
     if(words.length != pattern.length()) {
       return false;
     }
     Map<String, Integer> index = new HashMap<String, Integer>();
     for(Integer i=0; i<words.length; i++) {
       if (index.put(pattern.charAt(i) + "*", i) != index.put(words[i], i)) {
	 return false;
       }
     }
     return true;       
   }	 

   public static void main(String[] args) {  	 
     String pattern = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the pattern: ");
     pattern = input.nextLine();  
     System.out.println();	
     String string = new String();	  
     System.out.print("Enter the string: ");
     string = input.nextLine();
		  
     boolean samePattern = wordPattern(pattern, string);
     System.out.println();
     if(samePattern) {
       System.out.println("The string " + string + " follows the same pattern " + pattern);  
     }
     else {
       System.out.println("The string " + string + " does not follow the same pattern " + pattern);  
     }
   }
 }
