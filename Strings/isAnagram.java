import java.io.*;
import java.util.*;

 public class isAnagram {    
	 
   public static boolean isAnagram(String string1, String string2) {  
     char[] charArray1 = string1.replaceAll(" ", "").toLowerCase().toCharArray();  
     char[] charArray2 = string2.replaceAll(" ", "").toLowerCase().toCharArray();  
     Arrays.sort(charArray1);  
     Arrays.sort(charArray2);  
     return Arrays.equals(charArray1, charArray2); 		    
   }
 
   public static void main(String[] args) {  
     String string1 = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the first string: ");
     string1 = input.nextLine(); 
	  
     System.out.println();
	  
     String string2 = new String();	  
     System.out.print("Enter the second string: ");
     string2 = input.nextLine(); 
	  
     boolean isAnagram = isAnagram(string1, string2);
	  
     System.out.println();
	  
     if(isAnagram) {
       System.out.print("The two strings are anagrams of each other.");  
     } else {
       System.out.print("The two strings are not anagrams of each other.");    
     }
   }
 }
