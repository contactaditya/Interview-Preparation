import java.util.*;
import java.io.*;

  public class GenerateParentheses {
	
    public static List<String> generateParenthesis(int number) {
      List<String> answer = new ArrayList<String>();
      if (number == 0) {
	answer.add("");
      } else {
	for (int c = 0; c < number; c++) {
          for (String left: generateParenthesis(c)) {
            for (String right: generateParenthesis(number-1-c)) {
              answer.add("(" + left + ")" + right);  
            }
          }
	}
      }
	    
      return answer;      
    }

    public static void main(String[] args) { 	  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the number of pairs of parentheses: ");
      int numberOfParentheses = input.nextInt();
	 
      List<String> result = new ArrayList<String>();
      result = generateParenthesis(numberOfParentheses); 
      System.out.println();
      System.out.println("The solution set is: " + result);
    }
  }
