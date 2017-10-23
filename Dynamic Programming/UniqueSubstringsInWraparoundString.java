import java.util.*;
import java.io.*;

 public class UniqueSubstringsInWraparoundString {
	
	public static int findSubstringInWraproundString(String string) {
	   int[] count = new int[26];	
	   // store longest contiguous substring ends at current position.
       int maxCurrentLength = 0; 
       for (int i = 0; i < string.length(); i++) {
         if (i > 0 && (string.charAt(i) - string.charAt(i - 1) == 1 || (string.charAt(i - 1) - string.charAt(i) == 25))) {
           maxCurrentLength++;
         }
         else {
           maxCurrentLength = 1;
         }
           
         int index = string.charAt(i) - 'a';
         count[index] = Math.max(count[index], maxCurrentLength);
       }
	
       // Sum to get result
       int sum = 0;
       for (int i = 0; i < 26; i++) {
         sum += count[i];
       }
       return sum;     
	} 

	public static void main(String[] args) { 	  
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  int result = findSubstringInWraproundString(string);
	  System.out.println();
	  System.out.println("The number of different non-empty substrings of " + string + " in the string s are: " + result);
	}
 }
