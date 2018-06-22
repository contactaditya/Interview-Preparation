import java.util.*;
import java.io.*;

 public class LengthOfLastWord {   

   public static int lengthOfLastWord(String string) {  
     if (string == null || string.length() == 0) {
       return 0;
     }
	 
     int count = 0;
     int length = string.length() - 1;
	 
     // from end of string, eliminate ' ' character
     while (length >= 0 && string.charAt(length) == ' ') {
       length--;
     }
 	
     while (length >= 0 && string.charAt(length) != ' ') {
       count++;
       length--;
     }
	
     return count;
   }

   public static void main(String[] args) { 	  
     String string = new String();	  	 
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the string: ");
     string = input.nextLine(); 
	  
     int length = lengthOfLastWord(string);
     System.out.println();
     System.out.println("The length of the last word in the string is: " + length);
   }
 }
