import java.util.*;
import java.io.*;

 public class FindTheDifferenceBetweenTwoStrings {    
	 
    public static char findTheDifference(String string1, String string2) {  
      char c = 0;
      for (int i = 0; i < string1.length(); ++i) {
	 c ^= string1.charAt(i);
      } 
      for (int i = 0; i < string2.length(); ++i) {
	 c ^= string2.charAt(i);
      }
      return c;
    }

    public static void main(String[] args) {   
      String string1 = new String();	  	
      Scanner input1 = new Scanner(System.in);
      System.out.print("Enter the string: ");
      string1 = input1.nextLine(); 
	  
      System.out.println();	
      String string2 = new String();	  
      Scanner input2 = new Scanner(System.in);
      System.out.print("Enter the second string: ");
      string2 = input2.next();
	  
      char difference = findTheDifference(string1, string2);
      System.out.println();
      System.out.println("The letter that was added in the second string is: " + difference);
    }
 }
