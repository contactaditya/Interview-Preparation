import java.util.*;
import java.io.*;

  public class CountAndSay {
	  
    public static String countAndSay(int number) {
      String s = "1";
      for (int i = 1; i < number; i++) {
	StringBuilder sb = new StringBuilder();
	for (int j = 1, count = 1; j <= s.length(); j++) {
          if (j == s.length() || s.charAt(j - 1) != s.charAt(j)) {
            sb.append(count);
            sb.append(s.charAt(j - 1));
            count = 1;
          } else {
            count++;
          }
        }
	s = sb.toString();
      }
		
      return s;      
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
