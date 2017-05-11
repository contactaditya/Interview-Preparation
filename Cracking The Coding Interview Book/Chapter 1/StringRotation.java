import java.util.*;

public class StringRotation {

  public static boolean isRotation(String string1, String string2) {
     int length = string1.length();
	
     // Check that string 1 and string 2 are equal length and not empty
	  
     if(length == string2.length() && length > 0) {
     // Concatenate string 1 and string 1 within new buffer
       String s1s1 = string1 + string1;
       return isSubstring(s1s1, string2); 
     }	  
   return false;
  }	
  
  public static boolean isSubstring(String big, String small) {
     if (big.indexOf(small) >= 0) {
       return true;
     } else {
       return false;
     }   
  }
  
  public static void main(String[] args) { 
     String string1 = new String();	  
     Scanner input1 = new Scanner(System.in); 
     System.out.print("Enter the first string: ");
     string1 = input1.next();  
	  
     System.out.println();	
     String string2 = new String();	  
     Scanner input2 = new Scanner(System.in);
     System.out.print("Enter the second string: ");
     string2 = input2.next();
	  
     boolean subsequence = isRotation(string1, string2);
	 
     if(subsequence) {
	System.out.println();
	System.out.println("The string can be rotated.");  
     }
     else {
	System.out.println();
	System.out.println("The string cannot be rotated.");  
     }
  }
}
