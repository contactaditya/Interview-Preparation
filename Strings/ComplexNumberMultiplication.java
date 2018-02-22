import java.util.*;
import java.io.*;

  public class ComplexNumberMultiplication {
	 
	public static String complexNumberMultiply(String a, String b) {
      int p1 = a.indexOf('+'), p2 = b.indexOf('+'), n1 = a.length() - 1, n2 = b.length() - 1;
      int x1 = Integer.valueOf(a.substring(0, p1)), y1 = Integer.valueOf(a.substring(p1 + 1, n1));
      int x2 = Integer.valueOf(b.substring(0, p2)), y2 = Integer.valueOf(b.substring(p2 + 1, n2));
      return (x1 * x2 - y1 * y2) + "+" + (x1 * y2 + x2 * y1) + "i";
	}  

	public static void main(String[] args) {    
	  String a = new String();	  
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the first string: ");
	  a = input.nextLine();  
		  
	  System.out.println();	
	  String b = new String();	  
	  System.out.print("Enter the second string: ");
	  b = input.nextLine();  
		  
	  String result = complexNumberMultiply(a, b);
	  System.out.println();
	  System.out.println("The product of the two complex numbers is: " + result);

	}
  }
