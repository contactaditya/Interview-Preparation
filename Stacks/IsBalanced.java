import java.util.*;
import java.io.*;

 public class IsBalanced {   
   public static char[][] TOKENS = {{'(', ')'}};      

   public static boolean isBalanced(String string) {
     java.util.Stack<Character> stack = new java.util.Stack<Character>();
     for(char c : string.toCharArray()) {
       if(isOpenTerm(c)) {
         stack.push(c);  
       }  
       else {
         if(stack.isEmpty() || !matches(stack.pop(), c)) {
      	    return false;
      	 }   
       }
     }
                 
     return stack.isEmpty();   
   }
   
   public static boolean matches(char openTerm, char closeTerm) {
     for(char[] array : TOKENS) {  
       if(array[0] == openTerm) {
         return array[1] == closeTerm; 
       }    
     }
     return false;
   }
   
   public static boolean isOpenTerm(char c) {
     for(char[] array : TOKENS) {  
       if(array[0] == c) {
          return true; 
       }   
     }
     return false;
   }
   
   public static void main(String[] args) { 	
     Scanner input = new Scanner(System.in); 
     String expression = new String();	
     System.out.print("Please enter an expression with only these characters (): ");
     expression = input.nextLine();
		  
     boolean isProperlyBalanced = isBalanced(expression);
     System.out.println();
     if(isProperlyBalanced) {
       System.out.println("The expression " + expression + " is balanced.");
     }
     else {
       System.out.println("The expression " + expression + " is not balanced.");	  
     }
   }
 }
