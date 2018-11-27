import java.util.*;
import java.io.*;

  public class CountAndSay {
	  
    public static String countAndSay(int number) {
      if (number == 1) {
	return "1";
      }
      String string = countAndSay(number-1);
      StringBuilder sb = new StringBuilder();
      int count = 0;
      for (int i = 0; i <= string.length(); i++) {
        if (i == string.length() || (i - 1) >= 0 && string.charAt(i - 1) != string.charAt(i)) {
          sb.append(count);
          sb.append(string.charAt(i - 1));
          count = 0;
        }
        count++;
      }
		
      return sb.toString();      
    }	  

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int number = input.nextInt();  
		 		
      String nthTerm = countAndSay(number);
      System.out.println();	
      System.out.print("The nth term of the count-and-say sequence is: " + nthTerm);
    }
  }
