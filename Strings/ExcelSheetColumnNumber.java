import java.io.*;
import java.util.*;

  public class ExcelSheetColumnNumber {
	  
    public static int titleToNumber(String string) {
      int number = 0;	
      for(int i=0; i<string.length(); i++) {
	number = 26 * number + (string.charAt(i)-'A') + 1; 
      }
      return number;      
    }	  

    public static void main(String[] args) {
       String string = new String();	  	
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the string: ");
       string = input.next();  
       int result = titleToNumber(string);
       System.out.println();	
       System.out.println("The corresponding column title as it appears in an Excel sheet is: " + result);	
    }
  }
