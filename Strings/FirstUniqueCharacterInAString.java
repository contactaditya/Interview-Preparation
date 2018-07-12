import java.util.*;
import java.io.*;

 public class FirstUniqueCharacterInAString {
	 
   public static int firstUniqueCharacter(String string) {
     int frequency[] = new int[26];
     for(int i = 0; i < string.length(); i++) {
       frequency[string.charAt(i) - 'a']++;
     }
     for(int i = 0; i < string.length(); i++) {
       if(frequency[string.charAt(i) - 'a'] == 1) {
         return i;
       }
     }
     return -1;
   }	 

   public static void main(String[] args) {	  
     String string = new String();	  
     Scanner input = new Scanner(System.in);
     System.out.print("Enter the string: ");
     string = input.nextLine(); 
     int firstUniqueCharacter = firstUniqueCharacter(string);
     System.out.println();
     System.out.println("The index of the first non-repeating character in the " + string + " is: " + firstUniqueCharacter);  	 
   }
 }
