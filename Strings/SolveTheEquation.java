import java.util.*;
import java.io.*;

  public class SolveTheEquation {
	  
	public static String solveEquation(String equation) {
       String[] lr = equation.split("=");	
       int lhs = 0, rhs = 0;
       for (String x: breakIt(lr[0])) {
         if (x.indexOf("x") >= 0) {
           lhs += Integer.parseInt(coefficient(x));
         } else {
           rhs -= Integer.parseInt(x);
         }
       }
       for (String x: breakIt(lr[1])) {
         if (x.indexOf("x") >= 0) {
           lhs -= Integer.parseInt(coefficient(x));
         } else {
           rhs += Integer.parseInt(x);
         }
       }
       // In case of infinite solutions, both the effective lhs and rhs turns out to be zero
       if (lhs == 0) {
         if (rhs == 0) {
           return "Infinite solutions";
         }
         // In case of no solution, the coefficient of x(lhs) turns out to be zero, but the effective number on the rhs is non-zero.
         else {
           return "No solution";
         }
       }
       // In case of a unique solution, the ratio of the effective rhs and lhs gives the required result
	   return "x=" + rhs/lhs;      
	}	  

	private static List<String> breakIt(String string) {
	   List<String> result = new ArrayList<String>();
       String r = "";
       for (int i = 0; i < string.length(); i++) {
    	 if (string.charAt(i) == '+' || string.charAt(i) == '-') {
           if (r.length() > 0) {
             result.add(r);
           }
           r = "" + string.charAt(i);
         } else {
           r += string.charAt(i);
         } 
       }
       
       result.add(r);
       return result;
	}

	private static String coefficient(String x) {
	   if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9') {
          return x.replace("x", "");
	   }
		
	   return x.replace("x", "1");
	}

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  String equation = new String();	
	  System.out.print("Enter the equation: ");
	  equation = input.nextLine();  
	  String solution = solveEquation(equation); 
	  System.out.println();
	  System.out.println("The solution of the equation " + equation + " is: " + solution);
	  
	}
  }
