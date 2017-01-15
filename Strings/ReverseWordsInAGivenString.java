import java.io.*;
import java.util.*;

public class ReverseWordsInAGivenString {
	
   public static String reverseWords(String string) {  
	 if (string == null || string.length() == 0) {
		return "";
	 }
	 
	// Split different words by space
	 String[] array = string.split(" ");
	 StringBuilder sb = new StringBuilder();
	 for (int i = array.length - 1; i >= 0; --i) {
	   if (!array[i].equals("")) {
		  sb.append(array[i]).append(" ");
	   }
	 }
    return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
   }

	public static void main(String[] args) {
	  String string = new String();	  	
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  
	  String reverse = reverseWords(string);
	  System.out.println();
	  System.out.println("The words in reverse order are: " + reverse);

   }
}
