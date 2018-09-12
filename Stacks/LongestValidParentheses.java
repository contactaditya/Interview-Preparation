import java.io.*;
import java.util.*;
import java.util.Stack;

 public class LongestValidParentheses {
	
   public static int longestValidParentheses(String expression) {
     int longest = 0;
     Stack<Integer> stack = new Stack<Integer>(); 
     stack.push(-1);
     for (int i = 0; i < expression.length(); i++) {
       if (expression.charAt(i) == '(') {
	  stack.push(i);
       } else {
	 stack.pop();
         if (stack.empty()) {
           stack.push(i);
         } else {
           longest = Math.max(longest, i - stack.peek());
         }       
       }
     }
     return longest;
   }

   public static void main(String[] args) {   
     Scanner input = new Scanner(System.in);
     String expression = new String();	
     System.out.print("Please enter an expression with only these characters (): ");
     expression = input.next();  
	  
     int longest = longestValidParentheses(expression);
	 
     System.out.println();
     System.out.println("The length of the largest valid substring of parentheses from a given string is: " + longest);	 
   }
 }

