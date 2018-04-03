import java.util.*;
import java.io.*;

  public class RemoveKDigits {
	  
	public static String removeKdigits(String number, int k) {  
	  StringBuilder sb = new StringBuilder();
	  for(char c : number.toCharArray()) {
	    while(k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) > c) {
	      sb.setLength(sb.length() - 1);
	      k--;
	    }
	    if(sb.length() != 0 || c != '0') {
	      sb.append(c);  // Only append when it is not leading zero
	    }
	  }
	  if(k >= sb.length()) {
		return "0";
	  }
	  sb.setLength(sb.length() - k);  // use all remaining k
	  return sb.toString();  
	}	  

	public static void main(String[] args) {   
	  Scanner input = new Scanner(System.in);
	  String string = new String();	
	  System.out.print("Enter the string: ");
	  string = input.nextLine();  
	  System.out.println();
	  System.out.print("Enter the number of digits to remove from the number: ");
	  int k = input.nextInt();  
	  String smallestPossibleAfterRemovingKDigits = removeKdigits(string, k);
	  System.out.println();
	  System.out.print("The new number formed which is the smallest possible after removing " + k + " digits from the number " + string + " is: " + smallestPossibleAfterRemovingKDigits);
	}
  }
