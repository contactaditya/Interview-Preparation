import java.io.*;
import java.util.*;

public class checkAnagram {
	
   public static boolean isAnagramString(String string1, String string2) {  
      char[] charArray1 = string1.replaceAll(" ", "").toLowerCase().toCharArray();  
	  char[] charArray2 = string2.replaceAll(" ", "").toLowerCase().toCharArray();  
	  Arrays.sort(charArray1);  
      Arrays.sort(charArray2);  
	  return Arrays.equals(charArray1, charArray2); 		    
    }
   
    public static boolean checkAnagram(String smallString, String largeString) {  
       boolean isAnagramSubString = false;
       for (int i = 0; i < largeString.length() - smallString.length() + 1; i++) {   
    	 if (isAnagramString(smallString, largeString.substring(i, i + smallString.length()))) {  
             isAnagramSubString = true;  
             break;  
         }  
       }  

     return isAnagramSubString;   
    }

	public static void main(String[] args) {  
	  String smallString = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the smaller string: ");
	  smallString = input.nextLine(); 
	  
	  System.out.println();
	  
	  String largeString = new String();	  
	  System.out.print("Enter the second string: ");
	  largeString = input.nextLine(); 
	  
	  boolean checkAnagram = checkAnagram(smallString, largeString);
	  
	  System.out.println();
	  
	  if(checkAnagram) {
		 System.out.print("Anagram of " + smallString + " is substring of " + largeString);
	  } else {
		 System.out.println("Anagram of " + smallString + " is not substring of " + largeString);  
	  }
   }
}
