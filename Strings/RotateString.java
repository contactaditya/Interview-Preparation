import java.util.*;
import java.io.*;

  public class RotateString {
	  
	public static boolean rotateString(String A, String B) {
	   return A.length() == B.length() && (A + A).contains(B);      
	}	  

	public static void main(String[] args) {      
	  String A = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the string: ");
	  A = input.nextLine();  
	  System.out.println();	
	  String B = new String();	  
	  System.out.print("Enter the string: ");
	  B = input.nextLine();
		  
	  boolean rotateString = rotateString(A, B);
	  System.out.println();
	  if(rotateString) {
		System.out.println("The string " + A + " can become " + B + " after some number of shifts on " + A);  
	  }
      else {
		System.out.println("The string " + A + " cannot become " + B + " after some number of shifts on " + A);  
	  }
	}
  }
