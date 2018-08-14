import java.util.*;
import java.io.*;

  public class ScoreOfParentheses {
	
	public static int scoreOfParentheses(String string) {
	  int ans = 0, balance = 0;
	  for (int i = 0; i < string.length(); i++) {
		if (string.charAt(i) == '(') {
          balance++;
        } else {
          balance--;
          if (string.charAt(i-1) == '(') {
            ans += 1 << balance;
          }
        }
		  
	  }
		
	  return ans;      
	}

	public static void main(String[] args) {   
	  String string = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  string = input.nextLine(); 
	  	  
	  int result = scoreOfParentheses(string);
	  System.out.println();
	  System.out.println("The score of the string based on the given rules are: " + result);  
	  input.close();
	}
  }
